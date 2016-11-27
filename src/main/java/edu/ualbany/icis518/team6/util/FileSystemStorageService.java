package edu.ualbany.icis518.team6.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.servlet.http.Part;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;
    private final String baseLocationString;
    private final String publicLocationString;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
        this.baseLocationString = properties.getBaseLocation();
        this.publicLocationString = properties.getPublicLocation();
    }

    @Override
    public String getStoredFileName(Part file) {
    	return  publicLocationString + "/" + file.getSubmittedFileName().replaceAll("\\s+", "_");
    }
    
    @Override
    public void store(Part file) {
        try {
            if (file.getSize() == 0) {
                throw new StorageException("Failed to store empty file " + file.getSubmittedFileName());
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(getStoredFileName(file)));
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + getStoredFileName(file), e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
    
    @Override
    public void delete(String fileName) {
    	try {
			Path path = Paths.get(baseLocationString + fileName);
    	    Files.delete(path);
    	} catch (NoSuchFileException x) {
    	    System.err.format("%s: no such" + " file or directory%n", fileName);
    	} catch (DirectoryNotEmptyException x) {
    	    System.err.format("%s not empty%n", fileName);
    	} catch (IOException x) {
    	    // File permission problems are caught here.
    	    System.err.println(x);
    	} catch (InvalidPathException e) {
    		System.err.println("Invalid Path: " + fileName);
    	}

    }

    @Override
    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}

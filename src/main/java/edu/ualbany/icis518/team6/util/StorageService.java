package edu.ualbany.icis518.team6.util;

import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

import javax.servlet.http.Part;

public interface StorageService {

    void init();

    void store(Part file);
    
    String getStoredFileName(Part file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
    
    void delete(String fileName);

}

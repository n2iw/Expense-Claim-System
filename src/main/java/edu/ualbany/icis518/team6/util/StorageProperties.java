package edu.ualbany.icis518.team6.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "src/main/webapp";
    private String publicLocaltion = "/receipts";

    public String getLocation() {
        return location + publicLocaltion;
    }
    
    public String getPublicLocation() {
    	return publicLocaltion;
    }
    public String getBaseLocation() {
    	return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

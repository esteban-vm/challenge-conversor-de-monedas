package com.estebanvm.conversor.configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "src/config.properties";
    private final Properties properties;

    public Config() {
        properties = new Properties();

        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Error cargando archivo de configuración:");
            System.out.println(e.getMessage());
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}

package io.swagger.petstore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Constants {
    Constants(){

    }

    public static final String ENDPOINT_PET = "v2/pet/";
    public static final Logger logger = LoggerFactory.getLogger(Constants.class);
    public static String readJsonFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}

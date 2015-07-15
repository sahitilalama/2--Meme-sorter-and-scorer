package com.tek;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {
	
	public Memes getJson() {
		try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("memes.json").getFile());
            ObjectMapper objectMapper = new ObjectMapper();
            
            Memes memesObj = objectMapper.readValue(file, Memes.class);
            return memesObj;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}

}

package com.tek;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderByMemesTest {

	@Test
	public void readJson() throws JsonParseException, JsonMappingException,
			IOException {
		ReadJson rJson = new ReadJson();
		Memes memesObj = rJson.getJson();

		// Sort the Json with Name.
		Collections.sort(memesObj.getListMemes(), new LulzComparator());
		
		System.out
		.println("Order of Memes after sorting by Name is");
		
		// Set the lulz.
		Random randNum = new Random();
		for(int i=0;i<memesObj.getListMemes().size();i++){
			memesObj.getListMemes().get(i).setLulz(randNum.nextInt(10)+1);
		}
		
		for(MemesObj e:memesObj.getListMemes() ){
			System.out.println(e.getName());
			System.out.println(e.getLulz());
		}
		
		// Write to the json file.
		ObjectMapper mapper = new ObjectMapper();
	      try
	      {
	         mapper.writeValue(new File("src/main/resources/memes.json"), memesObj);
	      } catch (JsonGenerationException e)
	      {
	         e.printStackTrace();
	      } catch (JsonMappingException e)
	      {
	         e.printStackTrace();
	      } catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	}

}
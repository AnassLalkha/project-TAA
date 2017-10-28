package istic.taa.project.helpers;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ParserHelper {
	private static ParserHelper instance;
	private static final Logger LOG =  org.apache.log4j.Logger.getLogger(ParserHelper.class);
	public static ParserHelper getInstance() {
		if(instance == null) {
			instance = new ParserHelper();
		}
		return instance;
	}
	
	public <T> T fromStrToObj(String stream, Class<T> clazz) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(stream, clazz);
		} catch (JsonParseException e) {
			LOG.error("Parsing error when trying to deserialize stream : " + stream, e);
		} catch (JsonMappingException e) {
			LOG.error("Mapping error when trying to deserialize stream : " + stream, e);

		} catch (IOException e) {
			LOG.error("IOException error when trying to deserialize stream : " + stream, e);

		}
		return null;
	}
	
	public <T> T fromStrToObj (String stream, TypeReference<T> reference) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(stream, reference);
		} catch (JsonParseException e) {
			LOG.error("Parsing error when trying to deserialize stream : " + stream, e);
		} catch (JsonMappingException e) {
			LOG.error("Mapping error when trying to deserialize stream : " + stream, e);

		} catch (IOException e) {
			LOG.error("IOException error when trying to deserialize stream : " + stream, e);

		}
		return null;
	}

}

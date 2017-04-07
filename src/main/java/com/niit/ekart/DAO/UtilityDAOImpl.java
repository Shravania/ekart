package com.niit.ekart.DAO;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

@Service("utilityService")
public class UtilityDAOImpl implements UtilityDAO{
	public String getJson(List items) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
        String jsonData="";
        try {
			jsonData=mapper.writeValueAsString(items);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //System.out.println(jsonData);
      		return jsonData;
}
	
}
package com.hibernate.dao;
import net.sf.json.JSONObject;

public class JsonArray {

	   public static void main(String args[]){  
	    boolean t=true;
	  
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("phone", "12345");
	        jsonObject.put("identifier", "1");
	        jsonObject.put("password", "12345");
	      
	        System.out.println(jsonObject);
	    }  
	
	}  
	  
	


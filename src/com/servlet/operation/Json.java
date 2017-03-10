package com.servlet.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Json
 */
@WebServlet("/Json")
public class Json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        String acceptjson = "";  
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(  
                    (ServletInputStream) request.getInputStream(), "utf-8"));  
            StringBuffer sb = new StringBuffer("");  
            String temp;  
            while ((temp = br.readLine()) != null) {  
                sb.append(temp);  
            }  
            br.close();  
            acceptjson = sb.toString();  
            if (acceptjson != "") {  
                JSONObject jo = JSONObject.fromObject(acceptjson);  
              
                JSONArray infArray = jo.getJSONArray("BasicInfo");  
               
                JSONObject infObject = JSONObject.fromObject(infArray.get(0));  
                
               String mobile= (String) infObject.get("phone");
               String user_password=(String) infObject.get("password");
               
               Dao.save(user_password,mobile);

                System.out.println("接收json数据成功");  
            }  else{
            	System.out.println("参数为空");
            }
           
        } catch (Exception e) {  
            e.printStackTrace();  
          
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

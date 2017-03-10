package com.servlet.operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JScrollPane;

import org.hibernate.engine.transaction.spi.IsolationDelegate;

import com.hibernate.dao.Dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class TestRegister
 */
@WebServlet("/TestRegister")
public class TestRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.setCharacterEncoding("Utf-8");
		response.setCharacterEncoding("Utf-8"); 
		 response.setContentType("text/html;charset=Utf-8");
		try{
			
		String phone=request.getParameter("phone");
		
		String user_password=request.getParameter("password");
		System.out.println(phone+":"+user_password);
	    
	    if( user_password.equals("") | phone.equals("")){
	    	
	    	response.setHeader("Content-type", "text/html;charset=Utf-8");  
	  	    response.reset();	    	
	    	PrintWriter out=response.getWriter();
	    	out.println("数据不完整没有录入数据库".getBytes("Utf-8"));
	    	out.flush();
	    	out.close();

	    }else{
	    	//保存数据
	    boolean isSuccessful= Dao.save(phone,user_password);
	   
	    
	    // int a=Integer.parseInt(phone);//String 转int
	    
	     JSONObject js = new JSONObject();
	    
	    	 js.put("isSuccessful", isSuccessful);
	    	  js.put("phone", phone);
	    	  js.put("password", user_password);
	      System.out.println(js);
	        
	     PrintWriter out=response.getWriter();    	
	    	out.println(js);
	    
	    	out.flush();
	    	out.close();
	  
	    }
		}catch(Exception e){
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

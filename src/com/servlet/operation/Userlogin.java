package com.servlet.operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dao.Dao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Userlogin
 */
@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlogin() {
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
		
			
		String phone=request.getParameter("phone");
		String user_password=request.getParameter("password");
		
		boolean isSuccessful=false;
		 if( !user_password.equals("") && !phone.equals("")){
			 System.out.println("开始查询");
			isSuccessful= Dao.query(phone, user_password);
			 
			//返回json
			 JSONObject js = new JSONObject();
		    
		    	 js.put("isSuccessful", isSuccessful);
		    	  js.put("phone", phone);
		    	  js.put("password", user_password);
		      System.out.println(js);
		        
		     PrintWriter out=response.getWriter();    	
		    	out.println(js);
		    	out.flush();
		    	out.close();
		 }else{
			 System.out.println("账号或密码为空");
			
		 }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

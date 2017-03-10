package com.servlet.operation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =null;
		int id=Integer.parseInt(request.getParameter("identifier"));
		
		switch (id) {
		case 0://login

			dispatcher = request.getRequestDispatcher("/Userlogin");
		    if (dispatcher != null){
		      dispatcher.forward(request,response);
		      System.out.println("servlet��ת�ɹ�");
		    }
		    else{System.out.println(id+"dispatcherΪ��");}
			break;
		case 1://register
		        dispatcher = request.getRequestDispatcher("/TestRegister");
		    if (dispatcher != null){
		      dispatcher.forward(request,response);
		      System.out.println("servlet��ת�ɹ�");  
		    }
		    else{System.out.println(id+"dispatcherΪ��");}
			break;
		default:
			break;
		}
		System.out.println("����servlet���ձ�ʶ����:"+id);
		

		
		
		
		
}
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

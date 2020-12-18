package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.FileHelper;


@WebServlet("/Themaudiohinhanhdethi")
public class Themaudiohinhanhdethi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Themaudiohinhanhdethi() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Themaudiohinhanhdethi.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String test = FileHelper.uploadFile("Imageaudiodethi/", request);
		
		response.setContentType("text/html; charset=UTF-8");
		
		if (test.equals("Success"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Hienthidsquanlydethi?pageid=1");
			rd.forward(request,response);	
		}
		else 
		{
			request.setAttribute("msgthemaudiohinhanhdethi",test);
	    	RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Themaudiohinhanhdethi.jsp");
			rd.forward(request,response);		 
		}
	}

}

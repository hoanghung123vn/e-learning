package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExerciseDao;
import dao.impl.ExerciseDaoImpl;
import helper.FileHelper;


@WebServlet("/Themcauhoibtdoc")
public class Themcauhoibtdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ExerciseDao exerciseDao;
   
    public Themcauhoibtdoc() {
        super();
        exerciseDao = new ExerciseDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String readexeriseid = request.getParameter("readexeriseid");
		request.setAttribute("readexeriseid",readexeriseid);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Themcauhoibtdoc.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String readexeriseidstr = request.getParameter("readexeriseid");
		int readexeriseid = Integer.parseInt(readexeriseidstr);
		String test = "init";
		response.setContentType("text/html; charset=UTF-8");
		
		FileHelper.readExcelFile("Imageandfilebtdoc/", request, readexeriseid);
		
		if (test.equals("Success"))
		{
			exerciseDao.checkedExercis(readexeriseid); 
			RequestDispatcher rd = request.getRequestDispatcher("Hienthidsbtdoc?pageid=1");
			rd.forward(request,response);	
		}
		else 
		{
			request.setAttribute("msgthemcauhoibtdoc",test);
			request.setAttribute("readexeriseid", readexeriseid);
	    	RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Themcauhoibtdoc.jsp");
			rd.forward(request,response);		 
		}
	}

}

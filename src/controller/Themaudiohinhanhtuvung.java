package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import helper.FileHelper;


@WebServlet("/Themaudiohinhanhtuvung")
public class Themaudiohinhanhtuvung extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
  
    public Themaudiohinhanhtuvung() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Themaudiohinhanhtuvung.jsp");
		rd.forward(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String test = FileHelper.uploadFile("Imageaudiohdtuvung/", request);
		
		response.setContentType("text/html; charset=UTF-8");
		
		if (test.equals("Success"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Hienthidstuvung?pageid=1");
			rd.forward(request,response);	
		}
		else 
		{
			request.setAttribute("msgthemaudiohinhanhtuvung",test);
	    	RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Themaudiohinhanhtuvung.jsp");
			rd.forward(request,response);		 
		}
	}

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Guide;
import dao.GuideDao;
import dao.impl.GuideDaoImpl;


@WebServlet("/Searchcontroller")
public class Searchcontroller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private GuideDao guideDao;   
   
    public Searchcontroller() {
        super();
        guideDao = new GuideDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String grammarname = request.getParameter("grammarname");
		List<Guide> list = guideDao.findByTitle(grammarname);
		request.setAttribute("listsearch",list);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Ketquatimkiem.jsp");
		rd.forward(request,response);
	}

}

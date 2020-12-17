package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Guide;
import dao.GuideDao;
import dao.impl.GuideDaoImpl;
import enumeration.GuideType;


@WebServlet("/Insertgrammarguidelinename")
public class Insertgrammarguidelinename extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GuideDao guideDao;
   
    public Insertgrammarguidelinename() {
        super();
        guideDao = new GuideDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if (request.getCharacterEncoding()==null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		
		String grammarname = request.getParameter("grammarname");
		
		Guide grammarguideline = new Guide();
		grammarguideline.setTitle(grammarname);
		grammarguideline.setGuideType(GuideType.GRAMMAR);
		
		Guide kt = guideDao.insertGuide(grammarguideline);
		
		if (kt != null)
		{
			int grammarguidelineid = kt.getId();
			request.setAttribute("grammarguidelineid", grammarguidelineid);
			
			RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Insertgrammarguidelineimage.jsp");
			rd.forward(request,response);
		}
		else
		{
			request.setAttribute("msglistgrammarguidelinemanage","Thêm không thành công");
			RequestDispatcher rd = request.getRequestDispatcher("Listgrammarguidelinemanage");
			rd.forward(request,response);
		}
		
	}

}

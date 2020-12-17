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


@WebServlet("/Grammarguidelinecontentcontroller")
public class Grammarguidelinecontentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GuideDao guideDao;
    
    public Grammarguidelinecontentcontroller() {
        super();
        guideDao = new GuideDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String content = request.getParameter("content");
		String grammarguidelineidstr = request.getParameter("grammarguidelineid");
		
		int guideId = Integer.parseInt(grammarguidelineidstr);
		
		Guide grammarguideline = new Guide();
		
		grammarguideline.setContent(content);
		
		
		boolean kt = guideDao.updateContent(content, guideId);
		if (kt)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Listgrammarguidelinemanage");
			rd.forward(request,response);
		}
		else 
		{	
			request.setAttribute("msggrammarguidelinecontent","Thêm nội dung không thành công");
			request.setAttribute("grammarguidelineid",guideId);
			RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Insertgrammarguidelinecontent.jsp");
			rd.forward(request,response);	
		}
			
	}

}

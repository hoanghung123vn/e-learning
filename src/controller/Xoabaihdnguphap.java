package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.GuideDao;
import dao.impl.CommentDaoImpl;
import dao.impl.GuideDaoImpl;


@WebServlet("/Xoabaihdnguphap")
public class Xoabaihdnguphap extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentDao commentDao;
    private GuideDao guideDao;
    
    public Xoabaihdnguphap() 
    {
        super();
        commentDao = new CommentDaoImpl();
        guideDao = new GuideDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String grammarguidelineidstr = request.getParameter("grammarguidelineid");
		int grammarguidelineid = Integer.parseInt(grammarguidelineidstr);
		commentDao.deleteByGuideId(grammarguidelineid);
		guideDao.delete(grammarguidelineid);
		
		RequestDispatcher rd = request.getRequestDispatcher("Listgrammarguidelinemanage?pageid=1");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
import dao.CommentDao;
import dao.GuideDao;
import dao.impl.CommentDaoImpl;
import dao.impl.GuideDaoImpl;


@WebServlet("/Chitietbaihdnguphapforward")
public class Chitietbaihdnguphapforward extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private GuideDao guideDao;
    private CommentDao commentDao;
   
    public Chitietbaihdnguphapforward() {
        super();
        guideDao = new GuideDaoImpl();
        commentDao = new CommentDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String mabaihdnguphapstr = request.getParameter("mabaihdnguphap");
		int mabaihdnguphap = Integer.parseInt(mabaihdnguphapstr);
		String content = guideDao.getById(mabaihdnguphap).getContent();
		int countrow = commentDao.countById(mabaihdnguphap);
		
		request.setAttribute("mabaihdnguphap",mabaihdnguphap);
		request.setAttribute("grammarguidelinecontent",content);
		request.setAttribute("kitutrongdatabase","\n");
		request.setAttribute("kitutronghtml","<br/>");
		request.setAttribute("countrow",countrow);
		List<Comment> list = commentDao.findByGuideId(mabaihdnguphap);
		request.setAttribute("listcommentgrammar",list);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Chitietbaihdnguphap.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

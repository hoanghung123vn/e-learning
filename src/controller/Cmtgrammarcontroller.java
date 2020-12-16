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
import dao.impl.CommentDaoImpl;


@WebServlet("/Cmtgrammarcontroller")
public class Cmtgrammarcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDao commentDao;
    
    public Cmtgrammarcontroller() {
        super();
        commentDao = new CommentDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if (request.getCharacterEncoding()!= null) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String memberidstr = request.getParameter("memberid");
		String cmtgrammarcontent = request.getParameter("cmtgrammarcontent");
		String grammarguidelineidstr = request.getParameter("grammarguidelineid");
		
		int grammarguidelineid = Integer.parseInt(grammarguidelineidstr);
		int memberid = Integer.parseInt(memberidstr);
		Comment comment = new Comment(cmtgrammarcontent, memberid, grammarguidelineid);
		commentDao.save(comment);
		
		List<Comment> list = commentDao.findByGuideId(grammarguidelineid);
		
		request.setAttribute("listcommentgrammar",list);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Listcmtgrammarguide.jsp");
		rd.forward(request,response);
	}

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListenQuestion;
import dao.ListenQuestionDao;
import dao.impl.ListenQuestionDaoImpl;

@WebServlet("/Lambtnghe")
public class Lambtnghe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ListenQuestionDao listenQuestionDao;   
   
    public Lambtnghe() {
        super();
        listenQuestionDao = new ListenQuestionDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String listenexerciseidstr = request.getParameter("listenexerciseid");
		int listenexerciseid = Integer.parseInt(listenexerciseidstr);
		String pageidstr = request.getParameter("pageid");
		int pageid = Integer.parseInt(pageidstr);
		int count = 1;
		
		if (pageid == 1)
		{
			
		}
		else 
		{
			pageid = pageid -1;
			pageid = pageid * count +1;
		}
		
		List<ListenQuestion> list = listenQuestionDao.findAllByExerciseId(listenexerciseid, pageid, count);;
		
		int sumrow = listenQuestionDao.countByExerciseId(listenexerciseid);
		
		int maxpageid= 0;
		
		if ((sumrow/count)%2==0)
		{
			maxpageid = (sumrow/count);
		}
		else
		{
			maxpageid = (sumrow/count)+1;
		}
		
		request.setAttribute("maxpageid",maxpageid);
		request.setAttribute("listenexerciseid",listenexerciseid);
		
		request.setAttribute("danhsachcauhoibtnghe",list);
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Lambtphannghe.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String kq = request.getParameter("kq");
		String listenexerciseidstr = request.getParameter("listenexerciseid");
		int listenexerciseid = Integer.parseInt(listenexerciseidstr);
		String numstr = request.getParameter("num");
		int num = Integer.parseInt(numstr);
		
		
		if (kq == "")
		{
			request.setAttribute("msglambtphannghe","Yêu cầu trả lời hết các câu hỏi");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("View/Thongbaoloibtnghe.jsp");
			rd.forward(request,response);
		}
		else
		{	
			List<ListenQuestion> questions = listenQuestionDao.getByExerciseIdAndNo(listenexerciseid, num);
			
			request.setAttribute("dapandungbtnghe", questions);
			request.setAttribute("kq",kq);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("View/Ketquabtnghe.jsp");
			rd.forward(request,response);
		}
		
	}

}

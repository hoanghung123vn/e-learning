package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ReadQuestion;
import dao.ReadQuestionDao;
import dao.impl.ReadQuestionDaoImpl;

@WebServlet("/Lambtdoc")
public class Lambtdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReadQuestionDao readQuestionDao;   
    
    public Lambtdoc() 
    {
        super();
        readQuestionDao = new ReadQuestionDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String readexeriseidstr = request.getParameter("readexeriseid");
		int readexeriseid = Integer.parseInt(readexeriseidstr);
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
		
		List<ReadQuestion> list = readQuestionDao.findAllByExerciseId(readexeriseid, pageid, count);
		
		int sumrow = readQuestionDao.countByExerciseId(readexeriseid);
		
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
		request.setAttribute("readexeriseid",readexeriseid);
		
		request.setAttribute("danhsachcauhoibtdoc",list);
		
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Lambtphandoc.jsp");
		rd.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String kq = request.getParameter("kq");
		
		String readexeriseidstr = request.getParameter("readexeriseid");
		int readexeriseid = Integer.parseInt(readexeriseidstr);
		
		String numstr = request.getParameter("num");
		int num = Integer.parseInt(numstr);
		
		if (kq == "")
		{
			request.setAttribute("msglambtphandoc","Yêu cầu trả lời hết các câu hỏi");
			RequestDispatcher rd = request.getRequestDispatcher("View/Thongbaoloibtdoc.jsp");
			rd.forward(request,response);
		}
		else
		{	
			List<ReadQuestion> questions = readQuestionDao.getByExerciseIdAndNo(readexeriseid, num);
			request.setAttribute("dapandungbtdoc", questions);
			request.setAttribute("kq",kq);
			
			RequestDispatcher rd = request.getRequestDispatcher("View/Ketquabtdoc.jsp");
			rd.forward(request,response);
		}
		
		
	}

}

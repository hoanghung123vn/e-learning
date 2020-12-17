package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Exercise;
import dao.ExerciseDao;
import dao.impl.ExerciseDaoImpl;
import enumeration.QuestionType;


@WebServlet("/Hienthidsbtphandoc")
public class Hienthidsbtphandoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ExerciseDao exerciseDao;
    
    public Hienthidsbtphandoc() {
        super();
        exerciseDao = new ExerciseDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String pageidstr = request.getParameter("pageid");
		
		
		int pageid = Integer.parseInt(pageidstr);
		int count = 3;
		
		
		if (pageid == 1)
		{
			
		}
		else 
		{
			pageid = pageid -1;
			pageid = pageid * count +1;
		}
		List<Exercise> list = exerciseDao.findAll(pageid, count, QuestionType.READ);
		
		
		int sumrow = exerciseDao.count(QuestionType.READ);
		
		int maxpageid = 0;
		
		if ((sumrow/count)%2==0)
		{
			maxpageid = (sumrow/count);
		}
		else
		{
			maxpageid = (sumrow/count)+1;
		}
		
		request.setAttribute("maxpageid",maxpageid);
		
		request.setAttribute("danhsachbtdoc",list);
		
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Dsbtdoc.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

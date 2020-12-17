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




@WebServlet("/Hienthidsbtdoc")
public class Hienthidsbtdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExerciseDao exerciseDao;
       
   
    public Hienthidsbtdoc() {
        super();
        exerciseDao = new ExerciseDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String pageidstr = request.getParameter("pageid");
		
		
		int pageId = Integer.parseInt(pageidstr);
		int count = 3;
		
		
		if (pageId == 1) {
			
		}
		else {
			pageId = pageId -1;
			pageId = pageId * count +1;
		}
		
		List<Exercise> list = exerciseDao.findAll(pageId, count, QuestionType.READ);
		
		
		int sumrow = exerciseDao.count(QuestionType.READ);
		
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
		
		request.setAttribute("danhsachqlbtdoc",list);
		
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Quanlylambtdoc.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Examination;
import dao.ExaminationDao;
import dao.impl.ExaminationDaoImpl;


@WebServlet("/Hienthidsquanlydethi")
public class Hienthidsquanlydethi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ExaminationDao examinationDao;
    
    public Hienthidsquanlydethi() {
        super();
        examinationDao = new ExaminationDaoImpl();
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
		
		List<Examination> list = examinationDao.findAll(pageid, count);
		int sumrow = examinationDao.count();
		
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
		
		request.setAttribute("danhsachdethi",list);
		
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/Quanlydethi.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

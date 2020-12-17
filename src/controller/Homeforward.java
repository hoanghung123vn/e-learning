package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SlideBanner;
import dao.SlideBannerDao;
import dao.impl.SlideBannerDaoImpl;

@WebServlet("/Homeforward")
public class Homeforward extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private SlideBannerDao slideBannerDao;   
    
    public Homeforward() 
    {
        super();
        slideBannerDao = new SlideBannerDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<SlideBanner> list = slideBannerDao.findAll();
		request.setAttribute("listslidebanner",list);
		RequestDispatcher rd = request.getRequestDispatcher("View/Home.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

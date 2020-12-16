package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Guide;
import dao.GuideDao;
import dao.impl.GuideDaoImpl;

@WebServlet("/Dsbaihdnguphapforward")
public class Dsbaihdnguphapforward extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private GuideDao guideDao;
    
    public Dsbaihdnguphapforward() {
        super();
        guideDao = new GuideDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String pageidstr = request.getParameter("pageid");
		
		int pageid = Integer.parseInt(pageidstr);
		int count = 3;
		if (pageid == 1){
			
		}
		else {
			pageid = pageid -1;
			pageid = pageid * count +1;
		}
		
		List<Guide> list = guideDao.findAllGrammarGuide(pageid, count);
		int sumrow = guideDao.countGrammar();
		int maxpageid= 0;
		
		if ((sumrow/count)%2==0) {
			maxpageid = (sumrow/count);
		}
		else {
			maxpageid = (sumrow/count)+1;
		}
		
		request.setAttribute("maxpageid",maxpageid);
		request.setAttribute("listgrammarguideline",list);
		request.setAttribute("numberpage",Integer.parseInt(pageidstr));
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Dsbaihdnguphap.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

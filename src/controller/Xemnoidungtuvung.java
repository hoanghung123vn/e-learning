package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.VocabularyContent;
import dao.VocabularyContentDao;
import dao.impl.VocabularyContentDaoImpl;


@WebServlet("/Xemnoidungtuvung")
public class Xemnoidungtuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VocabularyContentDao vocabularyContentDao;
    
    public Xemnoidungtuvung() {
        super();
        vocabularyContentDao = new VocabularyContentDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String vocabularyguidelineidstr = request.getParameter("vocabularyguidelineid");
		
		int vocabularyguidelineid = Integer.parseInt(vocabularyguidelineidstr);
		
		List<VocabularyContent> list = vocabularyContentDao.findAllByGuideId(vocabularyguidelineid);
		
		
		request.setAttribute("noidungtuvung",list);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Noidunghdtuvung.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

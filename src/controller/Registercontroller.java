package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;


@WebServlet("/Registercontroller")
public class Registercontroller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private UserDao userDao;  

    public Registercontroller() {
        super();
        userDao = new UserDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("View/Register.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
				if (request.getCharacterEncoding()==null)
				{
					request.setCharacterEncoding("UTF-8");
				}
				
				String name = request.getParameter("name");
				String membername = request.getParameter("membername");
				String memberpass = request.getParameter("memberpass");
				
				User member = new User();
				member.setName(name);
				member.setUserName(membername);
				member.setPassword(memberpass);
				
				boolean test = userDao.save(member);
				
				if (test)
				{
					request.setAttribute("msgregister","Đăng ký thành công");
					RequestDispatcher rd = request.getRequestDispatcher("Registerforward");
					rd.forward(request,response);
				}
				else 
				{
					request.setAttribute("msgregister","Đăng ký không thành công");
					RequestDispatcher rd = request.getRequestDispatcher("Registerforward");
					rd.forward(request,response);
				}
				
				
	}

}

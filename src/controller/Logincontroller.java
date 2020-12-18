package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import enumeration.Role;

@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
    
    public Logincontroller() {
        super();
        userDao = new UserDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String membername = request.getParameter("membername");
		String memberpass = request.getParameter("memberpass");
		User user = userDao.getByUserName(membername);
		if (user.getId() == 0) {
			request.setAttribute("msglogin","Tên hoặc mật khẩu sai");
			RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
			rd.forward(request,response);
		}
		
		boolean authenticated = authenticate(user.getPassword(), memberpass);
		if (authenticated && user.getRole().equals(Role.MEMBER)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("sessionuser", user.getUserName());
			session.setAttribute("sessionmemberid", user.getId());
			
			RequestDispatcher rd = request.getRequestDispatcher("Homeforward");
			rd.forward(request,response);
		}
		else if (authenticated && user.getRole().equals(Role.ADMIN)) {
			HttpSession session = request.getSession(true);
			
			session.setAttribute("sessionadmin", user.getUserName());
			session.setAttribute("sessionadminid", user.getId());
			
			RequestDispatcher rd = request.getRequestDispatcher("Adminforward");
			rd.forward(request,response);
		}
		else {
			request.setAttribute("msglogin","Tên hoặc mật khẩu sai");
			RequestDispatcher rd = request.getRequestDispatcher("View/Login.jsp");
			rd.forward(request,response);
		}
	}

	private boolean authenticate(String password, String passwordRaw) {
		return BCrypt.checkpw(passwordRaw, password);
	}
}

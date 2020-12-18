package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ExaminationQuestion;
import bean.Result;
import bean.UserAnswer;
import dao.ExaminationQuestionDao;
import dao.ResultDao;
import dao.impl.ExaminationQuestionDaoImpl;
import dao.impl.ResultDaoImpl;

@WebServlet("/Lambaithitoeic")
public class Lambaithitoeic extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private ExaminationQuestionDao examinationQuestionDao;
	private ResultDao resultDao;
    
    public Lambaithitoeic() 
    {
        super();
        examinationQuestionDao = new ExaminationQuestionDaoImpl();
        resultDao = new ResultDaoImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String examinationidstr = request.getParameter("examinationid");
		int examinationid = Integer.parseInt(examinationidstr);
		
		
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("sessionuser")!=null)
		{
			int memberid = (int) session.getAttribute("sessionmemberid");
			
			request.setAttribute("kitutrongdatabase","\n");
			request.setAttribute("kitutronghtml","<br/>");
			
			request.setAttribute("examinationid",examinationid);
			request.setAttribute("memberid",memberid);
			
			List<ExaminationQuestion> list = examinationQuestionDao.findAllByExamId(examinationid);
			
			request.setAttribute("dscauhoi",list);
			
			RequestDispatcher rd = request.getRequestDispatcher("View/Lambaithitoeic.jsp");
			rd.forward(request,response);
			
		}
		else
		{
			request.setAttribute("msgloidnlambai","Đăng nhập trước khi làm bài thi");
			
			RequestDispatcher rd = request.getRequestDispatcher("Hienthidsdethi?pageid=1");
			rd.forward(request,response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String examinationidstr = request.getParameter("examinationid");
		int examinationid = Integer.parseInt(examinationidstr);
		
		String memberidstr = request.getParameter("memberid");
		int memberid = Integer.parseInt(memberidstr);
		
		
		int countrow = examinationQuestionDao.countByExamId(examinationid);
		
		List<ExaminationQuestion> listcorrectanswer = examinationQuestionDao.findAllByExamId(examinationid);
		
		List<UserAnswer> listansweruser = new ArrayList<UserAnswer>();

		int socaudung=0;
		int socaudungphannghe =0;
		int socaudungphandoc =0;
		for (int i =1; i<= countrow; i++)
		{
			String answer = request.getParameter("ans["+i+"]");
			
			if (answer != null)
			{
				//luu danh sach dap an cua user
				UserAnswer au = new UserAnswer();	
				au.setNo(i);
				au.setAnswer(answer);		
				listansweruser.add(au);
				
				String dapandung = examinationQuestionDao.getQuestionByExamIdAndNo(examinationid, i).getCorrect();
				
				if (i<=4)
				{
					if (answer.equals(dapandung))
					{
						socaudung++;
						socaudungphannghe++;
					}
				}
				else 
				{
					if (i>=5)
					{
						if (answer.equals(dapandung))
						{
							socaudung++;
							socaudungphandoc++;
						}
					}
				}
					

					
			}
			else
			{
				UserAnswer au = new UserAnswer();	
				au.setNo(i);
				au.setAnswer("Không chọn");		
				listansweruser.add(au);
			}
				
			
		}
		
		
		Date date = new Date();
		
		
		int socausai = countrow - socaudung;
		
		
		Result result = new Result();
		
		result.setSumIncorrect(socausai);
		result.setTimestamp(new Timestamp(System.currentTimeMillis()));
		result.setExamId(examinationid);
		result.setUserId(memberid);
		result.setSumListenCorrect(socaudungphannghe);
		result.setSumReadCorrect(socaudungphandoc);
		
		resultDao.save(result);
		
		request.setAttribute("kitutrongdatabase","\n");
		request.setAttribute("kitutronghtml","<br/>");
		request.setAttribute("listcorrectanswer",listcorrectanswer);
		request.setAttribute("listansweruser",listansweruser);
		
		request.setAttribute("ketquathi", result);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("View/Ketquathi.jsp");
		rd.forward(request,response);
		
			
			
	}

}

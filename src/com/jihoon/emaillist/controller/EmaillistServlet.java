package com.jihoon.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihoon.emaillist.dao.EmaillistDao;
import com.jihoon.emaillist.vo.EmaillistVo;

@WebServlet("/el")
public class EmaillistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("a");

		 if ("form".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(request, response);
			
		} else if ("add".equals(action)) {
			request.setCharacterEncoding("UTF-8");

			//1. 데이터를 받는다.
			String fn = request.getParameter("fn");
			String ln = request.getParameter("ln");
			String em = request.getParameter("email");
			
			EmaillistVo emaillistVo = new EmaillistVo();
			emaillistVo.setFirstName(fn);
			emaillistVo.setLastName(ln);
			emaillistVo.setEmail(em);
			
			
			//2. 받은 데이터를 DB 에 insert 시킨다.
			EmaillistDao emaillistDao = new EmaillistDao();
			emaillistDao.insert(emaillistVo);
			
			//3. 들어간 리스트를 다시 보여준다.(들어간 것을 확인시켜줘야 한다.)
			response.sendRedirect("/emaillist02/el?a=list");

		} else {
			EmaillistDao emaillistDao = new EmaillistDao();
			List<EmaillistVo> list = emaillistDao.getList();
			
			request.setAttribute("list", list); 					// 중요
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

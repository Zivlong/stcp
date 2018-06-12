package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.User;
import com.stx.dao.UserDao;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登录页面表单的信息
		String zh = request.getParameter("zh");
		String pass = request.getParameter("pass");
		String type = request.getParameter("type");

		// 创建dao类对象
		UserDao dao = new UserDao();
		User user = dao.login(zh, pass);

		if (user != null) {
			request.getSession().setAttribute("USER", user);
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/page/login.jsp");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}

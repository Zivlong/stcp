package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.User;
import com.stx.dao.UserDao;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取注册页面的表单信息
		String zh = request.getParameter("zh");
		String pass = request.getParameter("pass");
		String realname = request.getParameter("realname");
		String mobile = request.getParameter("mobile");

		// 创建Dao对象
		UserDao dao = new UserDao();

		// 将信息封装到User对象中
		User user = new User(zh, pass, realname, mobile, "0");

		// 调用添加方法
		dao.addUser(user);

		// 转发到登录页面
		request.getRequestDispatcher("/page/login.jsp").forward(request,
				response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}

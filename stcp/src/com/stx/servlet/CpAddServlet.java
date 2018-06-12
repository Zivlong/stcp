package com.stx.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.Cp;
import com.stx.bean.User;
import com.stx.dao.CpDao;

public class CpAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取新增页面表单的值
		String tname = request.getParameter("tname");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User) request.getSession().getAttribute("USER");
		String uname = user.getRealname();

		java.util.Date date = new java.util.Date();
		java.sql.Date dateSql = new java.sql.Date(date.getTime());

		Date createtime = new Date();
		Cp cp = new Cp(uname, tname, title, content, dateSql);
		// 创建dao类对象
		CpDao dao = new CpDao();
		dao.addCp(cp);
		// 跳转到查询Servlet、
		request.getRequestDispatcher("/CpSelByUserServlet").forward(request,
				response);
	}

}

package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.Type;
import com.stx.dao.TypeDao;

public class TypeAddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取新增页面表单的值
		String name = request.getParameter("name");
		TypeDao dao = new TypeDao();
		Type type = new Type(name);
		dao.addType(type);
		request.getRequestDispatcher("/TypeServlet").forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}

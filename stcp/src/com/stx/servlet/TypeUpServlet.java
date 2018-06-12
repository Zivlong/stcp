package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.Type;
import com.stx.dao.TypeDao;

public class TypeUpServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取编辑页面表单信息
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int num = Integer.parseInt(id);
		Type type = new Type(num, name);

		// 创建dao类对象，执行更新方法
		TypeDao dao = new TypeDao();
		dao.updateType(type);

		request.getRequestDispatcher("/TypeServlet").forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}

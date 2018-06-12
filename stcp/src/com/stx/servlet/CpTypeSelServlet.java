package com.stx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.Type;
import com.stx.dao.TypeDao;

public class CpTypeSelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建类型dao类对象
		TypeDao dao = new TypeDao();
		List<Type> list = dao.selectType();
		request.setAttribute("types", list);
		request.getRequestDispatcher("/page/cp_add.jsp").forward(request,
				response);
	}

}

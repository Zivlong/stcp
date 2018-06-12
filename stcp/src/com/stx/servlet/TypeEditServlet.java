package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.Type;
import com.stx.dao.TypeDao;

public class TypeEditServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("id"));
		TypeDao dao = new TypeDao();
		Type type = dao.selectTypeById(num);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/page/type_edit.jsp").forward(request,
				response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
}

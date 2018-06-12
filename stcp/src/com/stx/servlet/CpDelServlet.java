package com.stx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.dao.CpDao;

public class CpDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CpDao cp = new CpDao();
		cp.deleteCp(Integer.parseInt(request.getParameter("id")));
		request.getRequestDispatcher("/CpSelByUserServlet").forward(request,
				response);
	}

}

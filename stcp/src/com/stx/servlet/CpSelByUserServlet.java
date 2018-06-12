package com.stx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.bean.User;
import com.stx.dao.CpDao;

public class CpSelByUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 放在session的信息是所有web组件的共享资源
		// 将登录对象从session直接拿来用
		User user = (User) request.getSession().getAttribute("USER");
		// 创建CpDao类对象
		CpDao dao = new CpDao();
		List list = dao.selectCpByUser(user.getRealname());
		// 将信息封装到request对象
		request.setAttribute("cps", list);
		// 请求转发，跳转到列表页面
		request.getRequestDispatcher("/page/cp_my_list.jsp").forward(request,
				response);

	}

}

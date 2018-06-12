package com.stx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.stx.bean.User;

public class LoginFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*
		 * 1. 从session中获取用户信息 2. 判断如题session中存在用户信息，放行！ 3.
		 * 否则，保存错误信息，转发到login.jsp显示
		 */
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		User user = (User) httpRequest.getSession().getAttribute("USER");
		if (user != null) {
			chain.doFilter(request, response);
		} else {
			httpRequest.setAttribute("msg", "您还没有登录！");
			httpRequest.getRequestDispatcher("/page/login.jsp").forward(
					httpRequest, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}

package com.ssh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.springframework.web.context.ServletConfigAware;

import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware, ServletContextAware, SessionAware,
ApplicationAware, CookiesAware ,ServletConfigAware{
	
	public HttpServletRequest request;
	public ServletContext servletContext;
	public ServletConfig servletConfig;
	public HttpServletResponse response;
	public Map<String, Object> session;
	public Map<String, Object> application;
	public Map<String, String> cookies;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		// TODO Auto-generated method stub
		this.cookies = cookies;
	}

	/**
	 * 转向
	 * 
	 * @param path
	 */
	public void forward(String path) {
		try {
			this.request.getRequestDispatcher(path).forward(this.request,
					this.response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 先弹框，再重定向
	 * 
	 * @param msg
	 * @param path
	 */
	public void alertRedirect(String msg, String path) {
		try {
			this.response.setContentType("text/html;charset=utf8");
			PrintWriter out = this.response.getWriter();
			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("window.location='" + path + "';");
			out.print("</script>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkLogin() throws IOException {
		if (session == null||session.size()<1) {
			this.response.sendRedirect("login.jsp");
		} else {
			int userId = (int) session.get("userId");
			String username = (String) session.get("username");

			if (userId == 0 || username == null || username.length() < 1) {
				this.response.sendRedirect("login.jsp");
			}
			else
			{
				return true;
			}
		}
		return false;

	}

	/**
	 * 转换get方式提交的中文编码（UTF-8）
	 * 
	 * @param str
	 * @return
	 */
	public String convertGetCode(String str) {
		if (str != null) {
			try {
				byte[] bs = str.getBytes("ISO8859-1");
				str = new String(bs, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		// TODO Auto-generated method stub
		this.servletConfig = servletConfig;
	}

}

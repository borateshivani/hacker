package com.demo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Book;
import com.demo.service.BookService;
import com.demo.service.BookServicesImpl;
import com.demo.service.Login;
import com.demo.service.LoginImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlets extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String username = req.getParameter("uname");
		String password = req.getParameter("pass");
        HttpSession session = req.getSession();
        
        List<Book> booksList = new ArrayList<>();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("total", 0);
        session.setAttribute("markedBook", booksList);
		Login lo = new LoginImpl();
		boolean result = lo.getUser(username,password);
		if(result) {
			RequestDispatcher rd = req.getRequestDispatcher("category.jsp");
			rd.forward(req, res);
		}
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.forward(req, res);
		
	}
}

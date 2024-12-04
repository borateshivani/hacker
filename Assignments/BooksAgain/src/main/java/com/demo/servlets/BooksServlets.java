package com.demo.servlets;

import java.io.IOException;
import java.util.List;

import com.demo.bean.Book;
import com.demo.service.BookService;
import com.demo.service.BookServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cata")
public class BooksServlets extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String cat = req.getParameter("btn");
		BookService bs = new BookServicesImpl();
		List<Book> ans;
		switch (cat) {
		case "ad" :  {
			ans = bs.getBooks("adventure");
			req.setAttribute("Books", ans);
			break;
		}
		case "no" :  {
			ans = bs.getBooks("novel");
			req.setAttribute("Books", ans);
			break;
		}
		case "dr" :  {
			ans = bs.getBooks("drama");
			req.setAttribute("Books", ans);
			break;
		}case "fi" :  {
			ans = bs.getBooks("fiction");
			req.setAttribute("Books", ans);
			break;
		}case "action" :  {
			ans = bs.getBooks("action");
			req.setAttribute("Books", ans);
			break;
		}case "anime" :  {
			ans = bs.getBooks("anime");
			req.setAttribute("Books", ans);
			break;
		}
		default:{
			RequestDispatcher rd = req.getRequestDispatcher("catagory.jsp");
			rd.forward(req, res);
			}
		}
	
		RequestDispatcher rd = req.getRequestDispatcher("ShowBooks.jsp");
		rd.forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

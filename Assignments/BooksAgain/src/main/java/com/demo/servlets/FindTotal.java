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
import jakarta.servlet.http.HttpSession;

@WebServlet("/Total")
public class FindTotal extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedIds = req.getParameterValues("btns"); 
        HttpSession session = req.getSession();
        int totalPrice = (int) session.getAttribute("total");
        List<Book> booksList = (List<Book>) session.getAttribute("markedBook");
        if (selectedIds != null) {
            BookService bookService = new BookServicesImpl(); 
            
            for (String id : selectedIds) {
                int bookId = Integer.parseInt(id); 
                Book book = bookService.getBookById(bookId);
                booksList.add(book);
                if (book != null) {
                    totalPrice += book.getPrice(); 
                }
            }
        }
        session.removeAttribute("total");
        session.setAttribute("total", totalPrice);
        
        session.removeAttribute("markedBook");
        session.setAttribute("markedBook", booksList);
        req.setAttribute("total", totalPrice);
        RequestDispatcher rd = req.getRequestDispatcher("totalPrice.jsp");
        rd.forward(req, resp); 
        
    }
}
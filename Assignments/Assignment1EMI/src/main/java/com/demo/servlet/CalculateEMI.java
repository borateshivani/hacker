package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculateEMI extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pr = res.getWriter();
		
		double loanAmt = Double.parseDouble(req.getParameter("loan"));
		int years = Integer.parseInt(req.getParameter("years"));
		
//		Assume that rate of interest is 10%
//		Interest=loan amt*rate of interest
//		Total amt=loan amt+interest
//		EMI=total amt/36
		
		double rate_of_interest = 10.0;
		double interest = loanAmt*rate_of_interest*.01;
		
		double Total_amt = loanAmt+(interest*years);
		double EMI = Total_amt/(years*12);
		pr.println("<h1>Interest : "+interest+"</h2>");
		pr.println("<h1>Total amount : "+Total_amt+"</h2>");
		pr.println("<h1>EMI : "+ String.format("%.2f",EMI) +"</h2>");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

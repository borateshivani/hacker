package com.demo.dao;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Book;

public class DaoOperationsImpl implements DaoOperations {
	

	public boolean getuser(String username, String password) {
		Connection conn = DBUtils.getMyConnection();
		try {
			PreparedStatement pr = conn.prepareStatement("select * from bookusers where uname=? and password=? ");
			pr.setString(1, username);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			if(rs.next()) {
				return true;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Book> getBooks(String b) {
		List<Book> list = new ArrayList<>();
		Connection c = DBUtils.getMyConnection();
		try {
			PreparedStatement p = c.prepareStatement("Select * from Booksnew where cat = ?");
			p.setString(1, b);
			ResultSet rs= p.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book getBookById(int id) {
		Connection c = DBUtils.getMyConnection();
		try {
			PreparedStatement ps = c.prepareStatement("Select * from Booksnew where  bookid = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Book b = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				return b;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}

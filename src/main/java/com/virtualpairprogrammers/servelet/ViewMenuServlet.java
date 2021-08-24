package com.virtualpairprogrammers.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class ViewMenuServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.getFullMenu();
		out.println("<html><body><h1>Pavans Restaurent</h1>");
		out.println("<h2>Menu</h2>");
		out.println("<ul>");
		for(MenuItem menuItem:menuItems) {
			out.println("<li>"+menuItem+"</li>");
		}
		out.println("</ul>");
		out.println("<a href = 'http://localhost:8080/searchResults.html?searchTerm=chicken'> view all our chicken dishes</a>");
		out.println("</ul></body></html>");
		out.close();
	}
}

package com.virtualpairprogrammers.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class MenuSearchServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String searchTerm = request.getParameter("searchTerm");
		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.find(searchTerm);
		if(menuItems.size() > 0) {
			out.println("<html><body><h1>Pavans Restaurent</h1>");
			out.println("<h2>Dishes Containing "+searchTerm+"</h2>");
			out.println("<ul>");
			for(MenuItem menuItem:menuItems) {
				out.println("<li>"+menuItem+" "+menuItem.getDescription()+"</li>");
			}
			out.println("</ul></body></html>");
		} else {
			out.println("<html><body><h1>Pavans Restaurent</h1>");
			out.println("<p> sorry there are no dishes with "+searchTerm+"</p>");
			out.println("</body></html>");
		}
		out.close();
	}
}

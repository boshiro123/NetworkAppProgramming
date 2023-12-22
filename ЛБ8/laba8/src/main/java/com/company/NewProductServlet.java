package com.company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String count = req.getParameter("count");
        Products.addProducts(new Products(title, Integer.parseInt(count)));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");
        dispatcher.forward(req, resp);
    }
}

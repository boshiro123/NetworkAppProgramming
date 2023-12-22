package com.company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String count = req.getParameter("count");
        String oldTitle = req.getParameter("oldTitle");
        for(Products p : Products.getProducts()){
            if(p.getProductTitle().equals(oldTitle)){
                p.setProductTitle(title);
                p.setCount(Integer.parseInt(count));
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");
        dispatcher.forward(req, resp);
    }
}

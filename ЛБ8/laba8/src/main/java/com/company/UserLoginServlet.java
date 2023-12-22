package com.company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBaseController db = new DataBaseController();
        ArrayList<User> users = new ArrayList<>();
        try {
            users = db.getUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        for(User u : users){
            if(login.equals(u.getLogin()) && password.equals(u.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("user", login);
                resp.sendRedirect("main.jsp");
                return;
            }
        }
        req.setAttribute("refusal","Пользователь не найден!");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}

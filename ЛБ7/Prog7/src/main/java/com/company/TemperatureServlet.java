package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TemperatureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TemperatureDataHandler dataHandler = new com.company.TemperatureDataHandler();
        List<Double> temperatures = dataHandler.readTemperatureDataFromFile("C:\\Users\\user\\temperatures.txt");
        double averageTemperature = dataHandler.calculateAverageTemperature(temperatures);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        if(temperatures.isEmpty()){
            out.println("<html><body>");
            out.println("<h1>Температура:</h1>");
            out.println("<p>" + "Не удалось считать температуру" + "</p>");
            out.println("</body></html>");
        }else{
            out.println("<html><body>");
            out.println("<h1>Температура:</h1>");
            out.println("<p>" + Math.round(averageTemperature * 100.0) / 100.0 + "</p>");
            out.println("</body></html>");
        }
    }

}

package org.tesji.controller;

import org.tesji.service.GreetingService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {

    private GreetingService service = new GreetingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {

            var students = service.getGreetings();

            req.setAttribute("students", students);

            req.getRequestDispatcher("/students.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

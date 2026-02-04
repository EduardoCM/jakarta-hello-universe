package org.tesji.controller;

import java.io.IOException;

import org.tesji.dto.Greeting;
import org.tesji.service.GreetingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8150664193629620766L;
	
	private GreetingService service = new GreetingService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            Greeting student = service.getById(id);

            req.setAttribute("student", student);

            req.getRequestDispatcher("/edit.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
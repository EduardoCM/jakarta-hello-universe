package org.tesji.controller;

import java.io.IOException;

import org.tesji.service.GreetingService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 648304147478256671L;
	
	private GreetingService service = new GreetingService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            service.delete(id);

            resp.sendRedirect("students");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



package org.tesji.controller;

import java.io.IOException;

import org.tesji.service.GreetingService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1283994612330177493L;

	private GreetingService service = new GreetingService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");

            service.update(id, name);

            resp.sendRedirect("students");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

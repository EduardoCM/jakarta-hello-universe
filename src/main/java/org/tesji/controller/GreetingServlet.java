package org.tesji.controller;

import java.io.IOException;

import org.tesji.service.EmailSender;
import org.tesji.service.GreetingService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1673617505700925167L;
	
	private GreetingService service = new GreetingService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String name = req.getParameter("studentName");
            String email = req.getParameter("email");
            
            System.out.println("Hola Mundo: " + name + " email: " + email);

            service.saveGreeting(name, email);
            
            EmailSender.send(email,name);

            // Enviamos el nombre al JSP
            req.setAttribute("studentName", name);
            
            

            // Forward al JSP de bienvenida
            req.getRequestDispatcher("/welcome.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = -1673617505700925167L;
	private GreetingService service = new GreetingService();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter("studentName");
        try {
        	service.saveGreeting(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        resp.getWriter().println("Hola " + name + ", tu saludo fue registrado");
    }
}
*/
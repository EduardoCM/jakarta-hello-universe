package org.tesji.service;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void send(String to, String name) {

      
        final String from = " ";
        final String pass = " "; 

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            });

        try {

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );

            String courseUrl = "abc123";
			String html = """
            		<!DOCTYPE html>
            		<html>
            		<head>
            		  <meta charset="UTF-8">
            		</head>

            		<body style="background:#f5f5f5;padding:30px;font-family:Arial,sans-serif;">
            		  <table width="100%%" cellspacing="0" cellpadding="0">
            		    <tr>
            		      <td align="center">
            		        <table width="500" style="background:white;border-radius:10px;box-shadow:0 0 10px rgba(0,0,0,.1);padding:30px;">
            		          <tr>
            		            <td align="center">

            		              <h2 style="color:#0d6efd;margin-bottom:10px;">
            		                Bienvenido al Curso de Microservicios con Java 21 y React
            		              </h2>

            		              <p style="font-size:16px;color:#333;">
            		                Hola <strong>%s</strong>
            		              </p>

            		              <p style="font-size:14px;color:#555;">
            		                Tu registro fue exitoso <br/>
            		                Ya formas parte de la tripulación de este viaje
            		              </p>

            		              <hr style="margin:20px 0;"/>

            		              <p style="font-size:13px;color:#777;margin-bottom:8px;">
            		                Aquí aprenderás:
            		              </p>

            		              <ul style="text-align:left;color:#555;font-size:13px;margin:0 auto;display:inline-block;">
            		                <li>Monolitos y Microservicios</li>
            		                <li>Arquitectura Multicapa</li>
            		                <li>Java 21</li>
            		                <li>Tomcat 11</li>
            		                <li>PostgreSQL 16</li>
            		                <li>Docker</li>
            		                <li>Git</li>
            		                <li>Maven</li>
            		                <li>SpringBoot</li>
            		                <li>React</li>
            		                <li>Y mas....</li>
   
            		              </ul>

            		              <div style="margin-top:22px;">
            		                <a 
            		                   style="display:inline-block;padding:10px 20px;background:#0d6efd;color:white;text-decoration:none;border-radius:6px;font-size:14px;">
            		                  No tengas prisa por llegar y Disfruta del viaje
            		                </a>
            		              </div>

            		              <p style="margin-top:25px;font-size:12px;color:#999;">
            		                Gracias por confiar en este camino 
            		              </p>

            		            </td>
            		          </tr>
            		        </table>
            		      </td>
            		    </tr>
            		  </table>
            		</body>
            		</html>
            		""".formatted(name);



            /*
            msg.setText(
                "Hola " + name +
                "\n\nTu registro fue exitoso " +
                "\nBienvenido al curso de Arquitecturas Modernas." +
                "\n\n— Equipo del curso "
            );
            */
            
            msg.setSubject("Bienvenido: " + name);
            msg.setContent(html, "text/html; charset=utf-8");
            Transport.send(msg);

            System.out.println("Correo enviado correctamente a " + to);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

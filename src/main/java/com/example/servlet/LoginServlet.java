package com.example.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        RequestDispatcher requestDispatcher;
        if (request.getSession().getAttribute("user") != null) {
            /*requestDispatcher = request.getRequestDispatcher("/user/hello.jsp");
            requestDispatcher.forward(request, response);*/
//            response.sendRedirect("/user/hello.jsp");
            response.sendRedirect("/login.jsp");
        }
        else {
            /*requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);*/
//            response.sendRedirect("/login.jsp");
            response.sendRedirect("/user/hello.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ((login.equals("user") || login.equals("admin")) &&
                password != null && !password.trim().isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            response.sendRedirect("/user/hello.jsp");
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}

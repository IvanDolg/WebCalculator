package servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloSetvlet", urlPatterns = "/")
public class HelloSetvlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser != null){
            resp.getWriter().println("<h1>Hello "  + currentUser + " !!!</h1>");
        } else {
            resp.getWriter().println("<h1>Hello Guest !!!</h1>");
        }
    }
}

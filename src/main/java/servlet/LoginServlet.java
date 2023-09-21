package servlet;

import services.UserService;
import domain.User;
import validation.UserDataValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final UserDataValidation validation = new UserDataValidation();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      getServletContext().getRequestDispatcher("pages/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (validation.nameValidation(userName) && validation.passwordValidation(password)) {
            Optional<User> byUserName = userService.findByUsername(userName);

            if (byUserName.isPresent()) {
                User user = byUserName.get();
                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute("currentUser", user);
                    resp.sendRedirect("/");
                } else {
                    resp.sendError(400, "Wrong password!!!");
                }
            } else {
                resp.sendError(400, "User not found!!!");
            }
        }
        else {
            resp.getWriter().println("Incorrect data ...");
        }
    }
}

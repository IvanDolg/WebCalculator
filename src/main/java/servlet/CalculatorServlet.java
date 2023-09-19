package servlet;

import services.OperationService;
import domain.Operation;
import domain.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private final OperationService operationService = new OperationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User author = (User) req.getSession().getAttribute("currentUser");

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        Operation operation = new Operation(author.getId(), num1, num2, type);
        Operation result = operationService.calculate(operation, author);

        resp.getWriter().println(result.toString());
    }
}

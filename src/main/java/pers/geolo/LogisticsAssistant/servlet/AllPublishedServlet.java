package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.Cargo;
import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.service.TradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 鲍之骁
 */
@WebServlet(name = "AllPublishedServlet", urlPatterns = "/allPublished")
public class AllPublishedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            List<Cargo> allCargoList = TradeService.getInstance().getAllPublished();
            request.getSession().setAttribute("allCargoList", allCargoList);
            request.getRequestDispatcher("/allPublished.jsp").forward(request, response);
        }
    }
}

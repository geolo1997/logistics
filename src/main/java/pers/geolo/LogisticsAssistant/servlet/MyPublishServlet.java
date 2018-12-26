package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.CargoInformation;
import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.service.TradeService;
import pers.geolo.LogisticsAssistant.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 桀骜
 */
@WebServlet(name = "MyPublishServlet", urlPatterns = "/MyPublish")
public class MyPublishServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<CargoInformation> cargoList =  TradeService.getInstance().getMyPublish(user);
        request.getSession().setAttribute("cargoList", cargoList);
        response.sendRedirect(getServletContext().getContextPath() + "/myPublish.jsp");
    }
}

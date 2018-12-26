package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.CargoInformation;
import pers.geolo.LogisticsAssistant.service.TradeService;
import pers.geolo.LogisticsAssistant.service.UserService;
import pers.geolo.LogisticsAssistant.utils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 桀骜
 */
@WebServlet(name = "PublishServlet", urlPatterns = "/Publish")
public class PublishServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CargoInformation cargoInformation = (CargoInformation) BeanUtils.getBean(request);
        TradeService.getInstance().publish(cargoInformation);
        // 重定向至发布成功页面
        response.sendRedirect(request.getContextPath() + "/publishSuccess.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 转发至发布货物信息页面
        request.getRequestDispatcher("/publish.jsp").forward(request, response);
    }
}

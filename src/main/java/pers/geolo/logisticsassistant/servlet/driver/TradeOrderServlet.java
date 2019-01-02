package pers.geolo.logisticsassistant.servlet.driver;

import pers.geolo.logisticsassistant.entity.Cargo;
import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.service.CargoService;
import pers.geolo.logisticsassistant.util.ServletUtils;
import pers.geolo.logisticsassistant.value.CargoState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 桀骜
 */
@WebServlet(name = "TradeOrderServlet", urlPatterns = "/tradeOrder")
public class TradeOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
          int cargoId = Integer.parseInt(request.getParameter("cargoId"));
            CargoState cargoState = CargoState.valueOf(request.getParameter("cargoState").toUpperCase());
            CargoService.getInstance().updateCargoState(cargoId, cargoState);
            // 以JSON格式响应请求
            ServletUtils.returnJSON(response, "{\"response\":\"updateSuccess\"}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            List<Cargo> cargoList = CargoService.getInstance().getTradeOrder(user.getId());
            request.setAttribute("cargoList", cargoList);
            request.getRequestDispatcher("/tradeOrder.jsp").forward(request, response);
        }
    }
}

package pers.geolo.logisticsassistant.servlet;

import org.apache.log4j.Logger;
import pers.geolo.logisticsassistant.entity.Cargo;
import pers.geolo.logisticsassistant.entity.Request;
import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.service.CargoService;
import pers.geolo.logisticsassistant.service.RequestService;

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
@WebServlet(name = "CargoDetailServlet", urlPatterns = "/cargoDetail")
public class CargoDetailServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CargoDetailServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            int id = Integer.parseInt(request.getParameter("cargoId"));
            // 获取货物信息
            Cargo cargo = CargoService.getInstance().getCargo(id);
            request.setAttribute("cargo", cargo);
            // 获取该货物的承运请求
            List<Request> requestList = RequestService.getInstance().getRequestOfCargo(id);
            request.setAttribute("requestList", requestList);
            request.getRequestDispatcher("/cargoDetail.jsp").forward(request, response);
        }
    }
}

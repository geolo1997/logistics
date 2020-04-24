package pers.geolo.logistics.servlet.shipper;

import pers.geolo.logistics.entity.User;
import pers.geolo.logistics.service.CargoService;
import pers.geolo.logistics.util.ServletUtils;
import pers.geolo.logistics.constant.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 桀骜
 */
@WebServlet(name = "SelectDriverServlet", urlPatterns = "/selectDriver")
public class SelectDriverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) { // 未登录
            response.sendRedirect(getServletContext().getContextPath() + "/login");
        } else if (user.getUserType() == UserType.DRIVER) { // 权限不足
            ServletUtils.returnJSON(response, "{\"response\":\"permissionDenied\"}");
        } else {
            int cargoId = Integer.parseInt(request.getParameter("cargoId"));
            int driverId = Integer.parseInt(request.getParameter("driverId"));
            CargoService.getInstance().selectDriver(cargoId, driverId);

            // 以JSON格式响应请求
            ServletUtils.returnJSON(response, "{\"response\":\"selectSuccess\"}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

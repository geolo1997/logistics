package pers.geolo.logistics.servlet.shipper;

import pers.geolo.logistics.entity.Cargo;
import pers.geolo.logistics.entity.User;
import pers.geolo.logistics.service.CargoService;
import pers.geolo.logistics.constant.UserType;

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
@WebServlet(name = "MyPublishServlet", urlPatterns = "/myPublish")
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
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else if (user.getUserType() == UserType.DRIVER) { // 权限不足
            response.sendRedirect(getServletContext().getContextPath() + "/permissionDenied.jsp");
        } else {
            List<Cargo> cargoList = CargoService.getInstance().getMyPublish(user.getId());
            request.setAttribute("cargoList", cargoList);
            request.getRequestDispatcher("/myPublish.jsp").forward(request, response);
        }
    }
}

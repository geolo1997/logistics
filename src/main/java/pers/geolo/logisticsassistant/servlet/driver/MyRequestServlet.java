package pers.geolo.logisticsassistant.servlet.driver;

import pers.geolo.logisticsassistant.entity.Request;
import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.service.RequestService;
import pers.geolo.logisticsassistant.value.UserType;

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
@WebServlet(name = "MyRequestServlet", urlPatterns = "/myRequest")
public class MyRequestServlet extends HttpServlet {

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
        } else if (user.getUserType() == UserType.SHIPPER) { // 权限不足
            response.sendRedirect(getServletContext().getContextPath() + "/permissionDenied.jsp");
        } else {
            List<Request> requestList = RequestService.getInstance().getMyRequest(user.getId());
            request.setAttribute("myRequest", requestList);
            request.getRequestDispatcher("/myRequest.jsp").forward(request, response);
        }
    }
}

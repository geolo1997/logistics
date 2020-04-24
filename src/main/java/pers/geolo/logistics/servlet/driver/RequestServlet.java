package pers.geolo.logistics.servlet.driver;

import pers.geolo.logistics.entity.Request;
import pers.geolo.logistics.entity.User;
import pers.geolo.logistics.service.RequestService;
import pers.geolo.logistics.util.ServletUtils;
import pers.geolo.logistics.constant.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @@author 鲍之骁
 */
@WebServlet(name = "RequestServlet", urlPatterns = "/request")
public class RequestServlet extends HttpServlet {

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
        } else if (user.getUserType() == UserType.SHIPPER) { // 权限不足
            // 以JSON格式响应请求
            ServletUtils.returnJSON(response, "{\"response\":\"requestFailure\"}");
        } else {
            int cargoId = Integer.parseInt(request.getParameter("cargoId"));
            Request cargoRequest = new Request(user.getId(), cargoId, new Date());
            RequestService.getInstance().save(cargoRequest);
            // 以JSON格式响应请求
            ServletUtils.returnJSON(response, "{\"response\":\"requestSuccess\"}");
        }
    }

}

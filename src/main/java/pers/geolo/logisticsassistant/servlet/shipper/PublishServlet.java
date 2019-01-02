package pers.geolo.logisticsassistant.servlet.shipper;

import pers.geolo.logisticsassistant.entity.Cargo;
import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.service.CargoService;
import pers.geolo.logisticsassistant.util.MyBeanUtils;
import pers.geolo.logisticsassistant.value.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 桀骜
 */
@WebServlet(name = "PublishServlet", urlPatterns = "/publish")
public class PublishServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) { // 未登录
            response.sendRedirect(getServletContext().getContextPath() + "/login");
        } else if (user.getUserType() == UserType.DRIVER) { // 权限不足
            response.sendRedirect(getServletContext().getContextPath() + "/permissionDenied.jsp");
        } else {
            Cargo cargo = MyBeanUtils.getBean(request, Cargo.class);
            CargoService.getInstance().publish(user, cargo);
            // 重定向至发布成功页面
            response.sendRedirect(request.getContextPath() + "/publishSuccess.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            // 转发至发布货物信息页面
            request.getRequestDispatcher("/publish.jsp").forward(request, response);
        }
    }
}

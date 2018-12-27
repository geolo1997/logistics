package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.Cargo;
import pers.geolo.LogisticsAssistant.service.TradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 桀骜
 */
@WebServlet(name = "CargoDetailServlet", urlPatterns = "/cargoDetail")
public class CargoDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (int) request.getSession().getAttribute("cargoId");
        Cargo cargo = TradeService.getInstance().getCargoDetail(id);
        request.getSession().setAttribute("cargoDetail", cargo);
        response.sendRedirect(getServletContext().getContextPath() + "/cargoDetail.jsp");
    }
}

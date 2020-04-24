package pers.geolo.logistics.servlet.driver;

import org.apache.log4j.Logger;
import pers.geolo.logistics.entity.Cargo;
import pers.geolo.logistics.entity.User;
import pers.geolo.logistics.service.CargoService;
import pers.geolo.logistics.constant.CargoType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 鲍之骁
 */
@WebServlet(name = "AllPublishedServlet", urlPatterns = "/allPublished")
public class AllPublishedServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AllPublishedServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            String origin = request.getParameter("origin");
            String destination = request.getParameter("destination");
            String cargoTypeString = request.getParameter("cargoType");
            CargoType cargoType;
            LOGGER.info("货物查询条件： 出发点:" + origin + " 终点:" + destination + " 货物类型:" + cargoTypeString);

            if (cargoTypeString != null && !cargoTypeString.equals("")) {
                cargoType = CargoType.valueOf(cargoTypeString.toUpperCase());
            } else {
                cargoType = CargoType.UNDEFINE;
            }
             List<Cargo> allCargoList = CargoService.getInstance().getCargo(origin, destination,
                    cargoType);
            request.setAttribute("origin", origin);
            request.setAttribute("destination", destination);
            request.setAttribute("cargoType", cargoType);
            request.setAttribute("allCargoList", allCargoList);
            request.getRequestDispatcher("/allPublished.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            List<Cargo> allCargoList = CargoService.getInstance().getAllPublished();
            request.setAttribute("allCargoList", allCargoList);
            request.getRequestDispatcher("/allPublished.jsp").forward(request, response);
        }
    }
}

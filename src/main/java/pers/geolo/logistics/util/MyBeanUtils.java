package pers.geolo.logistics.util;

import org.apache.commons.beanutils.BeanUtils;
import pers.geolo.logistics.constant.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author 桀骜
 * Bean工具类
 */
public class MyBeanUtils {

    /**
     * 将request请求中的参数提取为clazz对象
     *
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(HttpServletRequest request, Class<T> clazz) {
        // test
//        if (request.getParameter("username") != null) {
//            User user = new User();
//            user.setUsername(request.getParameter("username"));
//            user.setPassword(request.getParameter("password"));
//            user.setEmail(request.getParameter("email"));
//            return (T) user;
//        } else if (request.getParameter("cargoName") != null) {
//            // TODO 将货主设置为当前会话用户
//            Cargo cargo = new Cargo();
//            cargo.setCargoName(request.getParameter("cargoName"));
//            return (T) cargo;
//        }
        try {
            T bean = clazz.newInstance();
            Enumeration<String> e = request.getParameterNames();
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                String value = request.getParameter(name);
                if (value != null) {
                    if ("userType".equals(name)) {
                        BeanUtils.setProperty(bean, name, UserType.valueOf(value.toUpperCase()));
                    } else if ("cargoType".equals(name)) {
                        BeanUtils.setProperty(bean, name, CargoType.valueOf(value.toUpperCase()));
                    } else if ("vehicleType".equals(name)) {
                        BeanUtils.setProperty(bean, name, VehicleType.valueOf(value.toUpperCase()));
                    } else if ("transportableType".equals(name)) {
                        BeanUtils.setProperty(bean, name, TransportableType.valueOf(value.toUpperCase()));
                    } else if ("cargoState".equals(name)) {
                        BeanUtils.setProperty(bean, name, CargoState.valueOf(value.toUpperCase()));
                    } else {
                        BeanUtils.setProperty(bean, name, value);
                    }
                }
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

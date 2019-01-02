package pers.geolo.logisticsassistant.util;

import org.apache.commons.beanutils.BeanUtils;
import pers.geolo.logisticsassistant.value.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOUtils {

    public static <T> List<T> getList(ResultSet resultSet, Class<T> clazz) throws SQLException {
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(getBean(resultSet, clazz));
        }
        return list;
    }

    public static <T> T getBean(ResultSet resultSet, Class<T> clazz) throws SQLException {
        try {
            T bean = clazz.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int col = metaData.getColumnCount();
            for (int i = 1; i <= col; i++) {
                String name = metaData.getColumnName(i);
                String value = resultSet.getString(name);
                if (value != null) {
                    if ("userTypeId".equals(name)) {
                        BeanUtils.setProperty(bean, "userType",
                                UserType.values()[Integer.valueOf(value)]);
                    } else if ("cargoTypeId".equals(name)) {
                        BeanUtils.setProperty(bean, "cargoType",
                                CargoType.values()[Integer.valueOf(value)]);
                    } else if ("vehicleTypeId".equals(name)) {
                        BeanUtils.setProperty(bean, "vehicleType",
                                VehicleType.values()[Integer.valueOf(value)]);
                    } else if ("transportableTypeId".equals(name)) {
                        BeanUtils.setProperty(bean, "transportableType",
                                TransportableType.values()[Integer.valueOf(value)]);
                    } else if ("cargoStateId".equals(name)) {
                        BeanUtils.setProperty(bean, "cargoState",
                                CargoState.values()[Integer.valueOf(value)]);
                    } else if (name.endsWith("Time")) {
                        BeanUtils.setProperty(bean, name, toDate(value));
                    } else {
                        BeanUtils.setProperty(bean, name, value);
                    }
                }
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
        String dateString = dateFormat.format(date);
        return dateString;
    }

    public static Date toDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("日期解析失败");
            e.printStackTrace();
        }
        return date;
    }
}

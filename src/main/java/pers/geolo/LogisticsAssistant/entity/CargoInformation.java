package pers.geolo.LogisticsAssistant.entity;

import java.util.Date;

public class CargoInformation {

    // 货物编号
    private int id;
    // 货主用户名
    private String shipper;
    // 发布时间
    private Date publishTime;
    // 货物名称
    private String cargoName;
    // 货物类型
    private CargoType cargoType;
    // 起点
    private String orgin;
    // 终点
    private String destination;
    // 距离
    private float distance;
    // 运费
    private float freight;


    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    @Override
    public String toString() {
        return shipper + cargoName;
    }
}

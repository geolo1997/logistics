package pers.geolo.LogisticsAssistant.entity;

import pers.geolo.LogisticsAssistant.value.CargoState;
import pers.geolo.LogisticsAssistant.value.CargoType;

import java.util.Date;

public class Cargo {

    // 货物编号 主键
    private int cargoNumber;
    // 货主用户名
    private String shipperUsername;
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

    // 承运司机
    private String driverUsername;
    // 货物状态
    private CargoState cargoState;


    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    @Override
    public String toString() {
        return shipperUsername + cargoName;
    }

    public int getCargoNumber() {
        return cargoNumber;
    }
}

package pers.geolo.logisticsassistant.entity;

import pers.geolo.logisticsassistant.value.CargoState;
import pers.geolo.logisticsassistant.value.CargoType;

import java.util.Date;

/**
 * @author 桀骜
 * 货物信息
 */
public class Cargo {

    // 货物编号 主键
    private int id;
    // 货主用户名
    private int shipperId;
    // 发布时间
    private Date publishTime;
    // 货物名称
    private String cargoName;
    // 货物类型
    private CargoType cargoType;
    // 起点
    private String origin;
    // 终点
    private String destination;
    // 距离
    private float distance;
    // 运费
    private float freight;

    // 货物状态
    private CargoState cargoState;
    // 承运司机
    private int driverId;
    // 成交时间
    private Date dealTime;

    public void setId(int id) {
        this.id = id;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getCargoName() {
        return cargoName;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public CargoState getCargoState() {
        return cargoState;
    }

    public void setCargoState(CargoState cargoState) {
        this.cargoState = cargoState;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }


    public int getId() {
        return id;
    }

    public static Cargo getTestInstance() {
        Cargo cargo = new Cargo();
        cargo.id = 1;
        cargo.cargoName = "家具";
        cargo.publishTime = new Date();
        cargo.shipperId =123;
        cargo.driverId = 4645;
        cargo.cargoState = CargoState.WAITING_FOR_DRIVER;
        return cargo;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}

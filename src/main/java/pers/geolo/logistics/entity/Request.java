package pers.geolo.logistics.entity;

import java.util.Date;

/**
 * @author 桀骜
 *
 * 承运申请
 */
public class Request {

    // 申请编号
    private int id;
    // 司机用户名
    private int driverId;
    // 货物编号
    private int cargoId;
    // 申请时间
    private Date requestTime;

    public Request() {
    }

    public Request(int driverId, int cargoId, Date requestTime) {
        this.driverId = driverId;
        this.cargoId = cargoId;
        this.requestTime = requestTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}

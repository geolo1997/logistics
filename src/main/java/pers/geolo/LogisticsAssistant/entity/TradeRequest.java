package pers.geolo.LogisticsAssistant.entity;

import java.util.Date;

/**
 * @author 桀骜
 */
public class TradeRequest {

    // 请求编号
    private int number;
    // 司机用户名
    private String driverUsername;
    // 货物编号
    private int CargoNumber;
    // 申请时间
    private Date requestTime;

    public TradeRequest() {
    }

    public TradeRequest(int number, String driverUsername, int cargoNumber, Date requestTime) {
        this.number = number;
        this.driverUsername = driverUsername;
        CargoNumber = cargoNumber;
        this.requestTime = requestTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDriverUsername() {
        return driverUsername;
    }

    public void setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }

    public int getCargoNumber() {
        return CargoNumber;
    }

    public void setCargoNumber(int cargoNumber) {
        CargoNumber = cargoNumber;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}

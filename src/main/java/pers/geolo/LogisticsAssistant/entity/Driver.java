package pers.geolo.LogisticsAssistant.entity;

public class Driver extends User {

    private String realName;
    private String telephone;
    private VehicleType vehicleType;
    private String licensePlateNumber;
    private TransportableType transportableType;

    public Driver() {

    }

    public Driver(String username, String password, String email, UserType userType,
                  String realName, String telephone, VehicleType vehicleType,
                  String licensePlateNumber, TransportableType transportableType) {
        super(username, password, email, userType);
        this.realName = realName;
        this.telephone = telephone;
        this.vehicleType = vehicleType;
        this.licensePlateNumber = licensePlateNumber;
        this.transportableType = transportableType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public TransportableType getTransportableType() {
        return transportableType;
    }

    public void setTransportableType(TransportableType transportableType) {
        this.transportableType = transportableType;
    }
}

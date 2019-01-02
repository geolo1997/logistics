package pers.geolo.logisticsassistant.entity;

import pers.geolo.logisticsassistant.value.TransportableType;
import pers.geolo.logisticsassistant.value.UserType;
import pers.geolo.logisticsassistant.value.VehicleType;

public class User {

    // 自增主键
    private int id;
    // 公有属性
    private String username;
    private String password;
    private String email;
    private UserType userType;
    private String realName;
    private String telephone;
    // 司机独有属性
    private VehicleType vehicleType;
    private String licensePlateNumber;
    private TransportableType transportableType;
    // 货主独有属性
    private String address;

    public User() {
        username = "";
        userType = UserType.UNDEFINE;
        vehicleType = VehicleType.UNDEFINE;
        transportableType = TransportableType.UNDEFINE;
    }

    public User(String username, String password, String email, UserType userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public User(String username, String password, String email, UserType userType,
                String realName, String telephone, VehicleType vehicleType,
                String licensePlateNumber, TransportableType transportableType, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.realName = realName;
        this.telephone = telephone;
        this.vehicleType = vehicleType;
        this.licensePlateNumber = licensePlateNumber;
        this.transportableType = transportableType;
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", realName='" + realName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", vehicleType=" + vehicleType +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", transportableType=" + transportableType +
                ", address='" + address + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUserTypeString() {
        if (userType == UserType.UNDEFINE) {
            return "未选择";
        } else if (userType == UserType.DRIVER) {
            return "司机";
        } else if (userType == UserType.SHIPPER) {
            return "货主";
        } else if (userType == UserType.DRIVER_AND_SHIPPER) {
            return "司机和货主";
        }
        return null;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String string) {
    }

    public static User getTestInstance() {
        User user = new User();
        user.username = "小明";
        user.password = "123456";
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

-- 定义车型表
CREATE TABLE VehicleType (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20)
);

-- 定义可运输类型表
CREATE TABLE TransportableType (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20)
);

-- 定义用户类型表
CREATE TABLE UserType (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20)
);

-- 定义货物类别表
CREATE TABLE CargoType (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20)
);


-- 定义用户表
CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 自增主键
    -- 注册所需属性
    username VARCHAR(20) UNIQUE NOT NULL, -- 用户名
    password VARCHAR(20) NOT NULL, -- 密码
    email VARCHAR(20) NOT NULL, -- 电子邮件地址
    userTypeId BIGINT NOT NULL REFERENCES UserType(id) , -- 用户类型
    -- 公有属性
    realName VARCHAR(20), -- 真实姓名
    telephone VARCHAR(20), -- 电话号码
    -- 司机独有属性
    vehicleTypeId BIGINT REFERENCES VehicleType(id),  -- 车型
    transportableTypeId BIGINT REFERENCES TransportableType(id), -- 可运输类型
    licensePlateNumber VARCHAR(10), -- 车牌号
    -- 货主独有属性 
    address VARCHAR(50) -- 地址
);

-- 定义货物状态表
CREATE TABLE CargoState (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20)
);

-- 定义货物信息表
CREATE TABLE Cargo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 货物编号，自增主键
    shipperId BIGINT REFERENCES User(id), -- 货主id
    cargoName VARCHAR(20), -- 货物名称
    cargoTypeId BIGINT REFERENCES CargoType(id), -- 货物类型
    origin VARCHAR(50), -- 起点
    destination VARCHAR(50), -- 终点
    distance REAL, -- 距离
    freight REAL, -- 费用
    publishTime DATETIME, -- 发布时间

    cargoStateId BIGINT REFERENCES CargoState(id), -- 货物状态
    driverId BIGINT REFERENCES User(id), -- 承运司机
    dealTime DATETIME -- 成交时间
);

-- 定义承运申请表
CREATE TABLE Request (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 承运编号，自增主键
    driverId BIGINT REFERENCES User(id), -- 司机用户名
    cargoId BIGINT REFERENCES Cargo(id), -- 货物编号
    requestTime DATETIME -- 申请时间
);

-- -- 定义货物订单表
-- CREATE TABLE TradeOrder (
--     id BIGINT IDENTITY(0, 1) PRIMARY KEY, -- 订单编号，自增主键
--     driverId VARCHAR(20) REFERENCES User(id), -- 司机用户名
--     dealTime DATETIME -- 成交时间
-- );

-- -- 定义订单明细表
-- CREATE TABLE OrderDetail (
--     detailNumber BIGINT IDENTITY(0, 1) PRIMARY KEY, -- 明细表编号，自增主键
--     tradeOrderId BIGINT REFERENCES TradeOrder(id), -- 订单编号
--     requestId BIGINT REFERENCES Request(id), -- 承运编号
--     cargoId BIGINT REFERENCES Cargo(cargoId) -- 货物编号
-- );

-- 查询某用户发布的货物信息
SELECT Cargo.*
FROM Cargo, User
WHERE Cargo.shipper = User.id AND
    User.name = ?
package pers.geolo.logisticsassistant.value;

public enum CargoState {
    WAITING_FOR_DRIVER, // 等待承运
    DRIVER_SELECTED, // 选定司机
    IN_TRANSIT, // 运输中
    ARRIVE, // 到达目的地
    FINISH //完成运输
}

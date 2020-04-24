package pers.geolo.logistics.dao;

import pers.geolo.logistics.entity.Request;

import java.util.List;

/**
 * @author  鲍之骁
 */
public interface RequestDAO {

    void save(Request request);

    List<Request> listRequestOfDriver(int driverId);

    List<Request> listRequestOfCargo(int cargoId);
}

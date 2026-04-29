package com.radkevich.warehause;

import com.radkevich.entity.Statistics;
import com.radkevich.exeption.WarehouseException;

import java.util.Optional;

public interface Warehouse {

    Optional<Statistics> get(Long id);
    void add(Long id, Statistics statistics) throws WarehouseException;

    void update(Long id, Statistics statistics) throws WarehouseException;
    void remove(Long id) throws WarehouseException;
    boolean isPresent(Long id);
}

package com.radkevich.warehause.impl;

import com.radkevich.entity.Statistics;
import com.radkevich.exeption.WarehouseException;
import com.radkevich.repository.impl.CustomArrayRepositoryImpl;
import com.radkevich.warehause.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WarehouseImpl implements Warehouse {
    Map<Long, Statistics> statisticsMap = new HashMap<>();
    static final Logger log = LogManager.getLogger(CustomArrayRepositoryImpl.class);
    private static WarehouseImpl instance;

    public static WarehouseImpl getInstance (){
        if(instance == null){
            instance= new WarehouseImpl();
        }
        return instance;
    }

   private WarehouseImpl() {
    }

    @Override
    public Optional<Statistics> get(Long id) {
// Returns the statistics for the given ID If the ID is not found or is null, returns Optional.empty
       return Optional.ofNullable(statisticsMap.get(id));
    }

    @Override
    public void add(Long id, Statistics statistics) throws WarehouseException {

        if(statistics == null){
            throw new WarehouseException("Statistics object cannot be null");
        }

        if(isPresent(id)){
            throw new WarehouseException("Statistics for ID " + id + " already exists");
        }
        statisticsMap.put(id, statistics);
        log.info("Warehouse state changed for ID {}: {}", id, statistics);
    }


    @Override
    public void update(Long id, Statistics statistics) throws WarehouseException {

        if(statistics == null){
            throw new WarehouseException("Statistics object cannot be null");
        }

        if(!statisticsMap.containsKey(id)){
            throw new WarehouseException("Statistics for ID " + id + " does not exist");
        }
        statisticsMap.put(id, statistics);
        log.info("Updated existing statistics: id={}, newStats={}", id, statistics);
    }



    @Override
    public void remove(Long id) throws WarehouseException {
        if(!isPresent(id)){
            throw new WarehouseException("ID " + id + " does not exist");
        }
        statisticsMap.remove(id);
        log.info("Cleared statistics from warehouse: id={}", id);

    }

    @Override
    public boolean isPresent(Long id) {
        return statisticsMap.containsKey(id);
    }
}


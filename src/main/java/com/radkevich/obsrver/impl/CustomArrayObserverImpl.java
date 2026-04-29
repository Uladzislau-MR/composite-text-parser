package com.radkevich.obsrver.impl;

import com.radkevich.calculator.CustomArrayCalculator;
import com.radkevich.calculator.impl.CustomArrayCalculatorImpl;
import com.radkevich.entity.CustomArray;
import com.radkevich.entity.CustomArrayEvent;
import com.radkevich.entity.Statistics;
import com.radkevich.exeption.WarehouseException;
import com.radkevich.obsrver.CustomArrayObserver;
import com.radkevich.repository.impl.CustomArrayRepositoryImpl;
import com.radkevich.warehause.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayObserverImpl implements CustomArrayObserver {

    private static final Logger log = LogManager.getLogger(CustomArrayRepositoryImpl.class);
    @Override
    public void update(CustomArrayEvent event) {
        CustomArray array = event.getSource();
        CustomArrayCalculator calculator = new CustomArrayCalculatorImpl();
        Statistics stats = calculator.createStatistics(array);
        WarehouseImpl warehouse = WarehouseImpl.getInstance();
        try {
            warehouse.update(array.getId(), stats);
        } catch (WarehouseException e) {
            log.error("Error updating warehouse for array ID: " + array.getId(), e);
        }
    }


}

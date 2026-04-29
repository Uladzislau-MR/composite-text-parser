package com.radkevich.specification.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.specification.CustomArraySpecification;
import com.radkevich.warehause.impl.WarehouseImpl;

public class AverageValueSpecificationImpl implements CustomArraySpecification {
    private final double targetAverage;

    public AverageValueSpecificationImpl(double targetAverage) {
        this.targetAverage = targetAverage;
    }

    @Override
    public boolean specify(CustomArray array) {
        double epsilon = 0.01;
        return WarehouseImpl.getInstance()
                .get(array.getId())
                .map(stats -> Math.abs(stats.getAverage() - targetAverage) < epsilon)
                .orElse(false);
    }
}
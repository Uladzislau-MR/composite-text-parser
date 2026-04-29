package com.radkevich.specification.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.specification.CustomArraySpecification;
import com.radkevich.warehause.impl.WarehouseImpl;

public class MinimumValueSpecificationImpl implements CustomArraySpecification {
    private final int min;

    public MinimumValueSpecificationImpl(int min) {
        this.min = min;
    }


    @Override
    public boolean specify(CustomArray array) {
        return WarehouseImpl.getInstance().get(array.getId()).map(statistics -> statistics.getMin() == min).orElse(false);
    }


}

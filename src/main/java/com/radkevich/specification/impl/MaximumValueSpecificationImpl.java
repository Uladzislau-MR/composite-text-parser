package com.radkevich.specification.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.specification.CustomArraySpecification;
import com.radkevich.warehause.impl.WarehouseImpl;

public class MaximumValueSpecificationImpl implements CustomArraySpecification {
    private final int max;

    public MaximumValueSpecificationImpl(int max) {
        this.max = max;
    }


    @Override
    public boolean specify(CustomArray array) {
        return WarehouseImpl.getInstance().get(array.getId()).map(statistics -> statistics.getMax() == max).orElse(false);
    }


}

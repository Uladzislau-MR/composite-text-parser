package com.radkevich.specification.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.specification.CustomArraySpecification;



public class SizeLessSpec implements CustomArraySpecification {
      private final int targetValue;

    public SizeLessSpec(int targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public boolean specify(CustomArray array) {
        return array.getElements().length < targetValue;
    }
}

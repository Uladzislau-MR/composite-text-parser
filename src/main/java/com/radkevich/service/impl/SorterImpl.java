package com.radkevich.service.impl;

import com.radkevich.comparator.CustomArrayComparators;
import com.radkevich.entity.CustomArray;
import com.radkevich.service.Sorter;

import java.util.List;

public class SorterImpl implements Sorter {

    public List<CustomArray> sortById(List<CustomArray> arrayList){
        return arrayList.stream().sorted(CustomArrayComparators.BY_ID).toList();
    }

    public List<CustomArray> sortByFirstElement(List<CustomArray> arrayList){
        return arrayList.stream().sorted(CustomArrayComparators.BY_FIRST_ELEMENT).toList();
    }

    public List<CustomArray> sortByLength(List<CustomArray> arrayList){
        return arrayList.stream().sorted(CustomArrayComparators.BY_ARRAY_LENGTH).toList();
    }

}

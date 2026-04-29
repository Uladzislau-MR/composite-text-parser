package com.radkevich.service;

import com.radkevich.comparator.CustomArrayComparators;
import com.radkevich.entity.CustomArray;

import java.util.List;

public interface Sorter {
    public List<CustomArray> sortById(List<CustomArray> arrayList);


    public List<CustomArray> sortByFirstElement(List<CustomArray> arrayList);

    public List<CustomArray> sortByLength(List<CustomArray> arrayList);

}

package com.radkevich.service;

import com.radkevich.entity.CustomArray;
import com.radkevich.entity.Statistics;
import com.radkevich.exeption.ReadingException;
import com.radkevich.exeption.RepositoryException;
import com.radkevich.exeption.WarehouseException;

import java.util.List;

public interface CustomArrayService {

    List<CustomArray> createFromFile(String fileName) throws ReadingException;

    Statistics createStatistics(CustomArray array);

    void add(List<CustomArray> arraysList) throws RepositoryException, WarehouseException;

    List<CustomArray> findByAverage(double average);

    List<CustomArray> findByMax(int max);

    List<CustomArray> findByMin(int min);

    List<CustomArray> findBySizeEqual(int size);

    List<CustomArray> findBySizeGreater(int size);

    List<CustomArray> findBySizeLess(int size);

    int findMin(CustomArray array);

    int findMax(CustomArray array);

    int findSum(CustomArray array);

    double findAverage(CustomArray array);

    List<CustomArray> sortById(List<CustomArray> arrayList);

    List<CustomArray> sortByFirstElement(List<CustomArray> arrayList);

    List<CustomArray> sortByLength(List<CustomArray> arrayList);
}
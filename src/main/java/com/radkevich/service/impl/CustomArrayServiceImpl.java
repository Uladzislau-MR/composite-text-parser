package com.radkevich.service.impl;

import com.radkevich.calculator.CustomArrayCalculator;
import com.radkevich.entity.CustomArray;
import com.radkevich.entity.Statistics;
import com.radkevich.exeption.ReadingException;
import com.radkevich.exeption.RepositoryException;
import com.radkevich.exeption.WarehouseException;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.parser.CustomParser;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.repository.CustomArrayRepository;
import com.radkevich.service.CustomArrayService;

import com.radkevich.service.Sorter;
import com.radkevich.specification.CustomArraySpecification;
import com.radkevich.specification.impl.*;
import com.radkevich.warehause.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CustomArrayServiceImpl implements CustomArrayService {

    private static final Logger logger = LogManager.getLogger(CustomArrayServiceImpl.class);
    private final CustomArrayReader reader;
    private final CustomParser parser;
    private final CustomArrayFactory factory;
    private final CustomArrayRepository repository;
    private final Warehouse warehouse;
    private final CustomArrayCalculator calculator;
    private final Sorter sorter;



    public CustomArrayServiceImpl(CustomArrayReader reader, CustomParser parser, CustomArrayFactory factory,
                                  CustomArrayRepository repository, Warehouse warehouse, CustomArrayCalculator calculator, Sorter sorter) {
        this.reader = reader;
        this.parser = parser;
        this.factory = factory;
        this.repository = repository;
        this.warehouse = warehouse;
        this.calculator = calculator;
        this.sorter = sorter;
    }




    public List<CustomArray> createFromFile(String fileName) throws ReadingException {
        String data = reader.readAllData(fileName);
        List<int[]> numbers = parser.parse(data);
        return factory.createArraysList(numbers);
    }

    public Statistics createStatistics(CustomArray array) {
        return calculator.createStatistics(array);
    }

    public void add(List<CustomArray> arraysList) throws RepositoryException, WarehouseException {
        for (CustomArray array : arraysList) {
            repository.add(array);
            long id = array.getId();
            warehouse.add(id, createStatistics(array));
        }
    }



    public List<CustomArray> findByAverage(double average) {
        CustomArraySpecification spec = new AverageValueSpecificationImpl(average);
        return repository.query(spec);
    }


    public List<CustomArray> findByMax(int max) {
        CustomArraySpecification spec = new MaximumValueSpecificationImpl(max);
        return repository.query(spec);
    }


    public List<CustomArray> findByMin(int min) {
        CustomArraySpecification spec = new MinimumValueSpecificationImpl(min);
        return repository.query(spec);
    }


    public List<CustomArray> findBySizeEqual(int size) {
        CustomArraySpecification spec = new SizeEqualSpec(size);
        return repository.query(spec);
    }


    public List<CustomArray> findBySizeGreater(int size) {
        CustomArraySpecification spec = new SizeGreaterSpec(size);
        return repository.query(spec);
    }


    public List<CustomArray> findBySizeLess(int size) {
        CustomArraySpecification spec = new SizeLessSpec(size);
        return repository.query(spec);
    }

    @Override
    public int findMin(CustomArray array) {
        return calculator.findMin(array);
    }

    @Override
    public int findMax(CustomArray array) {

        return calculator.findMax(array);

    }

    @Override
    public int findSum(CustomArray array) {

        return calculator.findSum(array);

    }

    @Override
    public double findAverage(CustomArray array) {
        return calculator.findAverage(array);

    }



    @Override
    public List<CustomArray> sortById(List<CustomArray> arrayList) {
       return sorter.sortById(arrayList);
    }
    @Override
    public List<CustomArray> sortByFirstElement(List<CustomArray> arrayList) {
        return sorter.sortByFirstElement(arrayList);
    }
    @Override
    public List<CustomArray> sortByLength(List<CustomArray> arrayList) {
        return sorter.sortByLength(arrayList);
    }

}
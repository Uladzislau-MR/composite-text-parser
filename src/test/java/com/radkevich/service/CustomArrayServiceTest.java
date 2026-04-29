package com.radkevich.service;

import com.radkevich.calculator.CustomArrayCalculator;
import com.radkevich.calculator.impl.CustomArrayCalculatorImpl;
import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.ReadingException;
import com.radkevich.exeption.RepositoryException;
import com.radkevich.exeption.WarehouseException;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.factory.impl.CustomArrayFactoryImpl;
import com.radkevich.parser.CustomParser;
import com.radkevich.parser.impl.CustomParserImpl;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.reader.impl.CustomArrayReaderImpl;
import com.radkevich.repository.CustomArrayRepository;
import com.radkevich.repository.impl.CustomArrayRepositoryImpl;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import com.radkevich.service.impl.SorterImpl;
import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;
import com.radkevich.warehause.impl.WarehouseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomArrayServiceTest {
    CustomArrayService customArrayService;
    CustomArray testArray;
    String fileName = "Data.txt";
    private CustomArrayReader reader;
    private CustomArrayValidator validator;
    private CustomParser parser;
    private CustomArrayFactory factory;
    private CustomArrayRepository repository;
    private WarehouseImpl warehouse;
    private CustomArrayCalculator calculator;
    private Sorter sorter;
    private List<CustomArray> arrays;
    @BeforeEach
    public void setup() throws ReadingException, RepositoryException, WarehouseException {
        reader = new CustomArrayReaderImpl();
        validator = new CustomArrayValidatorImpl();
        parser = new CustomParserImpl(validator);
        factory = new CustomArrayFactoryImpl();
        repository = CustomArrayRepositoryImpl.getInstance();
        warehouse = WarehouseImpl.getInstance();
        calculator = new CustomArrayCalculatorImpl();
        sorter = new SorterImpl();

        customArrayService = new CustomArrayServiceImpl(reader, parser, factory, repository, warehouse, calculator, sorter);
        arrays = customArrayService.createFromFile(fileName);
        customArrayService.add(arrays);

    }

    @Test
    public void createFromFile() throws ReadingException {
        List<CustomArray> result = customArrayService.createFromFile(fileName);
        Assertions.assertEquals(5, result.size(), "Should create 5 arrays from Data.txt");
        int[] expected = {10, 20, 17};
        Assertions.assertArrayEquals(expected, result.get(0).getElements(), "First array elements mismatch");
    }



    @Test
    public void findByAverageQuery() {
        List<CustomArray> found = customArrayService.findByAverage(15.666);
        Assertions.assertFalse(found.isEmpty());
        Assertions.assertEquals(arrays.get(0).getId(), found.get(0).getId());
    }

    @Test
    public void findByMaxQuery() {
        List<CustomArray> found = customArrayService.findByMax(77);

        Assertions.assertFalse(found.isEmpty());
    }

    @Test
    public void findByMinQuery() {
        List<CustomArray> found = customArrayService.findByMin(1);
        Assertions.assertFalse(found.isEmpty());
    }

    @Test
    public void findBySizeEqualQuery() {
        List<CustomArray> found = customArrayService.findBySizeEqual(3);
        Assertions.assertFalse(found.isEmpty());
        Assertions.assertEquals(3, found.get(0).getElements().length);
    }

    @Test
    void findBySizeGreaterTest() {
        List<CustomArray> result = customArrayService.findBySizeGreater(2);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void findBySizeLessTest() {
        List<CustomArray> result = customArrayService.findBySizeLess(10);
        Assertions.assertFalse(result.isEmpty());
    }
}




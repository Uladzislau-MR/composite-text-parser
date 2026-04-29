package com.radkevich.hooks;

import com.radkevich.calculator.CustomArrayCalculator;
import com.radkevich.calculator.impl.CustomArrayCalculatorImpl;
import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.factory.impl.CustomArrayFactoryImpl;
import com.radkevich.parser.CustomParser;
import com.radkevich.parser.impl.CustomParserImpl;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.reader.impl.CustomArrayReaderImpl;
import com.radkevich.repository.CustomArrayRepository;
import com.radkevich.repository.impl.CustomArrayRepositoryImpl;
import com.radkevich.service.CustomArrayService;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import com.radkevich.service.impl.SorterImpl;
import com.radkevich.service.Sorter;
import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;
import com.radkevich.warehause.impl.WarehouseImpl;
import io.cucumber.java.Before;

public class Hooks {
    public static CustomArrayService customArrayService;

    @Before
    public void setup() {
        CustomArrayReader reader = new CustomArrayReaderImpl();
        CustomArrayValidator validator = new CustomArrayValidatorImpl();
        CustomParser parser = new CustomParserImpl(validator);
        CustomArrayFactory factory = new CustomArrayFactoryImpl();
        CustomArrayRepository repository = CustomArrayRepositoryImpl.getInstance();
        WarehouseImpl warehouse = WarehouseImpl.getInstance();
        CustomArrayCalculator customArrayCalculator = new CustomArrayCalculatorImpl();
        Sorter sorter = new SorterImpl();

        customArrayService = new CustomArrayServiceImpl(reader, parser, factory, repository, warehouse, customArrayCalculator, sorter);
    }
}
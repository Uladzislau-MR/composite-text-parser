package com.radkevich.hooks;

import com.radkevich.factory.CustomArrayFactory;
import com.radkevich.factory.impl.CustomArrayFactoryImpl;
import com.radkevich.parser.CustomParser;
import com.radkevich.parser.impl.CustomParserImpl;
import com.radkevich.reader.CustomArrayReader;
import com.radkevich.reader.impl.CustomArrayReaderImpl;
import com.radkevich.service.CustomArrayService;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import com.radkevich.validator.CustomArrayValidator;
import com.radkevich.validator.impl.CustomArrayValidatorImpl;
import io.cucumber.java.Before;


public class Hooks {
    public static CustomArrayService customArrayService;

    @Before
    public void setup() {
        CustomArrayReader reader = new CustomArrayReaderImpl();
        CustomArrayValidator validator = new CustomArrayValidatorImpl();
        CustomParser parser = new CustomParserImpl(validator);
        CustomArrayFactory factory = new CustomArrayFactoryImpl();

        customArrayService = new CustomArrayServiceImpl(reader, parser, factory);;
    }
}

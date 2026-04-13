package com.radkevich.hooks;

import com.radkevich.service.CustomArrayService;
import com.radkevich.service.impl.CustomArrayServiceImpl;
import io.cucumber.java.Before;


public class Hooks {
    public static CustomArrayService customArrayService;

    @Before
    public void setup() {
        customArrayService = new CustomArrayServiceImpl();
    }
}

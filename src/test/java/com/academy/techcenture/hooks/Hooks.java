package com.academy.techcenture.hooks;

import com.academy.techcenture.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeEachScenario(){
        Driver.getDriver();
    }

    @After
    public void afterEachScenario(){
//        Driver.quitDriver();
    }

}

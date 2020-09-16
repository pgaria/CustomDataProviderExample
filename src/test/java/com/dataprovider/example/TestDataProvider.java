package com.dataprovider.example;

import org.testng.annotations.Test;

public class TestDataProvider {

    @DataProviderCustom(dataProviderClass = ReadAutoData.class, startIndex = 0, endIndex = 3)
    @Test(dataProvider = "getData", dataProviderClass = DataProviderAdapter.class)
    public void testing(String userName, String password) {
        System.out.println("Running Test for " + userName + " and " + password);
    }
}

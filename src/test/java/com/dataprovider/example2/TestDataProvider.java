package com.dataprovider.example2;

import org.testng.annotations.Test;

public class TestDataProvider {

    @Test(dataProvider = "getData",dataProviderClass = ReadAutoData.class)
    public void normalTest(String userName, String password) {
        System.out.println("Running Test for " + userName + " and " + password);
    }

    @IndexAnnotation(startIndex = 0,endIndex = 4)
    @Test(dataProvider = "getData",dataProviderClass = ReadAutoData.class)
    public void withCustomIndex(String userName, String password) {
        System.out.println("Running Custom Test for " + userName + " and " + password);
    }
}

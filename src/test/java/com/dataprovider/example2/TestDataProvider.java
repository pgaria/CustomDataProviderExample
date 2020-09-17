package com.dataprovider.example2;

import org.testng.annotations.Test;

public class TestDataProvider {

    @Test(dataProvider = "getData", dataProviderClass = ReadAutoData.class)
    public void normalTest(String userName, String password) {
        System.out.println("Running Normal Test for " + userName + " and " + password);
    }

    @IndexAnnotation(startIndex = 0, endIndex = 4)
    @Test(dataProvider = "getData", dataProviderClass = ReadAutoData.class)
    public void withCustomIndex(String userName, String password) {
        System.out.println("Running Custom Test [0 -> 4 ] for " + userName + " and " + password);
    }

    @IndexAnnotation(startIndex = 0, endIndex = 2)
    @Test(dataProvider = "getData", dataProviderClass = ReadAutoData.class)
    public void withCustomIndex2(String userName, String password) {
        System.out.println("Running Custom Test [0 -> 2 ] for " + userName + " and " + password);
    }
}

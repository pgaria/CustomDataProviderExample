package com.dataprovider.example;

import org.testng.annotations.DataProvider;

public class ReadAutoData {

    @DataProvider(name = "getData")
    public static Object[][] getData(int startIndex,int endIndex) {
        Object[][] arrayObject = new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"},
                {"user4", "password4"}};
        System.out.println("Creating the DataProvider between Start Index: " + startIndex + " End Index: " + endIndex);
        return java.util.Arrays.copyOfRange(arrayObject, startIndex, endIndex);
    }
}

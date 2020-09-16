package com.dataprovider.example2;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;

public class ReadAutoData {

    @DataProvider(name = "getData")
    public static Object[][] getData(ITestContext context) {
        Method method = context.getAllTestMethods()[0].getConstructorOrMethod().getMethod();
        Object[][] arrayObject = new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"},
                {"user4", "password4"},
                {"user5", "password5"},
                {"user6", "password6"}};
        if (method.isAnnotationPresent(IndexAnnotation.class)) {
            IndexAnnotation indexes = method.getAnnotation(IndexAnnotation.class);
            System.out.println("Creating the DataProvider between Start Index: " + indexes.startIndex() + " End Index: " + indexes.endIndex());
            return java.util.Arrays.copyOfRange(arrayObject, indexes.startIndex(), indexes.endIndex());
        } else
            return arrayObject;
    }
}

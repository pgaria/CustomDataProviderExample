package com.dataprovider.example;

import org.testng.annotations.DataProvider;
import org.testng.internal.reflect.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class DataProviderAdapter {

    @DataProvider()
    public static Object[][] getData(Method method) throws InvocationTargetException, IllegalAccessException {
        DataProviderCustom info = method.getAnnotation(DataProviderCustom.class);
        if (info == null) {
            throw new RuntimeException("No Data Provider Found");
        }
        Method found  = ReflectionHelper.excludingMain(info.dataProviderClass())[0];
        return (Object[][]) found.invoke(new Object[]{}, info.startIndex(), info.endIndex());
    }
}
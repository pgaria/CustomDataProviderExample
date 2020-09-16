package com.dataprovider.example;

import org.testng.annotations.DataProvider;
import org.testng.internal.reflect.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class DataProviderAdapter {

    @DataProvider(name = "getData")
    public static Object[][] getData(Method method) throws InvocationTargetException, IllegalAccessException {
        DataProviderCustom info = method.getAnnotation(DataProviderCustom.class);
        if (info == null) {
            throw new RuntimeException("No Data Provider Found");
        }

        Class<?> clazz = info.dataProviderClass();
        String dpName = info.name();
        Method[] methods = ReflectionHelper.excludingMain(clazz);
        Method found = Stream.of(methods).filter(method1 -> {
                    DataProvider dp = method1.getAnnotation(DataProvider.class);
                    return dp != null &&
                            (dp.name().equalsIgnoreCase(dpName) || method1.getName().equalsIgnoreCase(dpName));

                }
        )
                .findFirst().orElseThrow(IllegalArgumentException::new);
        return (Object[][]) found.invoke(new Object[]{}, info.startIndex(), info.endIndex());
    }
}
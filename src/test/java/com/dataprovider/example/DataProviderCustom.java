package com.dataprovider.example;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface DataProviderCustom {

    Class<?> dataProviderClass();

    int startIndex() default 0;

    int endIndex() default 0;

}

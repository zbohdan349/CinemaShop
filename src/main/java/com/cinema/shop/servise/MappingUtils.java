package com.cinema.shop.servise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public  class MappingUtils {
    public static <T,F> T map(T to, F from)  {
        try {
            Field[] m1=to.getClass().getDeclaredFields();
            for (int i = 0; i < m1.length; i++) {
                String field = firstToUpperCase(m1[i].getName());
                String nameOfGetMethod ="get"+ field;
                String nameOfSetMethod ="set"+ field;
                Method getMethod = from.getClass().getMethod(nameOfGetMethod);
                Method setMethod = to.getClass().getMethod(nameOfSetMethod,getMethod.getReturnType());

                setMethod.invoke(to,getMethod.invoke(from));
            }
            return to;
        }catch (InvocationTargetException | IllegalAccessException  | NoSuchMethodException exception ){
            exception.getStackTrace();
        }
        return to;
    }
    private static String firstToUpperCase(String s){
        return  s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

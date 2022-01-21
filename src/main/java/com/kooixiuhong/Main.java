package com.kooixiuhong;

import com.kooixiuhong.commons.SolutionTest;
import com.kooixiuhong.commons.TestAggregator;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Main {

    private static Reflections reflections = new Reflections("com.kooixiuhong.challenges");
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        int returnCode = 0;
        Set<Class<? extends SolutionTest>> allClasses = reflections.getSubTypesOf(SolutionTest.class);
        for (Class<? extends SolutionTest> c : allClasses) {
            if (c.getName().endsWith("Test")) {
                Method m = c.getMethod("run");
                m.invoke(c);
            }
        }
        returnCode = TestAggregator.aggregate();
        System.exit(returnCode);
    }
}

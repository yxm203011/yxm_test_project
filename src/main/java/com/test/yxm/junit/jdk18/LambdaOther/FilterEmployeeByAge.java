package com.test.yxm.junit.jdk18.LambdaOther;

import com.test.yxm.junit.jdk18.entity.Employee;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 2;
    }
}

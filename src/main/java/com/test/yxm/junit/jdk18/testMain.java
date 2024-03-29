package com.test.yxm.junit.jdk18;

import com.test.yxm.junit.jdk18.entity.Employee;
import com.test.yxm.junit.jdk18.entity.project;
import com.test.yxm.junit.jdk18.LambdaOther.FilterEmployeeByAge;
import com.test.yxm.junit.jdk18.LambdaOther.MyPredicate;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class testMain {
    private static List<project> listProject = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            project p = new project();
            p.setCode("code_" + i);
            p.setColor("color_" + i);
            p.setName("name_" + i);
            p.setPrice(new BigDecimal("0.0" + i));
            listProject.add(p);
        }
    }

    public static void main(String[] args) {
        listProject.stream().filter((p) -> p.getPrice().compareTo(new BigDecimal("0.02")) == 1).forEach(System.out::println);

    }

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>();
    }

    @Test
    public void test2() {
        //Lambda表达式
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>();
    }

    @Test
    //当前员工中年龄大于等于2岁的
    public void test3() {
        List<Employee> list = filterEmployees(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void test4() {
        List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张1", 1, 1.11),
            new Employee("张2", 2, 2.22),
            new Employee("张3", 3, 3.33),
            new Employee("张4", 4, 4.44)
    );

    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emp = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= 2) {
                emp.add(employee);
            }
        }
        return emp;
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //匿名内部类
    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() >= 2;
            }
        });
    }

    @Test
    public void test6() {
        List<Employee> employees = filterEmployee(this.employees, (e) -> e.getAge() <= 3);
        employees.forEach(System.out::println);
    }

    @Test
    //Stream API
    public void test7() {
        employees.stream().filter(e -> e.getSalary() > 2.22).forEach(System.out::println);
        System.out.println("-----------");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }

    @Test
    public void test8(){
        Predicate<Integer> predicate = n -> n > 4;
        boolean test = predicate.test(3);
        System.out.println(test);
    }

    @Test
    //生成指定长度的随机字符串
    public void test9(){
        Function<Integer,String> randomStringFunction = l -> {
          String chars = "abcdefjhigklmnopqrstuvwxyz0123456789";
          StringBuffer stringBuffer = new StringBuffer();
          Random random = new Random();
            for (Integer i = 0; i < l; i++) {
                int i1 = random.nextInt(chars.length());
                stringBuffer.append(chars.charAt(i1));
            }
          return stringBuffer.toString();
        };
        String apply = randomStringFunction.apply(19);
        System.out.println(apply);
    }

    @Test
    public void test10(){
        Predicate<String> predicate = m -> m.equals("a");
        System.out.println(predicate.test("b"));
    }

    @Test
    public void test11(){
        outputValue(m -> System.out.println("像控制台打印"));
    }

    public void outputValue(Consumer<String> consumer){
        String test = "这是一个文本";
        consumer.accept(test);
    }

}

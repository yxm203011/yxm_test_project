package com.test.yxm.junit.jdk18;

import com.test.yxm.junit.jdk18.entity.Employee;
import com.test.yxm.junit.jdk18.entity.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 * <p>
 * 1.创建Stream
 * 2.中间操作
 * 筛选与切片
 * filter  接收Lambda，从流中排除某些元素，
 * limit   截断流，使其元素不超过给定数量
 * skip(n) 跳过元素给一个扔掉了前N个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
 * distinct 筛选，通过流所生成元素的hashCode和equals去除重复元素
 * <p>
 * 映射
 * map接收lambda，将元素转换成其他形式或者提取信息，接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素
 * flatMap  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接形成一个流
 * <p>
 * 排序
 * sorted()  自然排序（按照Compaarable排序为自然排序）
 * sorted(Comparator com) 定制排序
 * 3。终止操作（终端操作）
 * 查找与匹配
 * allMatch   检查是否匹配所有元素
 * anyMath    检查是否至少匹配一个元素
 * noneMath   检查是否没有匹配元素
 * findFirst  返回第一个元素
 * findAny     返回当前流中的任意元素
 * <p>
 * 规约
 * reduce(T identity,BinaryOperator)/reduce(BinaryOperator) 可以将流中的元素反复结合起来，得到一个值
 * <p>
 * 收集
 * collect  将流转换为其他形式，接受一个Collector接口的实现，用于给Stream中元素做汇总给方法
 */

public class TestStreamApi {

    @Test
    //创建Stream
    public void test1() {
        //可以通过Colection系列集合提供的Stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);
        //通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aaa", "bbb", "ccc");
        //创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张1", 1, 1.11),
            new Employee("张2", 2, 2.22),
            new Employee("张3", 3, 3.33),
            new Employee("张4", 4, 4.44)
    );

    @Test
    public void test2() {
        employees.stream().filter((e) -> e.getAge() > 3);
    }

    @Test
    public void test3() {
        employees.stream().filter((e) -> e.getSalary() > 3.33).limit(3).forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream().map((s) -> s.toUpperCase()).forEach(System.out::println);
    }

    List<Person> personList = Arrays.asList(
            new Person("Tom", 8900, "male", "New York"),
            new Person("Jack", 7000, "male", "Washington"),
            new Person("Lily", 7800, "female", "Washington"),
            new Person("Anni", 8200, "female", "New York"),
            new Person("Owen", 9500, "male", "New York"),
            new Person("Alisa", 7900, "female", "New York")
    );

    @Test
    public void test10() {
        List<Integer> list = Arrays.asList(7, 6, 8, 9, 4, 5, 2);
        list.stream().filter((i) -> i > 6).forEach(System.out::print);
        System.out.println("-------------------------------");
        Optional<Integer> first = list.stream().filter((i) -> i > 6).findFirst();
        Optional<Integer> first1 = list.parallelStream().filter((i) -> i > 6).findAny();
        boolean b = list.stream().anyMatch((i) -> i > 6);
        System.out.println(first.get());
        System.out.println("-------------------------------");
        System.out.println(first1.get());
        System.out.println("-------------------------------");

        System.out.println(b);
    }

    @Test
    public void test11() {
        List<String> collect = personList.stream().filter((e) -> e.getSalary() > 8000).map((m) -> m.getName()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test12() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println(max.get());
    }

    @Test
    public void test13() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        Optional<Integer> max = list.stream().max(Integer::compareTo);

        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(max.get());
        System.out.println(max1.get());

    }

    @Test
    public void test14() {
        Optional<Integer> integer = personList.stream().max(Comparator.comparingInt(Person::getSalary)).map((p) -> p.getSalary());
        System.out.println(integer.get());
    }

    @Test
    public void test15() {
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter((l) -> l > 6).count();
        System.out.println(count);
    }

    @Test
    public void test16() {
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> collect = Arrays.stream(strArr).map((s) -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> collect1 = intList.stream().map((i) -> i + 3).collect(Collectors.toList());
        System.out.println(collect1);
    }

    @Test
    public void test17() {
        List<Person> collect = personList.stream().map(p -> {
            p.setSalary(p.getSalary() + 1000);
            return p;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test18() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            return Arrays.stream(split);
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test19() {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        Integer integer = list.stream().reduce((x, y) -> x + y).get();
        System.out.println(integer);
    }

    @Test
    public void test20() {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> collect1 = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect1);

        Map<String, Person> collect2 = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println(collect2);
    }

    @Test
    public void test21() {
        Long collect = personList.stream().collect(Collectors.counting());
        System.out.println(collect);
        Double collect1 = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(collect1);
        Double collect2 = personList.stream().collect(Collectors.summingDouble(Person::getSalary));
        System.out.println(collect2);
        Optional<Integer> collect3 = personList.stream().map(person -> person.getSalary()).collect(Collectors.maxBy(Integer::sum));
        System.out.println(collect3.get());
        Person person = personList.stream().max((x, y) -> x.getSalary() > y.getSalary() ? 1 : -1).get();
        System.out.println(person);
    }

    @Test
    public void test22(){
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(p -> p.getSalary() > 8000));
        System.out.println(collect);
        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(p -> p.getSex(), Collectors.groupingBy(p -> p.getArea())));
        System.out.println(collect1);
    }

    @Test
    public void test23(){
        String collect = personList.stream().map(p -> p.getArea()).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test24(){
        List<String> collect = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(collect1);
        List<String> collect2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(collect2);
    }



}

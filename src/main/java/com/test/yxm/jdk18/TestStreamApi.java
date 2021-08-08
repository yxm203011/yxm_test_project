package com.test.yxm.jdk18;

import com.test.yxm.jdk18.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 *
 * 1.创建Stream
 * 2.中间操作
 *      筛选与切片
 *      filter  接收Lambda，从流中排除某些元素，
 *      limit   截断流，使其元素不超过给定数量
 *      skip(n) 跳过元素给一个扔掉了前N个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
 *      distinct 筛选，通过流所生成元素的hashCode和equals去除重复元素
 *
 *      映射
 *      map接收lambda，将元素转换成其他形式或者提取信息，接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素
 *      flatMap  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接形成一个流
 *
 *      排序
 *      sorted()  自然排序（按照Compaarable排序为自然排序）
 *      sorted(Comparator com) 定制排序
 * 3。终止操作（终端操作）
 *      查找与匹配
 *      allMatch   检查是否匹配所有元素
 *      anyMath    检查是否至少匹配一个元素
 *      noneMath   检查是否没有匹配元素
 *      findFirst  返回第一个元素
 *      findAny     返回当前流中的任意元素
 *
 *      规约
 *      reduce(T identity,BinaryOperator)/reduce(BinaryOperator) 可以将流中的元素反复结合起来，得到一个值
 *
 *      收集
 *      collect  将流转换为其他形式，接受一个Collector接口的实现，用于给Stream中元素做汇总给方法
 *
 */

public class TestStreamApi {

    @Test
    //创建Stream
    public void test1(){
        //可以通过Colection系列集合提供的Stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);
        //通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aaa","bbb","ccc");
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
    public void test2(){
        employees.stream().filter((e)->e.getAge() > 3);
    }

    @Test
    public void test3(){
        employees.stream().filter((e) -> e.getSalary()>3.33).limit(3).forEach(System.out::println);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list.stream().map((s) -> s.toUpperCase()).forEach(System.out::println);
    }

}

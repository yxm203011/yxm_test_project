package com.test.yxm.jdk18;

import com.test.yxm.jdk18.LambdaOther.MyFun;
import com.test.yxm.jdk18.entity.Employee;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 一、Lambda表达式的基础用法：java8中引入了一个新的操作符"->"该操作符称为箭头操作符或者Lambda操作符
 * 箭头操作符将Lambda表达式拆分为两部分：
 * <p>
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lanbda表达式中所需执行的功能，即Lambda体
 * <p>
 * 语法格式一：无参数，无返回值
 * () ->
 * <p>
 * 语法格式二：有一个参数，无返回值
 * (x) -> System.out.println(x);
 * <p>
 * 语法格式三：如果只有一个参数，箭头操作符前可以不加小括号
 * x -> System.out.println(x);
 * <p>
 * 语法格式四：有两个以上的参数，并且Lambda体中有多个返回值
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(x, y);
 * };
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以不写
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式六：Lambda表达式的参数列表中的数据类型可以不写，因为JVM编译器可以从上下文推断出参数类型，即“类型推断”
 * <p>
 * <p>
 * Lambda表达式需要“函数式接口支持”
 * 函数时接口：接口中只有一个抽象方法的接口，成为函数式接口，可以使用注解@FunctionalInterface修饰
 * 可以检查是否是函数式接口
 * <p>
 * JAVA8中内置的四大贺新函数式接口
 * Consumer<T>:消费性接口：
 * void accept(T t);
 * <p>
 * Supplier<T>:供给形接口：
 * T get();
 * <p>
 * Function<T,R>: 函数型接口:
 * R apply(T t);
 * <p>
 * Predicate<T>:断言型接口：
 * boolean test(T t);
 *
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 *          可以理解为方法引用是Lambda表达式的另一种表现形式
 *
 *主要有三种语法格式
 * 对象::实例方法对象
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：
 *
 * 1.Lambda体中调用的方法的参数列表与返回值类型，要与函数时接口中抽象方法的函数列表和返回值类型保持一致
 * 2.若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName:method
 *
 * 二、数组引用：
 * Type[]::new;
 */
public class TestLambda {

    @Test
    public void test1() {
        Runnable r1 = () -> System.out.println("Hello World!");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("111");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test5() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);


    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张1", 1, 1.11),
            new Employee("张2", 2, 2.22),
            new Employee("张3", 3, 3.33),
            new Employee("张4", 4, 4.44)
    );

    @Test
    public void test6() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    //消费型接口
    public void test7() {
        happy(100.00, (x) -> System.out.println("金额：" + x + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    //供给型接口
    public void test8() {
        List<Integer> numberList = getNumberList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numberList) {
            System.out.println(integer);
        }
    }


    public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    //函数型接口
    public void test9() {
        String st = strHandler("的说法法大师傅   ", (str) -> str.trim());
        System.out.println(st);
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test10() {
        List<String> list = Arrays.asList("AAAA", "BB", "CC");
        List<String> strings = filterStr(list, (x) -> x.length() > 3);
        System.out.println(strings);
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> str = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                str.add(s);
            }
        }
        return str;
    }

}

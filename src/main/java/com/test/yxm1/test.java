package com.test.yxm1;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;

public class test {

    /*public static void main(String[] args) {
        System.out.println("1");
    }*/
    //public: 关键字是一种访问修饰符，代表可见性。这意味着所有人都可以看到它。
    //statis: 是关键字。如果我们将任何方法声明为静态方法，则称为静态方法。静态方法的核心优点是无需创建对象来调用静态方法。 main方法由JVM执行，因此不需要创建对象来调用main方法。这样可以节省内存。
    //void: 是方法的返回类型。这意味着它不返回任何值。
    //main: 代表程序的起点。
    //System.out.println(): 用于打印语句。在这里，System是一个类，out是PrintStream类的对象，println()是PrintStream类的方法。稍后我们将了解System.out.println语句的内部工作。

    //JVM、JRE、JDK
    //JVM是抽象机。之所以称为虚拟机，是因为它实际上并不存在。它是一个规范，提供了可以在其中执行Java字节码的运行时环境。它还可以运行那些用其他语言编写并编译为Java字节码的程序。
    //JRE是Java Runtime Environment的首字母缩写。它也被编写为Java RTE。Java运行时环境是用于开发Java应用程序的一组软件工具。它用于提供运行时环境。它是JVM的实现。它实际上存在。它包含JVM在运行时使用的一组库+其他文件。
    //JDK是Java开发工具包的缩写。Java Development Kit（JDK）是一个软件开发环境，用于开发Java应用程序和applet。它实际上存在。

    //变量
    //变量是在执行JAVA程序时保存值的容器，是在内存中分配的保留区的名称
    //变量是内存位置的名称；变量的三种类型  局部变量、实例变量、静态变量
    //局部变量是在一个方法的内部定义的变量只能在这个方法里使用局部变量不能加static
    //实例变量是在当前类中定义的一个变量可以在当前这个类中使用，并且没有加static
    //静态变量使用static修饰的实例变量为静态变量   静态变量是在程序执行前系统就会分配内存空间

    //数据类型
    //bite、short、int、long、float、double、char、boolean

    //运算符
    // 一元运算符：expr++、++expr
    // 算术运算符：+、-、*、/
    // 移位运算符：<<、>>、>>>
    // 关系运算符：>、<、<=、>=、instanceof、==、!=
    // 按位运算符：&、^、|、>&&
    // 逻辑运算符：||
    // 三元运算符：?、:
    // 赋值运算符：=、+=、-=、*=、/=、%=、&=、^=、|=、<<=、>>=、>>>=


    //关键字
    //abstract:java用来修饰抽象类的关键字 抽象类 可以提供给接口实现它可以具有抽象方法和非抽象方法
    //boolean:java用来修饰布尔的关键字值只有true和false
    //break:通常在循环中用来跳出循环
    //byte:声明一个可容纳8位数据值的变量
    //case:和switch一起用于标记
    //catch:用来捕获异常只能用在try之后
    //char:声明一个可容纳16位Unicode字符的变量
    //class:用于声明一个类
    //continue:用于跳过当前循环
    //default:用于指定switch中的默认代码块
    //do:用来声明一段循环体和while一起使用
    //double:声明一个64位浮点类型的变量
    //else:if中的备用分支
    //enum:用户定义一组固定的常量，枚举类型通常是私有的或默认的
    //extends:声明当前类的父类
    //final:声明的变量是不可变的
    //finally:在try-catch之后使用，总是执行这里的代码
    //float:声明一个32位浮点数的变量
    //for:用与启动循环
    //if:如果if后的语句块为真 则执行if里的内容
    //implements:用于实现接口
    //import:相当于是引用包的
    //instanceof:判断左边是否是右边是实例 如果是则返回true 否则false
    //int:声明一个32为的整数变量
    //interface:用于声明一个接口
    //long:声明一个可容纳64位整数的变量
    //native:指定本机代码中的方法实现
    //new:用户创建一个新的对象
    //null:表示没有引用任何内容
    //package:用于声明包含类的java


    //线程
    //Synchronized来实现线程同步，实现线程安全，适用wait使线程进入等待状态，使用notify来随机唤醒一个线程，使用notifyAll来唤醒所有等待的线程
    //ReenTrantLock也是用来线程同步的，与Synchronized的区别就是ReentrantLock是Java5引用的一个处理高并发的包简化了多线程编程的代码
    //ReenTrantLock使用await()使线程进入等待状态使用siginal()随机唤醒一个等待的线程使用siginalAll()唤醒所有线程

    /*public static void main(String[] args) throws InterruptedException {
        Thread thread = new thread();
        Thread thread1 = new thread1();
        thread1.start();
        thread.start();
    }

    static class thread extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                addTask(i+"");
            }
        }
    }
    static class thread1 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                System.out.println("获取到对象："+getTask());
            }
        }
    }

    private static final Lock lock = new ReentrantLock();
    private static  final Condition condition = lock.newCondition();
    private static  Queue<String> queue = new LinkedList<>();

    private static void addTask(String s){
        lock.lock();
        try{
            queue.add(s);
            System.out.println("数据："+s+"添加成功！");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public static String getTask(){
        lock.lock();
        try{
            while (queue.isEmpty()){
                System.out.println("对象为空，等待中...");
                condition.await();
            }
            return queue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "";
    }*/

    //ReadWriteLock读写锁，读取数据的锁和写数据的锁区分开适用于 多线程读取，一个读线程的情况  这是一个悲观锁  如果在写入数据时 正好在读 那么就需要等到读完之后再写入
    /*public static void main(String[] args) {
        Thread thread2 = new thread2();
        Thread thread1 = new thread1();
        thread1.start();
        thread2.start();
    }
    static class thread1 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                ins(i);
            }
        }
    }
    static class thread2 extends Thread{
        @Override
        public void run(){
            int[] geta = geta();
            for (int i : geta) {
                System.out.println("结果值："+i);
            }
        }
    }

    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Lock readLock = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();
    private static int[] arrays = new int[10];

    public static void ins(int c){
        writeLock.lock();
        try{
            System.out.println("加入"+c);
            arrays[c] += 1;
        }finally {
            writeLock.unlock();
        }
    }
    private static int[] geta(){
        readLock.lock();
        try{
            return Arrays.copyOf(arrays,arrays.length);
        }finally {
            readLock.unlock();
        }
    }*/

    //由于ReadWriteLock是个悲观锁，所以java8就引用了StampedLock 与ReadWriteLock的区别就是这个是乐观锁   操作更复杂一点
    //使用stampedLock.writeLock获取读锁并 使用stampedLock.unlockWrite(long num)来释放读锁
    //使用stampedLock.tryOptimistaicRead获取乐观读锁 使用visiData判断数据是否改变如果改变则使用stampedLock.readLock()获取悲观读锁 最后使用stampedLock.unlockRead()释放悲观读锁

    /*//定义一个读写锁
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double x,double y){
        //获取一个读锁
        long writeLock = stampedLock.writeLock();
        try{
            x += x;
            y += y;
        }finally {
            //释放读锁
            stampedLock.unlockWrite(writeLock);
        }
    }

    public double dis(){
        //获取一个乐观的写锁
        long l = stampedLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        if(!stampedLock.validate(l)){
            l = stampedLock.readLock();
            try{
                currentX = x;
                currentY = y;
            }finally {
                stampedLock.unlockRead(l);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }*/

}

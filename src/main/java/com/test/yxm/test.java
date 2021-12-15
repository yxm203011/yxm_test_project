package com.test.yxm;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class test {

    public static void main(String[] args) throws Exception {
        // 当前时间:
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MINUTE,-6);
        c.add(Calendar.SECOND, -60);
        c.add(Calendar.HOUR_OF_DAY,-2);
        c.add(Calendar.YEAR,-1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
    }
}

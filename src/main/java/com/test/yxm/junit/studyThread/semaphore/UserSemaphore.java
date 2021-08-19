package com.test.yxm.junit.studyThread.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class UserSemaphore {
    private final static int poolSize = 10;
    private final Semaphore userful, useless;

    private static LinkedList<Connection> pool = new LinkedList<>();

    static {
        for (int i = 0; i < poolSize; i++) {
            pool.addLast(SqlConnectionImpl.fetchConnection());
        }
    }

    public UserSemaphore() {
        this.userful = new Semaphore(10);
        this.useless = new Semaphore(0);
    }

    public void returnConnection(Connection connection) throws Exception {
        if (connection != null) {
            System.out.println("当前有" + userful.getQueueLength() + "个线程等" +
                    "待数据库链接！！" + "可用连接数：" +userful.availablePermits());
            useless.acquire();
            synchronized (pool) {
                pool.addLast(connection);
            }
            userful.release();
        }
    }

    //获取链接
    public Connection taskConnect() throws Exception {
        userful.acquire();
        Connection connection = null;
        synchronized (pool) {
            connection = pool.removeFirst();
        }
        useless.release();
        return connection;
    }

}

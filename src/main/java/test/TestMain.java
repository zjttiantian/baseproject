package test;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestMain {
    public static void main(String[] args) throws Exception {
        //ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
        ExecutorService ex= Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(5);
        Executors.newSingleThreadExecutor();
        Test t=new Test("测试");
        System.out.println(t.name);
        test(t);
        System.out.println(t.name);
    }

    static void test(Test t){
        t=new Test("哈哈");
    }
}

class Test{
    public String name;
    public Test(String name){
        this.name=name;
    }
}
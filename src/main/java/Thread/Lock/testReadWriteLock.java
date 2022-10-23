package Thread.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
    读写锁  读锁为共享锁（提高性能）  写锁为独占锁
    缺点: 容易饥饿 一直读，读的时候不能写，写的时候可以读

    写锁可以降级为读锁 (获取写 获取读 释放写)
    读不能升为写
 */
public class testReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        Map1 map1 = new Map1();

        for (int i = 1; i <=5 ; i++) {

            final int n = i;
            new Thread(()->{
                map1.put("key"+n,"value"+n);
            },i+"号写线程").start();
        }

        Thread.sleep(1000);

        for (int i = 1; i <=5 ; i++) {
            final int n = i;
            new Thread(()->{
                map1.get("key"+n);
            },i+"号读线程").start();

        }


    }
}


class Map1{

    private Map map = new HashMap();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String value)
    {
        readWriteLock.writeLock().lock();

        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+
                "  存放了key"+key+",value"+value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readWriteLock.writeLock().unlock();

    }

    public void get(String key)
    {
        readWriteLock.readLock().lock();

        System.out.println(Thread.currentThread().getName()+
                "  取到了"+key+","+ map.get(key)+"--------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        readWriteLock.readLock().unlock();

    }


}

package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
    比较Callable接口 和 Runnable接口
 */
public class testCallale {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        T1ByRunnable t1 = new T1ByRunnable();
//        new Thread(t1).start();
        /*
           无法直接通过callable创建线程,
           通过Runnable的实现类FutureTask构造
         */
        T2ByCallable t2 = new T2ByCallable();

        FutureTask futureTask1 = new FutureTask(t2);
        FutureTask futureTask2 = new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()
            +"--------");
            return 777;
        });



        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
//      获取返回结果
        System.out.println(Thread.currentThread().getName()+
                "返回结果是:"+futureTask1.get());
        System.out.println(Thread.currentThread().getName()+
                "返回结果是:"+futureTask2.get());

    }
}

class T1ByRunnable implements Runnable{

    @Override
    public void run() {

    }
}

class T2ByCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return 666;
    }
}
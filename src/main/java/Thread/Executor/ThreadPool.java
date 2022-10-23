package Thread.Executor;


import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {


        /*
             底层都是new 了一个ThreadPoolExecutor类的对象  有7个参数：
             int corePoolSize,   常驻线程数量
             int maximumPoolSize,  最大线程数量
             long keepAliveTime, TimeUnit unit, 线程存活时间和单位  （超出常驻线程数量的 那些线程 这些时间内未使用就会回收）
             BlockingQueue<Runnable> workQueue, 阻塞队列
             ThreadFactory threadFactory,       线程工厂（用来创建线程）
             RejectedExecutionHandler handler   拒绝策略（1(默认):抛异常 2.退给调用者  3.抛弃队列中等待最久的，将新的加入  4.不做任何处理不回应）


             先进常驻线程 再进阻塞队列 在进最大线程 再来的拒绝
         */
        //自定义的线程池:
        ThreadPoolExecutor threadPoolByMysel = new ThreadPoolExecutor(
                2, 5,
                1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),//默认的线程工厂
                new ThreadPoolExecutor.AbortPolicy() //默认拒绝策略
        );


        // 1池多线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        // 1池1线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        // 1池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();


        for (int i = 1; i <=14 ; i++) {

            final int a = i;
            threadPoolByMysel.execute(()->{
                System.out.println(Thread.currentThread().getName()+
                        "正在执行第"+a+"个任务...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });



//            FutureTask futureTask = new FutureTask(()->{
//                System.out.println(Thread.currentThread().getName()+
//                        "正在执行任务...");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                return 777;
//            });
//            threadPoolByMysel.execute(futureTask);
//            try {
//                System.out.println(futureTask.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }


            //     .submit() 会返回一个FutureTask对象：
//            Future future = threadPoolByMysel.submit(() -> {
//                System.out.println(Thread.currentThread().getName() +
//                        "正在执行任务...");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return 666;
//            });

            

//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }



//        threadPool1.shutdown();
//        threadPool2.shutdown();
//        threadPool3.shutdown();

        threadPoolByMysel.shutdown();



    }
}

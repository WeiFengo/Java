package JVM;

public class test01 {
    public static void main(String[] args) {
        //虚拟机试图使用的最大内存   系统内存的四分之一
        long max = Runtime.getRuntime().maxMemory();
        //jvm初始化总内存    64分之1
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();

        System.out.println("最大内存:"+max*1.0/1024/1024 +"MB");
        System.out.println("初始化内存:"+total*1.0/1024/1024 +"MB");
        System.out.println("空闲内存:"+free*1.0/1024/1024 +"MB");


        //-Xms1m -Xmx8m -XX:+PrintGCDetails

    }
}

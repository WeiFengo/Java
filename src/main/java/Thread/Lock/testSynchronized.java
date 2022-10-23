package Thread.Lock;

public class testSynchronized {
    public static void main(String[] args) {

//使用实现Runnable接口方式 实现多线程取钱  （建议使用此方式）
//        T t = new T();
//        new Thread(t).start();
//        new Thread(t).start();

        //继承Threa类方式 实现多线程卖票
//        Ticket ticket = new Ticket();
//        Ticket ticket2 = new Ticket();
//        ticket.start();
//        ticket2.start();

        System.out.println("主线程结束...");
    }

}

//取钱
class T implements Runnable{
    static boolean flag = true;
    static int money = 1000;

    public synchronized void getMoney(){

            if (money == 0) {
                flag = false;
                System.out.println("余额为0...");
                return;
            }
            money = money - 100;
            System.out.println(Thread.currentThread().getName() + "  取走100，当前余额：" + money);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    @Override
    public void run() {
        while(flag) {
            this.getMoney();
        }
    }
}

//卖票
class Ticket extends Thread{
    private int number = 100;
    public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName()+": 售出一张票,剩余："+(--number));
//            sleep(500);
        }
    }

    @Override
    public void run() {
        while(number>0)
        {
            sale();
        }
    }
}


public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        new Thread(new MyThread(ticket), "售票机A").start();
//        new Thread(new MyThread(ticket), "售票机B").start();
//        new Thread(new MyThread(ticket), "售票机C").start();
        new Thread(() ->{while (ticket.num > 0) ticket.sale();}, "售票机A").start();
        new Thread(() ->{while (ticket.num > 0) ticket.sale();}, "售票机B").start();
        new Thread(() ->{while (ticket.num > 0) ticket.sale();}, "售票机C").start();
    }
}

class Ticket{
    public int num = 10000;

    public synchronized void sale(){
        if(num > 0)
        System.out.println(Thread.currentThread() + "正在售出第：" + num-- + "张票，余票：" + num + "张");
    }
}

class MyThread implements Runnable{
    Ticket ticket;

    public MyThread(Ticket ticket) {
        this.ticket = ticket;
    }


    public void run(){
        while (ticket.num > 0)   ticket.sale();
     }

}
public class CountOperate extends Thread{
    public CountOperate(){
        System.out.println(this.getName());
        System.out.println(super.getName());
    }

    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread t1 = new Thread(countOperate);
        t1.setName("A");
        System.out.println(t1.getName());
    }
}

class NoThread implements Runnable{
    private Queue q;
    public NoThread(Queue q){
        this.q = q;
    }
    public void run(){
         while(true){
            System.out.println("get " + q.get());
            try{
                Thread.currentThread().sleep(400);
            }catch(Exception err){
            }
        }
    }
}
public class YesThread extends Thread{
    private Queue q;
    public YesThread(Queue q){
        this.q = q;
    }
    // override run() defined in Thread
    public void run(){
        int i = 0;
        while(true){
            System.out.println("put " + q.put(i++));
            try{
                sleep(300);
            }catch(Exception err){
            }
        }
    }
    public static void main(String[] argv){
        Queue q = new Queue();
        // create a new Thread
        Thread t1 = new YesThread(q);
        Thread t2 = new Thread(new NoThread(q));
        // ask thread to excute run()
        t1.start();
        t2.start();
    }
}
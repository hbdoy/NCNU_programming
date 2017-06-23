class NoThread implements Runnable{
    public void run(){
         while(true){
            System.out.println("No");
            try{
                Thread.currentThread().sleep(2000);
            }catch(Exception err){
            }
        }
    }
}
public class YesThread extends Thread{
    // override run() defined in Thread
    public void run(){
        while(true){
            System.out.println("Yes");
            try{
                sleep(3000);
            }catch(Exception err){

            }
        }
    }
    public static void main(String[] argv){
        // create a new Thread
        Thread t = new YesThread();
        // ask thread to excute run()
        t.start();
        t = new Thread(new NoThread());
        t.start();
        // main thread say hello
        while(true){
            System.out.println("Hello");
            try{
                // sleep 5 sec
                Thread.currentThread().sleep(5000);
            }catch(Exception err){}
        }
    }
}
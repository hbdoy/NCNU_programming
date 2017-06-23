public class Queue{
    private int[] data = new int[100];
    private int head; // head point to first data
    private int tail; // point to first avaible space
    private int size; // number of data in queue

    // synchronized要求執行緒需取得鎖的鑰匙才能執行,確保只有一個執行緒使用這個方法
    public synchronized int get(){
        while(size == 0){
            try{
                // wait() is defined in
                // java.lang.Object
                // the parent class of all class
                wait(); // 執行緒進入等待狀態,不會吃任何cpu資源,直到被喚醒
            }catch(Exception err){
            }
        }
        int result = data[head++];
        head = head % data.length;
        size--;
        if(size == data.length - 1){
            notifyAll(); // wake up all waiting Threads
        }
        return result;
    }
    public synchronized int put(int x){
        while(size >= data.length){
            try{
                wait();
            }catch(Exception err){}
        }
        data[tail++] = x;
        tail = tail % data.length;
        size++;
        if(size == 1){
            notifyAll();
        }
        return x;
    }
}
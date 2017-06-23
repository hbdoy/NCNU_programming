public class Queue{
    private int[] data = new data[100];
    private int head; // head point to first data
    private int tail; // point to first avaible space
    private int size; // number of data in queue
    public synchronized int get() throws Exception{
        if(size == 0){
            throw new Exception("queue is empty");
        }
        int result = data[head++];
        head = head % data.length;
        size--;
        return result;
    }
    public synchronized void put(int x) throws Exception{
        if(size >= data.length){
            throw new Exception("queue is full");
        }
        data[tail++] = x;
        tail = tail % data.length;
        size++;
    }
}
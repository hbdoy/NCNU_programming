public class Queue{
    private int[] data = new int[100];
    private int head; // head point to first data
    private int tail; // point to first avaible space
    private int size; // number of data in queue

    // synchronized�n�D������ݨ��o�ꪺ�_�ͤ~�����,�T�O�u���@�Ӱ�����ϥγo�Ӥ�k
    public synchronized int get(){
        while(size == 0){
            try{
                // wait() is defined in
                // java.lang.Object
                // the parent class of all class
                wait(); // ������i�J���ݪ��A,���|�Y����cpu�귽,����Q���
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
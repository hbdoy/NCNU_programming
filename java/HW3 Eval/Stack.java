/*
* ID: 104213046
* Author: 李禹叡
*/
public class Stack{
    //private 表示只有這個class的程式碼可以存取
    private String[] data = new String[100];
    private int top = 0; //top points to first empty slot
    public void push(String x){
        //先在當前top位置給值x,結束後在top+1
        data[top++] = x;
    }
    public String pop(){
        //top-1後再回傳
        return data[--top];
    }
    public String peek(){
        //回傳data[top-1]值,top本身不變
        return data[top-1];
    }
    public boolean isEmpty(){
        return top <= 0;
    }
}
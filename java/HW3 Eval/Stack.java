/*
* ID: 104213046
* Author: ������
*/
public class Stack{
    //private ��ܥu���o��class���{���X�i�H�s��
    private String[] data = new String[100];
    private int top = 0; //top points to first empty slot
    public void push(String x){
        //���b��etop��m����x,������btop+1
        data[top++] = x;
    }
    public String pop(){
        //top-1��A�^��
        return data[--top];
    }
    public String peek(){
        //�^��data[top-1]��,top��������
        return data[top-1];
    }
    public boolean isEmpty(){
        return top <= 0;
    }
}
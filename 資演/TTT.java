import java.util.Scanner;
/*class Main 
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        LinkList MyList = new LinkList();
        System.out.print("請輸入指令 1.插入 2.刪除 3.反轉 4.查詢長度 : ");
        while(input.hasNext())
        {
            switch(input.nextInt())
            {
                case 1 :
                System.out.print("請輸入要插入的數字 : ");
                MyList.add(input.nextInt());
                break;
                case 2 :
                System.out.print("請輸入要刪除的數字 : ");
                MyList.del(input.nextInt());
                break;
                case 3 :
                System.out.print("反轉 : ");
                MyList.rev();
                break;
                case 4 :
                System.out.println("長度為 : "+MyList.count());
                break;
            }
            System.out.print("請輸入指令 1.插入 2.刪除 3.反轉 4.查詢長度 : ");
        }

    }
}
class Node
{
    public int data;
    public Node link;
    Node(int data){this.data = data;}
}
class LinkList
{
    int count_ = 0;
    Node front;
    boolean revOp = true;
    public void add(int data)
    {
        count_++;
        Node newNode = new Node(data) , preNode = null , temp = front;
        if(front == null)//第一次插入時
        {
            front = newNode;
            print();
            return ;
        }
        if(revOp)//true為 小-->大 False為 大-->小
        for(;temp != null && newNode.data > temp.data ; preNode = temp, temp = temp.link );
        else
        for(;temp != null && newNode.data < temp.data ; preNode = temp, temp = temp.link );
        if(preNode == null)//為最前面的節點
        {
            newNode.link = front;
            front = newNode;
        }
        else//不為最前面的節點
        {
            newNode.link = preNode.link;
            preNode.link = newNode;
        }
        print();
    }
    public void del(int data)
    {

        Node temp = front;


        if(front ==null||temp.data == data )//無元素或要刪除的為第一個節點
        {
            if(front !=null )
            {
                front= front.link;
                count_--;
            }
            else System.out.println("無元素");
            print();
            return;
        }
        for(;temp.link != null && temp.link.data != data ;temp = temp.link);//尋訪
        if(temp.link != null)//有找到
        {
            temp.link =temp.link.link;
            print();
            count_--;
        }
        else
        {
            System.out.println("串列中無該元素");
        }
    }
    public void rev()
    {
        revOp =  revOp == true ? false : true; //true變false false變true
        Node a =null,b =null;
        while(front != null)//一個一個轉換鏈結
        {
            a = b;
            b = front;
            front = front.link;
            b.link = a;
            if(front == null)//當是最後個鏈結時設為front
            {
                front = b;
                break;
            }

        }
        print();
    }
    public void print()//印出串列的鏈結
    {
        Node printTemp =front;
        while(printTemp != null)
        {
            System.out.print(printTemp.data);
            printTemp = printTemp.link;
            if(printTemp != null)System.out.print(" --> ");
            else System.out.println();
        }

    }
    public int count(){return count_;}//回傳串列的長度
}*/
class TTT{
    public static void main(String[] args){
        String[] CNamePool= new String[]{"曹淑珍","陳士萱","侯淑娟","李冠禾","張佳心","馮昀妤","盧嘉惠","洪淑萍","朱卉一","楊茹俐","柳子晴","陳詠晴","蕭宜蓁","江品妤","黃子涵","趙品妍","陳詩涵","張思妤","孫品睿","李宸睿"};
        System.out.println(CNamePool[3]);
    }
}
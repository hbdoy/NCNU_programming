import java.util.Scanner;
/*class Main 
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        LinkList MyList = new LinkList();
        System.out.print("�п�J���O 1.���J 2.�R�� 3.���� 4.�d�ߪ��� : ");
        while(input.hasNext())
        {
            switch(input.nextInt())
            {
                case 1 :
                System.out.print("�п�J�n���J���Ʀr : ");
                MyList.add(input.nextInt());
                break;
                case 2 :
                System.out.print("�п�J�n�R�����Ʀr : ");
                MyList.del(input.nextInt());
                break;
                case 3 :
                System.out.print("���� : ");
                MyList.rev();
                break;
                case 4 :
                System.out.println("���׬� : "+MyList.count());
                break;
            }
            System.out.print("�п�J���O 1.���J 2.�R�� 3.���� 4.�d�ߪ��� : ");
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
        if(front == null)//�Ĥ@�����J��
        {
            front = newNode;
            print();
            return ;
        }
        if(revOp)//true�� �p-->�j False�� �j-->�p
        for(;temp != null && newNode.data > temp.data ; preNode = temp, temp = temp.link );
        else
        for(;temp != null && newNode.data < temp.data ; preNode = temp, temp = temp.link );
        if(preNode == null)//���̫e�����`�I
        {
            newNode.link = front;
            front = newNode;
        }
        else//�����̫e�����`�I
        {
            newNode.link = preNode.link;
            preNode.link = newNode;
        }
        print();
    }
    public void del(int data)
    {

        Node temp = front;


        if(front ==null||temp.data == data )//�L�����έn�R�������Ĥ@�Ӹ`�I
        {
            if(front !=null )
            {
                front= front.link;
                count_--;
            }
            else System.out.println("�L����");
            print();
            return;
        }
        for(;temp.link != null && temp.link.data != data ;temp = temp.link);//�M�X
        if(temp.link != null)//�����
        {
            temp.link =temp.link.link;
            print();
            count_--;
        }
        else
        {
            System.out.println("��C���L�Ӥ���");
        }
    }
    public void rev()
    {
        revOp =  revOp == true ? false : true; //true��false false��true
        Node a =null,b =null;
        while(front != null)//�@�Ӥ@���ഫ�쵲
        {
            a = b;
            b = front;
            front = front.link;
            b.link = a;
            if(front == null)//��O�̫���쵲�ɳ]��front
            {
                front = b;
                break;
            }

        }
        print();
    }
    public void print()//�L�X��C���쵲
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
    public int count(){return count_;}//�^�Ǧ�C������
}*/
class TTT{
    public static void main(String[] args){
        String[] CNamePool= new String[]{"��Q��","���h��","�J�Q�S","���a��","�i�Τ�","������","�c�Ŵf","�x�Q��","���c�@","�����W","�h�l��","������","���y�","���~��","���l�[","���~��","���ֲ[","�i�䧱","�]�~��","���f��"};
        System.out.println(CNamePool[3]);
    }
}
import java.util.*;
class LSNode
{
    public String name;
    public int age;
    public LSNode next;
    LSNode(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
}
public class HW8
{
    public static void main(String[] args)
    {
        //25 English names
        String[] NamePool = new String[] {"James","David","Christopher","George","Ronald","John","Richard","Daniel","Kenneth", "Anthony","Robert","Charles","Paul","Steven","Kevin","Michael", "Joseph","Mark","Edward","Jason", "William",    "Thomas", "Donald","Brian","Jeff"};
        String[] CNamePool= new String[]{"��Q��","���h��","�J�Q�S","���a��","�i�Τ�","������","�c�Ŵf","�x�Q��","���c�@","�����W","�h�l��","������","���y�","���~��","���l�[","���~��","���ֲ[","�i�䧱","�]�~��","���f��"};

        Random rand = new Random();
        LSNode Head01 /*= new LSNode()*/; Head01 = null;
        LSNode Tail01 /*= new LSNode()*/;   Tail01 = null;
        int Length01 = 0;

        LSNode ptr = new LSNode();

        for (int i = 1; i <= 20; i++)
        {
            LSNode node = new LSNode(NamePool[ran.nextInt(25)],(ran.nextInt(41)+20));
            node.LS_Add(node, /*ref*/ Head01, /*ref*/ Tail01,/*ref*/ Length01); //�[�� List �̫᭱
        }
        ptr.ShowLS(Head01);//�L�XList �Ҧ������e

        System.out.println("\nWe are going to remove the last item ...");
        boolean flag = ptr.LS_Remove(/*ref*/ Head01, /*ref*/ Tail01, /*ref*/ Length01);//�R��List�̫᭱�@��
        ptr.ShowLS(Head01);

        System.out.println("\nWe are going to remove the first item ...");
        flag = ptr.LS_RemoveHead(/*ref*/ Head01, /*ref*/  Tail01, /*ref*/ Length01);//�R��List�̫e���@��
        ptr.ShowLS(Head01);

        System.out.println("\nWe are going to remove the item in between ...");
        flag = ptr.LS_RemoveAt(/*ref*/ Head01, /*ref*/  Tail01, /*ref*/ Length01, 5);//�R��List�Y�@��
        ptr.ShowLS(Head01);

        System.out.println("\nWe are going to add one item in between ...");
        LSNode aNode = new LSNode("���", 22);
        flag = ptr.LS_InsertAt(aNode,/*ref*/ Head01, /*ref*/  Tail01, /*ref*/ Length01, 5);//�[�J�Y�@����List
        ptr.ShowLS(Head01);

        //reverse a linked list
        System.out.println("\nWe are going to reverse a linked list ...");
        ptr.LS_Reverse(/*ref*/ Head01, /*ref*/ Tail01);
        ptr.ShowLS(Head01);

        LSNode Head02 = new LSNode(); Head02 = null;
        LSNode Tail02 = new LSNode(); Tail02 = null;
        int Length02 = 0;

        for (int i = 1; i <= 20; i++)
        {
            LSNode node = new LSNode(CNamePool[ran.nextInt(20)],(rand.Next(71)+10));
            node.LS_Add(node, /*ref*/ Head02, /*ref*/ Tail02, /*ref*/ Length02); //�[�� List �̫᭱
        }
        ptr.ShowLS(Head02);//�L�XList �Ҧ������e

        //merge the two linked list
        Tail01.Next = Head02;
        Tail01 = Tail02;
        Length01 += Length02;
        ptr.ShowLS(Head01);//�L�XList �Ҧ������e


        System.out.println("Press any key to continue ...");
        Console.ReadKey(true);
    }

/*class LSNode
{
    public String name;
    public int age;
    public LSNode next;
    LSNode(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
    public LSNode()
    {
        name = "";
        age = 0;
        Next = null;
    }
    public LSNode(String str, int ag)
    {
        name = str;
        age = ag;
        Next = null;
    }*/
     //����Linked List ������
    public void LS_CountLength(LSNode Head, /*ref*/ int Length)
    {
         LSNode ptr = new LSNode();
         ptr = Head;

         int count = 0;
         while (ptr != null)
         {
             count++;
             ptr = ptr.Next;
         }
         Length = count;
     }
     //�[�� Linked List �̫e��
     public void LS_AddToHead(LSNode node, /*ref*/ LSNode Head, /*ref*/ LSNode Tail, /*ref*/ int Length)
     {
         if ((Head == null) && (Tail == null))
         {
             Head =  node;
             Tail = node;
         }
         else
         {
             node.Next = Head;
             Head = node;
         }
         Length++;
     }
     //�[��̫�
     public void LS_Add(LSNode node, /*ref*/ LSNode Head, /*ref*/ LSNode Tail, /*ref*/ int Length)
     {
         if ((Head == null) && (Tail ==null))
         {
             Head = node;
             Tail = node;
         }
         else
         {
             Tail.Next = node;
             Tail = node;
         }
         Length++;
     }
     //�R�h�Ĥ@��
     public boolean LS_RemoveHead(/*ref*/ LSNode Head, /*ref*/ LSNode Tail, /*ref*/ int Lenghth)
     {
         if (Head == null)
             return false;
         else
         {
             LSNode ptr;
             ptr = Head;
             Head = Head.Next;
             ptr = null;
             Lenghth--;
             return true;
         }
     }
     //�[�b location ��m����
     public boolean LS_InsertAt(LSNode node, /*ref*/ LSNode Head, /*ref*/ LSNode Tail, /*ref*/ int Length, int location)
     {
        int i = 0;
        if ((location > Length) || (location < 0))//Index �O�q0 �}�l
            return false;
        else
        {
            i = 1;
            LSNode ptr1 = new LSNode();
            LSNode ptr2 = new LSNode();
            ptr1 = Head;
            while (i != location)
            {
                i++;
                ptr2 = ptr1;
                ptr1 = ptr1.Next;
            }
            ptr2.Next = node;
            node.Next= ptr1;
            Length++;
            return true;
        }
     }
     //remove the item in the location position
     public boolean LS_RemoveAt(/*ref*/ LSNode Head, /*ref*/ LSNode Tail, /*ref*/ int Length, int location)
     {
         int i = 0;
         if ((location >= Length) || (location < 0))//Index �O�q0 �}�l
             return false;
         else
         {
             if (location == 0)
             {
                 LS_RemoveHead(/*ref*/ Head, /*ref*/  Tail, /*ref*/ Length);
                 return true;
             }
             else
                 if (location == Length - 1)
                 {
                     LS_Remove(/*ref*/ Head, /*ref*/  Tail, /*ref*/ Length);//LS_Remove �N�O remove �̫�@��
                     return true;
                 }
                 else
                 {
                     i = 1;
                     LSNode ptr1= new LSNode();
                     LSNode ptr2= new LSNode();
                     ptr1 = Head;
                     while (i != location)
                     {
                         i++;
                         ptr2 = ptr1;
                         ptr1 = ptr1.Next;
                     }
                     ptr2.Next = ptr1.Next;

                     ptr1 = null;
                     Length--;
                     return true;
                 }
         }
     }
     //default remove the last item
     public boolean LS_Remove(/*ref*/ LSNode Head, /*ref*/ LSNode Tail, /*ref*/ int Lenghth)
     {
         if ((Head == null) && (Tail == null)) //nothing to remove
         {
             return false;
         }
         else
         {
             LSNode ptr01, ptr02;
             ptr02=Head;
             ptr01 = Head.Next;
             while (ptr01 != Tail)
             {
                 ptr02 = ptr01;
                 ptr01 = ptr01.Next;
             }
             if (ptr01 == Tail)
             {
                 Tail = ptr02;
                 ptr02.Next = null;
                 Lenghth--;
             }
             return true;
         }
     }
     public void LS_Reverse(/*ref*/ LSNode Head, /*ref*/ LSNode Tail)
     {
         LSNode forward = new LSNode();
         LSNode current = new LSNode();
         LSNode prev = new LSNode();
         if ((Head == null) || (Tail == null))
             return;
         else
         {
             forward = Head; current = null;
             while (forward != null)
             {
                 prev = current;
                 current = forward;
                 forward = forward.Next;
                 current.Next = prev;
             }
             Head = current;

             while (current != null)
             {
                 Tail = current;
                 current = current.Next;
             }
         }
     }
     public void ShowLS(LSNode Head)
     {
         LSNode ptr = new LSNode();
         int i=0;
         ptr = Head;
         while (ptr != null)
         {
             //System.out.println("��{0:d2}��, �j�W = {1}, �~�� ={2} ",++i, ptr.name, ptr.age);
             ptr = ptr.Next;
         }
         System.out.println("......\n");
     }
}


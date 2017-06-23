using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ReverseSingleLinkedListDemo
{
    class Program
    {
        public static void ShowList(LNode ptr)
        {
            /*
             Please fill the code segments
             */
            int i = 0;
            while (ptr != null)
            {
                Console.WriteLine("第{0}項={1}",i+1,ptr.data);
                ptr=ptr.next;
            }
            Console.WriteLine(); 
        }
        public class LNode
        {
            public int data;
            public LNode next;
  
            public LNode()//constructor
            {
                data = 0;
                next = null;
            }
            public LNode(int a)//constructor
            {
                data = a;
                next = null; 
            }
        }
        static void Main(string[] args)
        {
            LNode head = new LNode(); 
            LNode a = new LNode(1);
            LNode b = new LNode(2);
            LNode c = new LNode(3);

            a.next = b;    b.next = c;

            head = a;
            ShowList(head);
         
            LNode current = new LNode();
            LNode prev = new LNode();
            LNode forward = new LNode();

            //Lnode current, prev, forward; 

            /*
              Please fill the code segments
             請寫反轉的程式
              */ 
            forward = head;
            current = null;
            
            while(forward != null){
                prev = current;
                current = forward;
                forward = forward.next;
                current.next = prev;
            }
            head = current;
            
            ShowList(head);

            GC.Collect();

            Console.WriteLine("Press any key to continue ...");
            Console.ReadKey(true);
        }
    }
}

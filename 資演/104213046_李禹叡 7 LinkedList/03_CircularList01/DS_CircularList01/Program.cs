using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DS_CircularList01
{
    class Program
    {
        public static void PrintCL(CircularList01 head, CircularList01 tail)
        {
            /*
             同學補程式碼
             */
            int i = 0;
            CircularList01 ptr = head;
            Console.WriteLine("{0} item is {1}", ++i, ptr.data);
            ptr = ptr.next;
            while (ptr != head) 
            {
                Console.WriteLine("{0} item is {1}", ++i, ptr.data);
                ptr = ptr.next;
            }
            Console.WriteLine("End of the circular list printing.........");
        }
        public static void AddtoCircularListTail(CircularList01 head, ref CircularList01 tail, CircularList01 cnode)
        {
            /*
            同學補程式碼
            */
            tail.next = cnode;
            cnode.next = head;
            tail = cnode;
        }
        public static void AddtoCircularListHead(ref CircularList01 head, CircularList01 tail, CircularList01 cnode)
        {
            /*
            同學補程式碼
            */
            cnode.next = head;
            head = cnode;
            tail.next = head;
        }
        public class CircularList01
        {
            public int data; 
            public CircularList01 next;
            public CircularList01()
            {
                data = 0;
                next = null; 
            }
            public CircularList01(int value)
            {
                data = value;
                next = null;
            }
        }
        static void Main(string[] args)
        {
            CircularList01 cnode = new CircularList01();
            CircularList01 head = new CircularList01();
            CircularList01 tail = new CircularList01();

            cnode.data = 1;

            head = tail = cnode;
            cnode.next = head;

            PrintCL(head, tail); 
            for (int i = 2; i <= 5; i++)
            {
                CircularList01 cnode01 = new CircularList01(i);
                AddtoCircularListTail(head, ref tail, cnode01); 
            }
            PrintCL(head, tail);

            for (int i = 6; i <= 10; i++)
            {
                CircularList01 cnode02 = new CircularList01(i);
                AddtoCircularListHead(ref head, tail, cnode02);
            }
            PrintCL(head, tail);

            Console.WriteLine("Press any key to continue ...");
            Console.ReadKey(true);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QueueArray
{
    class Program
    {
        static int front = 0;
        static int rear = 0;
        static int MaxSize = 5;
        static int[] MyQArray = new int[MaxSize];

        public static bool IsQFull()
        {
            if (rear == MaxSize)
                return true;
            else
                return false; 
        }
        public static bool IsQEmpty()
        {
            if (rear == front)
                return true;
            else
                return false;
        }
        public static void EnQueue(int var)
        {
            if (!IsQFull())
            {
                MyQArray[rear] = var;
                rear++;
            }
            else
            {
                Console.WriteLine("The Queue is full, can not be enqueued ....\n");
            }
        }
        public static void Dequeue()
        {
            int var;
            if (!IsQEmpty())
            {
                var = MyQArray[front];
                front++;
                Console.WriteLine("The element {0} is removed from the  queue ....", var);
            }
            else
                Console.WriteLine("The  queue is empty, can not be dequeued....");
        }
        public static void ShowQueue()
        {
            Console.WriteLine("--------The content of the queue .......");
            for (int i = front; i < rear; i++)
                Console.Write(" {0}", MyQArray[i]);
            Console.WriteLine(); 
        }
        static void Main(string[] args)
        {
            EnQueue(9); EnQueue(19); ShowQueue();
            Dequeue(); ShowQueue();
            EnQueue(89); EnQueue(59); ShowQueue();
            EnQueue(29); Dequeue(); EnQueue(-9); EnQueue(87);
            ShowQueue();

            Console.WriteLine("Press any key to continue ....\n");
            Console.ReadKey(true); 
        }
    }
}







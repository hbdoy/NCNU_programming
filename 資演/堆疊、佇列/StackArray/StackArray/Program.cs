using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace StackArray
{
    class Program
    {
        struct Personal
        {
            public string name;
            public int score;
        };
        static int max_size = 10;
        static int top = 0;
        static string[] MyStack = new string[max_size];
        static Personal[] MySecondStack = new Personal[max_size];

        public static bool IsEmpty()
        {
            if (top == 0)
                return true;
            else
                return false;
        }
        public static string pop()
        {
            if (!IsEmpty())
            {
                return MyStack[--top]; 
            }
            else
            {
                Console.WriteLine("Stack is empty, can not perform pop operation ....\n");
                return null;
            }
        }
        public static bool IsFull()
        {
            if (top == max_size)
                return true;
            else
                return false;
        }

        public static void push(string obj)
        {
            if (!IsFull())
            {
                MyStack[top] = obj; 
                top++;
            }
            else
                Console.WriteLine("Stack is full, can not push element to the stack ....\n");              
        }
 
        static void Main(string[] args)
        {
            string [] allname = new string [] {"John wu", "Mary wang"};
 
            push("John  Wu");
            push("Mary Wang");
            push("Peter Lee");

            Console.WriteLine("Perform pop operation, the element is:{0}", pop());
            push("Jennifer Chen");

            while (!IsEmpty())
                Console.WriteLine("Perform pop operation, the element is:{0}", pop());
           
            Console.WriteLine("Press any key to continue ....");
            Console.ReadKey(true);
        }
    }
}







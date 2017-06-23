using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace StackAndQueue
{
    class Program
    {
        public struct Personal
        {
            public  string name;
            public  int score;
        };

        static int max_size = 10;
        static int top = 0;
        static Personal[] MyStack = new Personal[max_size];

        public static bool IsSEmpty()
        {
            if (top == 0)
                return true;
            else
                return false;
        }
        public static Personal pop()
        {
            if (!IsSEmpty())
            {
                top--; 
                return MyStack[top];
            }
            else
            {
                Console.WriteLine("Stack is empty, can not perform pop operation ....\n");
                Personal nullobj = new Personal(); 
                nullobj.name = "unknown"; 
                nullobj.score = -1;

                return nullobj;
            }
        }
        public static bool IsSFull()
        {
            if (top == max_size)
                return true;
            else
                return false;
        }

        public static void push(Personal obj)
        {
            if (!IsSFull())
            {
                MyStack[top] = obj;
                top++;
            }
            else
                Console.WriteLine("Stack is full, can not push element to the stack ....\n");
        }
        public static void ShowAllStack()
        {
            Console.WriteLine("\n\n-------印出 stack 所有的內容 ----");
            if (!IsSEmpty())
            {
                Console.WriteLine("目前有幾項:{0}", top );
                for (int i = top - 1; i >= 0; i--)
                    Console.WriteLine("{0}\t\t{1}\t\t{2}", i+1, MyStack[i].name, MyStack[i].score);
            }
            else
                Console.WriteLine("\n-------目前stack 無內容 ----\n");
        }
 
        static void Main(string[] args)
        {
            string [] allname = new string [] {"王惠裕","呂崇珮","支淑惠","陳旺燦","楊台芝","呂慧萍","黃姿啟","王俊緯","廖郁婷","張怡慧"};
            Random ran = new Random((int)DateTime.Now.Ticks & 0x0000FFFF);
            int number = 0; 

            for (int i = 0; i < 30; i++)
            {
                Console.WriteLine("\n\n***********第{0}次測試********", i + 1);
                number = ran.Next(1, 11);
                if (number % 2 == 0) //偶數
                {
                    Console.WriteLine("\n n={0}, 是偶數，執行 push 動作 ##########",number);
                    Personal t1;
                    t1.name = allname[number - 1];
                    t1.score = ran.Next(1, 101);
                    Console.WriteLine("以下資料 push 到 stack ......"); 
                    Console.WriteLine("第{0}次\t\t{1}\t\t{2}", i+1, t1.name, t1.score);
                    push(t1);
                }
                else
                {
                    Console.WriteLine("\n n={0}, 是奇數，執行 pop 動作 @@@@@@@", number);
                    if (!IsSEmpty())
                    {
                        Console.WriteLine("以下資料 pop 出 stack ......");
                        Personal t2 = pop();
                        Console.WriteLine("第{0}次\t\t{1}\t\t{2}", i + 1, t2.name, t2.score);
                    }
                 }
                //印出所有的資料
                ShowAllStack(); 
            }
          
            Console.WriteLine("\nPress any key to continue .....");
            Console.ReadKey(true); 
        }
    }
}

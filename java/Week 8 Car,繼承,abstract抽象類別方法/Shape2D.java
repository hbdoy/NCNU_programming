/*
* ID: 104213046
* Author: ������
*/
import java.util.Scanner;
abstract class Shape{
    String id;
    // ��abstract��function�@�w�n�ק�~���~�ӥL
    public abstract double length();
    public abstract double area();
    // �L�X�ϫ����P��,���n
    public void print(){
        System.out.println(id + " length: " + this.length() + " area: " + this.area());
    }
}
// Circle Square Triangle Rectangle���O�~�ө�Shape
// �éw�q�U�ۤ�length,area function
class Circle extends Shape{
    int radius;
    public Circle(String id, int radius){
        this.id = id;
        this.radius = radius;
    }
    //override
    public double length(){
        return 3.14 * 2 * radius;
    }
    public double area(){
        return radius * radius * 3.14;
    }
}
class Square extends Shape{
    int side;
    public Square(String id, int side){
        this.id = id;
        this.side = side;
    }
    public double length(){
        return 4 * side;
    }
    public double area(){
        return side * side;
    }
}
class Triangle extends Shape{
    int side;
    public Triangle(String id, int side){
        this.id = id;
        this.side = side;
    }
    public double length(){
        return 3 * side;
    }
    public double area(){
        return Math.sqrt(3) * side * side / 4;
    }
}
class Rectangle extends Shape{
    int width, length;
    public Rectangle(String id, int width, int length){
        this.id = id;
        this.width = width;
        this.length = length;
    }
    public double length(){
        return 2 * (width + length);
    }
    public double area(){
        return width * length;
    }
}

public class Shape2D{
    // �p���`�P��
    public static double sumOfLength(Shape[] l, int num){
        double sum = 0;
        for(int i = 0; i < num; i++){
            sum += l[i].length();
        }
        return sum;
    }
    // �p���`���n
    public static double sumOfArea(Shape[] l, int num){
        double sum = 0;
        for(int i = 0; i < num; i++){
            sum += l[i].area();
        }
        return sum;
    }
    public static void main(String[] argc){
        Shape[] l = new Shape[100];
        int num = 0;
        Scanner input = new Scanner(System.in);
        // ex: circle A 5
        while(true){
            String command = input.next();
            if(command.equals("circle")){
                l[num++] = new Circle(input.next(), input.nextInt());
            }else if(command.equals("square")){
                l[num++] = new Square(input.next(), input.nextInt());
            }else if(command.equals("tri")){
                l[num++] = new Triangle(input.next(), input.nextInt());
            }else if(command.equals("rect")){
                l[num++] = new Rectangle(input.next(), input.nextInt(), input.nextInt());
            }else if(command.equals("end")){
                break;
            }
        }
        // �L�X�U�ۤ�length,area
        for(int i = 0; i < num; i++){
            l[i].print();
        }
        // �L�X�`length,area
        System.out.println("sum of length:" + sumOfLength(l, num));
        System.out.println("sum of area:" + sumOfArea(l, num));
    }
}
/*
* ID: 104213046
* Author: §õ¬êèû
*/
import java.util.Scanner;
import java.lang.Math.*;
public class Car{
    String id;
    double x, y;
    // The coordinate of car on x,y axis
    public Car(String id, double x, double y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
    // Move car on x,y axis
    public void east(double x){
        this.x += x;
    }
    public void west(double x){
        this.x -= x;
    }
    public void north(double y){
        this.y += y;
    }
    public void south(double y){
        this.y -= y;
    }
    // Print the coordinate of car
    public void print(){
        System.out.println(id + " " + x + " " + y);
    }
    // Show the distance of two cars
    public static void showDis(Car[] allCars, int numCars){
        int i,j;
        // Calculate the distance of incoming two coordinates
        for(i = 0; i < numCars; i++){
            for(j = i+1; j < numCars; j++){
                if(allCars[i] != null && allCars[j] != null){
                    double ans_x = Math.pow(allCars[i].x - allCars[j].x,2);
                    double ans_y = Math.pow(allCars[i].y - allCars[j].y,2);
                    double ans_final = Math.sqrt(ans_x + ans_y);
                    System.out.println(allCars[i].id+" to "+allCars[j].id+" "+ans_final);
                }
            }
        }
    }
    // Print the straight line equation of two cars
    public static void line(Car[] allCars, int i, int j){
        double m = ((allCars[j].y - allCars[i].y) / (allCars[j].x - allCars[i].x));
        if((allCars[j].x - allCars[i].x) == 0){
            System.out.println("x = " + allCars[i].x);
        }else if(m == 0){
            System.out.println("y = " + (allCars[i].y - m * allCars[i].x));
        }else if(m != 0){
            System.out.println("y = " + m + " * x" + " + " + (allCars[i].y - m * allCars[i].x));
        }
    }

    public static void main(String[] argc){
        Car[] allCars = new Car[1000];
        int numCars = 0;
        Scanner input = new Scanner(System.in);
        String command;
        // ex: new A 10 5 , new B -3 9
        // east A 8 , north B -9
        // line A B , destroy A
        while(true){
            command = input.next();
            if(command.equals("new")){
                allCars[numCars++] = new Car(input.next(),input.nextInt(),input.nextInt());
            }else if(command.equals("end")){
                break;
            }else if(command.equals("destroy")){
                // let the point we will destroy be null
                int i;
                String id = input.next();
                for(i = 0; i < numCars; i++){
                    if(allCars[i].id.equals(id)){
                        break;
                    }
                }
                allCars[i] = null;
            }else if(command.equals("line")){
                int i=0,j=0,tmp=1;
                String id1 = input.next();
                String id2 = input.next();
                // find the index of two points that we specify
                for(i = 0; i < numCars; i++){
                    for(j = 0; j < numCars; j++){
                        if(allCars[i] != null && allCars[j] != null && allCars[i].id.equals(id1) && allCars[j].id.equals(id2)){
                            tmp = 0;
                            break;
                        }
                    }
                    if(tmp == 0){
                        break;
                    }
                }
                line(allCars,i,j);
            }else{
                int i;
                String id = input.next();
                int dis = input.nextInt();
                for(i = 0; i < numCars; i++){
                    if(allCars[i].id.equals(id)){
                        break;
                    }
                }
                // Move car on x,y axis
                if(command.equals("east")){
                    allCars[i].east(dis);
                }else if(command.equals("west")){
                    allCars[i].west(dis);
                }else if(command.equals("north")){
                    allCars[i].north(dis);
                }else if(command.equals("south")){
                    allCars[i].south(dis);
                }
            }
        }
        for(int i = 0; i < numCars; i++){
            if(allCars[i] != null){
                allCars[i].print();
            }
        }
        showDis(allCars, numCars);
    }
}
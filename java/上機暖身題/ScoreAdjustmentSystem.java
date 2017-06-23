/*
* ID: 104213046
* Author: 李禹叡
*/
import java.util.Scanner;

class Student {
    private String id;
    private double score;

    public Student(String id, double score) {
        this.id = id;
        this.score = score;
    }
    public String getId(){
        return id;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double newScore){
        score = newScore;
    }
}

public class ScoreAdjustmentSystem{
    public static void showDetail(Student[] allStudents, int n){
        int i;
        double sum = 0 , average = 0;
        for(i = 0; i < n; i++){
            sum += allStudents[i].getScore();
            average = sum / n;
        }
        System.out.println("Class Average: " + average);
        System.out.println("flunked:");
        for(i = 0; i < n; i++){
            if(allStudents[i].getScore() < 60){
                System.out.println(allStudents[i].getId() + ": " + allStudents[i].getScore());
            }
        }
    }
    public static void main(String[] argc){
        Scanner input = new Scanner(System.in);
        int i;
        String command;
        int n = input.nextInt();
        Student[] allStudents = new Student[n];
        for(i = 0; i < n; i++){
            allStudents[i] = new Student(input.next(), input.nextDouble());
        }
        showDetail(allStudents, n);
        while(true){
            command = input.next();
            if(command.equals("全體")){
                double add = input.nextDouble();
                for(i = 0; i < n; i++){
                    double tmp = allStudents[i].getScore();
                    tmp += add;
                    if(tmp > 100){
                        tmp = 100;
                    }
                    allStudents[i].setScore(tmp);
                }
                showDetail(allStudents, n);
            }else if(command.equals("線性")){
                double coe = input.nextDouble();
                double con = input.nextDouble();
                for(i = 0; i < n; i++){
                    double tmp = allStudents[i].getScore();
                    tmp = tmp * coe + con;
                    if(tmp > 100){
                        tmp = 100;
                    }
                    allStudents[i].setScore(tmp);
                }
                showDetail(allStudents, n);
            }else if(command.equals("根號")){
                for(i = 0; i < n; i++){
                    double tmp = allStudents[i].getScore();
                    tmp = Math.sqrt(tmp) * 10;
                    if(tmp > 100){
                        tmp = 100;
                    }
                    allStudents[i].setScore(tmp);
                }
                showDetail(allStudents, n);
            }else if(command.equals("end")){
                break;
            }
        }
    }
}
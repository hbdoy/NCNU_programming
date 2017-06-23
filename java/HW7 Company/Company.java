/*
* ID: 104213046
* Author: 李禹叡
*/

import java.util.Scanner;

// 員工的資本資料: 姓名,性別,本薪,加班時間,加班費
class EmployeeDefault {
    String name;
    String sex;
    double salary;
    double overtimeMoney;
    double overtimeHours;

    public EmployeeDefault(String name, String sex, double salary) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        overtimeMoney = 0;
        overtimeHours = 0;
    }

    // 計算總月薪
    public double getMonthMoney() {
        return salary + overtimeMoney;
    }

    // 計算加班費
    public double setOvertimeMoney(double hours) {
        overtimeHours = hours;
        overtimeMoney = (salary / 240) * 1.5 * hours;
        return overtimeMoney;
    }
}

// 主管多出午餐津貼,職務加給
class ChargeDefault extends EmployeeDefault {
    double lunchAllowance;
    double duties;

    public ChargeDefault(String name, String sex, double salary) {
        super(name, sex, salary);
    }

    // 總月薪除了原先底薪與加班費再加上津貼
    public double getMonthMoney() {
        return super.getMonthMoney() + lunchAllowance + duties;
    }
}

// 普通員工
class Employee extends EmployeeDefault {
    public Employee(String name, String sex, double salary) {
        super(name, sex, salary);
    }
}

// 一級主管額外有交通津貼,與其職務加給
class FirstCharge extends ChargeDefault {
    double traffic = 2000;

    public FirstCharge(String name, String sex, double salary) {
        super(name, sex, salary);
        duties = 5000;
        lunchAllowance = 1800;
    }

    // 總月薪額外加上交通津貼
    public double getMonthMoney() {
        return super.getMonthMoney() + traffic;
    }
}

// 二級主管,沒有交通津貼
class SecondCharge extends ChargeDefault {
    public SecondCharge(String name, String sex, double salary) {
        super(name, sex, salary);
        duties = 3000;
        lunchAllowance = 1800;
    }
}

public class Company {
    // 搜尋指定姓名在陣列中的索引
    public static int searchIndexByName(EmployeeDefault[] allPeople, String searchName, int numOfPeople) {
        int i;
        for (i = 0; i < numOfPeople; i++) {
            if (allPeople[i].name.equals(searchName)) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] argc) {
        EmployeeDefault[] allPeople = new EmployeeDefault[1000];
        int numOfPeople = 0;
        Scanner input = new Scanner(System.in);
        String command;
        // 建構員工資料,輸入print時跳出迴圈
        while (!(command = input.next()).equals("print")) {
            if (command.equals("normal")) {
                allPeople[numOfPeople++] = new Employee(input.next(), input.next(), input.nextDouble());
            } else if (command.equals("first")) {
                allPeople[numOfPeople++] = new FirstCharge(input.next(), input.next(), input.nextDouble());
            } else if (command.equals("second")) {
                allPeople[numOfPeople++] = new SecondCharge(input.next(), input.next(), input.nextDouble());
            } else if (command.equals("overtime")) {
                // 設定指定職員之加班時數與加班費
                String searchName = input.next();
                double hours = input.nextDouble();
                int index = searchIndexByName(allPeople, searchName, numOfPeople);
                allPeople[index].setOvertimeMoney(hours);
            }
        }
        // 印出員工資訊:姓名,性別,月薪,加班時數
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println(allPeople[i].name + " " + allPeople[i].sex + " " + allPeople[i].getMonthMoney()
                    + " hours: " + allPeople[i].overtimeHours);
        }
    }
}
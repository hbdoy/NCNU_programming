/*
* ID: 104213046
* Author: ������
*/

import java.util.Scanner;

// ���u���ꥻ���: �m�W,�ʧO,���~,�[�Z�ɶ�,�[�Z�O
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

    // �p���`���~
    public double getMonthMoney() {
        return salary + overtimeMoney;
    }

    // �p��[�Z�O
    public double setOvertimeMoney(double hours) {
        overtimeHours = hours;
        overtimeMoney = (salary / 240) * 1.5 * hours;
        return overtimeMoney;
    }
}

// �D�ަh�X���\�z�K,¾�ȥ[��
class ChargeDefault extends EmployeeDefault {
    double lunchAllowance;
    double duties;

    public ChargeDefault(String name, String sex, double salary) {
        super(name, sex, salary);
    }

    // �`���~���F������~�P�[�Z�O�A�[�W�z�K
    public double getMonthMoney() {
        return super.getMonthMoney() + lunchAllowance + duties;
    }
}

// ���q���u
class Employee extends EmployeeDefault {
    public Employee(String name, String sex, double salary) {
        super(name, sex, salary);
    }
}

// �@�ťD���B�~����q�z�K,�P��¾�ȥ[��
class FirstCharge extends ChargeDefault {
    double traffic = 2000;

    public FirstCharge(String name, String sex, double salary) {
        super(name, sex, salary);
        duties = 5000;
        lunchAllowance = 1800;
    }

    // �`���~�B�~�[�W��q�z�K
    public double getMonthMoney() {
        return super.getMonthMoney() + traffic;
    }
}

// �G�ťD��,�S����q�z�K
class SecondCharge extends ChargeDefault {
    public SecondCharge(String name, String sex, double salary) {
        super(name, sex, salary);
        duties = 3000;
        lunchAllowance = 1800;
    }
}

public class Company {
    // �j�M���w�m�W�b�}�C��������
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
        // �غc���u���,��Jprint�ɸ��X�j��
        while (!(command = input.next()).equals("print")) {
            if (command.equals("normal")) {
                allPeople[numOfPeople++] = new Employee(input.next(), input.next(), input.nextDouble());
            } else if (command.equals("first")) {
                allPeople[numOfPeople++] = new FirstCharge(input.next(), input.next(), input.nextDouble());
            } else if (command.equals("second")) {
                allPeople[numOfPeople++] = new SecondCharge(input.next(), input.next(), input.nextDouble());
            } else if (command.equals("overtime")) {
                // �]�w���w¾�����[�Z�ɼƻP�[�Z�O
                String searchName = input.next();
                double hours = input.nextDouble();
                int index = searchIndexByName(allPeople, searchName, numOfPeople);
                allPeople[index].setOvertimeMoney(hours);
            }
        }
        // �L�X���u��T:�m�W,�ʧO,���~,�[�Z�ɼ�
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println(allPeople[i].name + " " + allPeople[i].sex + " " + allPeople[i].getMonthMoney()
                    + " hours: " + allPeople[i].overtimeHours);
        }
    }
}
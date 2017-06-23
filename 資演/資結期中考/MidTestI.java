import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;  
class Personal {
    public String name;
    public int math;
    public int prog;
    public int total;
    
}
public class MidTestI {
    public static void main(String[] argv) throws IOException{
        /*
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        */
        //�x�sŪ�J���r��
        String[] line = new String[4];
        int index = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "Big5"));        
        while (br.ready()) {
            line[index++] = br.readLine();
        }
        FileWriter fw = new FileWriter("104213041_�i���@.txt");
        //Ū�J�Ĥ@����
        int n = Integer.parseInt(line[0]);
        // �ŧiPersonal�}�C
        Personal[] people = new Personal[n];
        for(int i = 0;i < n; i++)
            people[i] = new Personal();
        //��W�r�s�i array
        String[] name_string = line[1].split(" ");
        for (int i = 0; i < n; i++) {
            people[i].name = name_string[i];
        }
        //�ƾǦ��ZŪ�J
        String[] math_string = line[2].split(" ");
        for (int i = 0; i < n; i++){
            people[i].math = Integer.parseInt(math_string[i]);
        }
        //�{�����ZŪ�J
        String[] prog_string = line[3].split(" ");
        for (int i = 0; i < n; i++){
            people[i].prog = Integer.parseInt(prog_string[i]);
        }
        //���Z�[�`
        for (int i = 0; i < n; i++){
            people[i].total = people[i].math + people[i].prog;
        }
        System.out.println("��l���:.................");
        fw.write("��l���:.................\r\n");
        for (int i = 0; i < n; i++){
            System.out.println(people[i].name + "(�ƾ�:" + people[i].math + " �{�]:" + people[i].prog + " �`��:" + people[i].total + ")");
            fw.write(people[i].name + "(�ƾ�:" + people[i].math + " �{�]:" + people[i].prog + " �`��:" + people[i].total + ")\r\n");
        }
        System.out.println();
        fw.write("\r\n");
        //insertion sort
        boolean swapped;
        for (int i = 1; i < n; i++){
            swapped = false;
            Personal tempPerson = people[i];
            int j = i - 1;
            while (j > -1 && tempPerson.total < people[j].total){
                people[j + 1] = people[j];
                j = j - 1;
            }
            people[j + 1] = tempPerson;
            if (!swapped)
                swapped = true;
            //�L�X�C�@�^�X�洫���G
            System.out.println("��" + (i + 1) +"�^�X");
            fw.write("��"+ (i + 1) + "�^�X");
            for (int k = 0; k < n; k++){
                System.out.print(people[k].name + "(" + people[k].total + ") ");
                fw.write(people[k].name + "(" + people[k].total + ") ");
            }
            System.out.println();
            fw.write("\r\n");
            if (!swapped)
                break;
        }
        fw.flush();
        fw.close();
    }
}
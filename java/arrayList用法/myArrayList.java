import java.util.ArrayList;

public class myArrayList{
    public static void main(String[] argv){
        ArrayList test = new ArrayList<>();

        // �s�W����
        test.add(1);
        test.add('a');
        test.add('b');
        test.add('b');
        test.add('c');

        // �^�ǰ}�C�j�p : .size()
        for(int i = 0; i < test.size(); i++){
            // ���� : .get(���ޭ�)
            System.out.println(test.get(i));
        }

        // �d��O�_�]�t���w����
        boolean bool = test.contains('b');
        System.out.println("test contains 'b' ? " + bool);

        // �j�M�쪺�Ĥ@��
        int index = test.indexOf('b');
        System.out.println("b's index is " + index);

        // remove(���ޭ�),�R����۰ʩ��e����
        test.remove(index);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }

        // �P�_�}�C�O�_���� : .isEmpty
        if(!test.isEmpty()){
            System.out.println("test �}�C������!");
        }
    }
}
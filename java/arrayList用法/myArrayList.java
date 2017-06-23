import java.util.ArrayList;

public class myArrayList{
    public static void main(String[] argv){
        ArrayList test = new ArrayList<>();

        // 新增項目
        test.add(1);
        test.add('a');
        test.add('b');
        test.add('b');
        test.add('c');

        // 回傳陣列大小 : .size()
        for(int i = 0; i < test.size(); i++){
            // 取值 : .get(索引值)
            System.out.println(test.get(i));
        }

        // 查找是否包含指定項目
        boolean bool = test.contains('b');
        System.out.println("test contains 'b' ? " + bool);

        // 搜尋到的第一筆
        int index = test.indexOf('b');
        System.out.println("b's index is " + index);

        // remove(索引值),刪除後自動往前遞補
        test.remove(index);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }

        // 判斷陣列是否為空 : .isEmpty
        if(!test.isEmpty()){
            System.out.println("test 陣列不為空!");
        }
    }
}
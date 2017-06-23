import java.util.Random;
public class HW1{
    public static void main(String[] args){
        int i,j,k,tmp,n;
        Random rnd=new Random();
        n=(int)rnd.nextInt(11)+10;
        //System.out.println(n);
        int[] Data=new int[n];
        for(i=0;i<n;i++){
            tmp=(int)rnd.nextInt(101)-50;
            Data[i]=tmp;
        }
        for(i=n-1;i>0;i--){
            for(j=1;j<=i;j++){
                if(Data[j-1]>Data[j]){
                    tmp=Data[j-1];
                    Data[j-1]=Data[j];
                    Data[j]=tmp;
                }
            }
            for(k=0;k<n;k++){
                System.out.print(Data[k]+" ");
            }
            System.out.println();
        }

    }
}
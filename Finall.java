
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Finall{
    public static void main(String [] args) throws FileNotFoundException{
       // File ff=new File("pp.txt");
        Scanner sc=new Scanner(new File("2_20_25.txt"));
        int nooftasks=25;
        int noofprocessors=2;
        int i=0,j=1,k=1;
        int exetime[]=new int[nooftasks+1];
        int period[]=new int[nooftasks+1];
        exetime[0]=-1;
        period[0]=-1;
        while(sc.hasNext()){
            //System.out.println(sc.next());
            if((i%2)==0){
                exetime[j]=sc.nextInt();
                //System.out.println(i+" "+exetime[j]);
                i++;
                j++;
                
            }
              else{
               period[k]=sc.nextInt();
              // System.out.println(period[k]);
                i++;
                k++;
            }
        }
        double sum=0;
        for( i=1;i<=nooftasks;i++){
            System.out.println(i+" "+exetime[i]+" "+period[i]);
            sum=sum+((double)exetime[i]/period[i]);
            System.out.println((double)exetime[i]/period[i]);
        }
        System.out.println(sum);
        sc.close();
        
        
    }
}
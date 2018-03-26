
import java.util.HashSet;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhivandit
 */
public class Test {
    public static void main(String [] args){
        int count=10000;
        int size=20;
                    int count2=0;
        for(int i=1;i<=count;i++){
            Random rand=new Random();
            rand.setSeed(i);
            HashSet<Integer> h1=new HashSet<Integer>();
            
          //  System.out.println(h1);
            for(int j=1;j<=size;j++){
                int date=rand.nextInt(365);
               
               // h1.add(date);
              
                if((h1.add(date))==false){
                    count2++;
                    break;
                }
                
            }
            
            




        }

            double percentage=(((double)count2)/count)*100.0;
System.out.println(percentage+" "+count2+" "+count);
    }
    }

    



import java.text.DecimalFormat;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhivandit
 */
public class Schedule {
    public static void main(String[] args){
        int flag=0;
        Scanner sc=new Scanner(System.in);
        Random rnd=new Random();
        //DecimalFormat decimalFormat = new DecimalFormat("0.###");
        int nooftasks=10;
        while(nooftasks<=10){
            double exetime[]=new double[nooftasks+1];
            double period[]=new double[nooftasks+1];
            exetime[0]=-1.0;
            period[0]=-1.0;
            double newexecutiontime[]=new double[nooftasks+1];
            newexecutiontime[0]=-1.0;
            double sum=0.0;
            for(int i=1;i<=nooftasks;i++){
                exetime[i]=rnd.nextInt(50)+1;
                newexecutiontime[i]=exetime[i];
                period[i]=rnd.nextInt(51)+51;
                sum=sum+Math.round(((exetime[i])/period[i])*100.0)/100.0;
            }
            int noofprocessors=2;
            for(noofprocessors=2;noofprocessors<=16;noofprocessors=noofprocessors*2){
                double x=Math.round(((double)20/100)*100.0)/100.0;
               
                
                //System.out.println(x);
                
            double utilization=((x)*noofprocessors);
            while(utilization<=(Math.round(((double)50/100)*100.0)/100.0)*noofprocessors){
                //System.out.println(x);
                x=Math.round((x+((double)10/100))*100.0)/100.0;
                    double sum2=0.0;
                    double framesizes[]=new double[nooftasks+1];
                    framesizes[0]=(-1.0);
              //  System.out.println(.2+.1);
                if(sum!=utilization){
                   
                    double utilizationfactor=(sum)/utilization;
                    for(int i=1;i<=nooftasks;i++){
                        newexecutiontime[i]=(Math.round((exetime[i]/utilizationfactor)*100.0))/100.0;
                        if(newexecutiontime[i]>period[i]){
                            System.out.println(newexecutiontime[i]+" "+period[i]);
                            System.out.println(sum+" "+utilization);
                            System.out.println("flag");
                            flag=1;
                            break;
                        }
                        if(flag==1){
                            break;
                        }
                       sum2=sum2+(newexecutiontime[i]/period[i]);
                       framesizes[i]=period[i];
                       // System.out.println(newexecutiontime[i]+" i "+i+"period"+period[i]);
                    }
                    if(flag==1){
                        break;
                    }
                }
                if(flag==1){
                    break;
                }
                Arrays.sort(framesizes);
             //   System.out.println(framesizes[nooftasks]+" framesize");
          // System.out.println("sum2 "+sum2);
               // System.out.println(utilization+" "+sum);
                
                
                
                
                
                //System.out.println("x "+x);
          utilization=x*noofprocessors;  }//utilization
            }//noofprocessors
            
     nooftasks=nooftasks+10;}//nooftasks
        
        
        
    }
    
}

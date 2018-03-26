
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Finall{
    public static void main(String [] args) throws FileNotFoundException{
       // File ff=new File("pp.txt");
        Scanner sc=new Scanner(new File("Set_1_Input_m_4_U_30_n_25_tss_80.txt"));
        int nooftasks=25;
        int noofprocessors=4;
          int counter=0;
          int counter2=0;
        double globalrealpowerconsumption=0.0;
        double globalhighestpowerconsumption=0.0;
        double globalhighconsumption=0.0;
        int i=0,j=1,k=1;
        int exetime[]=new int[nooftasks+1];
        int period[]=new int[nooftasks+1];
        double globalframesize[]=new double[nooftasks+1];
        double globalframeexetime[]=new double[nooftasks+1];
        globalframesize[0]=-1.0;
        globalframeexetime[0]=-1.0;
        int checkcounterh=0,checkcounterl=0;
       double frameexetime[]=new double[nooftasks+1];
       double framesize[]=new double[nooftasks+1];
        exetime[0]=-1;
        frameexetime[0]=-1;
        framesize[0]=-1;
        period[0]=-1;
        int z=0;
        while(z<nooftasks){
            //System.out.println(sc.next());
           // if((i%2)==0){
             int id = sc.nextInt();
			            int arrivalTime = sc.nextInt();
                exetime[j]=sc.nextInt();
                frameexetime[j]=exetime[j];
                globalframeexetime[j]=exetime[j];
                //System.out.println(i+" "+exetime[j]);
              //  i++;
               
                
          //  }
             // else{
               period[k]=sc.nextInt();
               framesize[k]=period[k];
               globalframesize[k]=period[k];
              // System.out.println(period[k]);
               // i++;
             // System.out.println(z+" "+exetime[j]+" "+period[k]);
                j++;
                k++;
                z++;
            //}
            
        }
        double sum=0;
       // System.out.println("taskno T[i] P[i]");
        for( i=1;i<=nooftasks;i++){
            //System.out.println(i+" "+exetime[i]+" "+period[i]);
            sum=sum+((double)exetime[i]/period[i]);
          // System.out.println("T[i]/P[i] "+(double)exetime[i]/period[i]);
        }
        //System.out.println("net sum "+sum);
        sc.close();
        
       
        double t=0.0;
         while(t<100000){
             sum=0.0;
             double timeslots=0.0;
                Arrays.sort(framesize);
                int currentnoofprocessors=noofprocessors;
             double currentframesize=framesize[1];
             //System.out.println(framesize[1]);
              ArrayList<Double> lighttasks=new ArrayList<Double>(nooftasks+1);
 ArrayList<Double> heavytasks=new ArrayList<Double>(nooftasks+1);
 
 heavytasks.ensureCapacity(nooftasks+1);
 lighttasks.ensureCapacity(nooftasks+1);
 
  lighttasks.add(0,-1.0);
     heavytasks.add(0,-1.0);
   
   //System.out.println(heavytasks);
  
             for(i=1;i<=nooftasks;i++){
                 if(globalframesize[i]>=0.0 &&frameexetime[i]>=0.0){
                 frameexetime[i]=Math.round(((double)currentframesize/globalframesize[i])*(double)frameexetime[i]*1000.0)/1000.0;
               // System.out.println(frameexetime[i]);
                
                  lighttasks.add(i,frameexetime[i]);
   heavytasks.add(i,-1.0);
                sum=sum+frameexetime[i];
                 }
                 else{
                     System.out.println("failure");
                 }
             }
             int flag=1;
             double optimalrequiredframefrequency=0.0;
             double modifiedframeexetime[]=new double[nooftasks+1];
             modifiedframeexetime[0]=-1.0;
             
             while(flag!=0){
                 double framesum1=0.0;
              // System.out.println(lighttasks);
             //System.out.println(heavytasks);
              double totalframerequirement=0;
            //System.out.println(nextframesize + "nextframesize");
            
             ArrayList<Double> newlighttasks=new ArrayList<Double>(nooftasks+1);
             for(int g=0;g<lighttasks.size();g++){
                 newlighttasks.add(g,lighttasks.get(g));
             }
             
             Collections.sort(newlighttasks);
             double required=newlighttasks.get(newlighttasks.size()-1);
            // System.out.println(lighttasks);
          //   System.out.println(newlighttasks);
            // System.out.println(required);
            double totalframecapacity=(currentnoofprocessors*currentframesize);
           // System.out.println(totalframecapacity);
            //int sizelighttasks = lighttasks.size();
            for(int l=1;l<=nooftasks;l++){
                double currentlighttask=lighttasks.get(l);
                if(currentlighttask>=0.0){
                totalframerequirement=totalframerequirement+lighttasks.get(l);
                }
            }
                
            //totalframerequirement=totalframerequirement+frameexetime[j];
             optimalrequiredframefrequency=((double)(totalframerequirement)/totalframecapacity);
             if(optimalrequiredframefrequency<(0.4)){
                 optimalrequiredframefrequency=0.4;
             }
            // System.out.println(optimalrequiredframefrequency);
             int flag2=0;int flag3=0;int isHeavyTaskPresent=0;
             
           //new colection mirroring lightttask 
           checkcounterl=0;
             for(int l=1;l<=nooftasks;l++){
                 if(lighttasks.get(l)>=0.0){
                     modifiedframeexetime[l]=(lighttasks.get(l))/optimalrequiredframefrequency;
                     if(modifiedframeexetime[l]>currentframesize){
                         if(lighttasks.get(l)==required){
                         heavytasks.set(l,lighttasks.get(l));
                         checkcounterh++;
                          modifiedframeexetime[l]=-1.0;
                         lighttasks.set(l,-1.0);
                        counter++;
                         
                         currentnoofprocessors--;
                        // System.out.println(currentnoofprocessors+"cc");
                         if(currentnoofprocessors==0&&(l!=nooftasks)){
                     flag3=1;
                    
                 }
                          flag=1;
                          flag2=1;
                         break;
                         }
                         else{
                             isHeavyTaskPresent=1;
                         }
                         
                        
                     }
                     else if(isHeavyTaskPresent==0){
                         flag=0;
                         modifiedframeexetime[l]=Math.round((double)modifiedframeexetime[l]*1000.0)/1000.0;
                         framesum1=framesum1+modifiedframeexetime[l];
                       //  System.out.println(framesum1+" "+(currentnoofprocessors*currentframesize));
                         checkcounterl++;
   
                         
                     }
                     
                 }
                 if(flag2==1){
                     break;
                     
                 }
                 if(currentnoofprocessors==0&&(l!=nooftasks)){
                     flag3=1;
                     break;
                 }
                 
             }//for
             if(flag3==1){
                 System.out.println("unschedulabe");
                 flag=0;
             }
             
               //   System.out.println(lighttasks);
            // System.out.println(heavytasks);
           //  for(int l=0;l<=nooftasks;l++){
           //  System.out.print(modifiedframeexetime[l]+", ");}
             
             
// System.out.

                
             
            //System.out.println(optimalrequiredframefrequency+" "+currentframesize);
            //optimalrequiredframefrequency=(double)sum/(noofprocessors*currentframesize);
            // System.out.println(optimalrequiredframefrequency);
             
           }//flag end
             //System.out.println(checkcounterh+checkcounterl);   System.out.println(currentnoofprocessors+"cc");
               int processors[][]=new int[noofprocessors+1][(int)currentframesize+1];//ye dekhna
                  for(int m=0;m<=noofprocessors;m++){
              for(int n=0;n<=(int)currentframesize;n++){
                  processors[m][n]=(-1);
              }
          }
                  int processorno=1;
                  for(int m=1;m<=nooftasks;m++){
                      if(heavytasks.get(m)>=0.0){
                          
                      //int g=(int)heavytasks.get(m);
                          for(int n=0;n<=(int)(currentframesize);n++){
                              
                          if(n<=heavytasks.get(m)){
                          processors[processorno][n]=m;}
                          else{
                              processors[processorno][n]=-1;
                              //timeslots++;
                          }
                          
                      }
                          timeslots=timeslots+(currentframesize-(heavytasks.get(m)));
                          
                          
                      
                      
                      processorno++;
                      
                  }
                  }
                /* ArrayList<Double> fortaskno=new ArrayList<Double>();
                 fortaskno.ensureCapacity(nooftasks+1);
                 for(int m=0;m<=nooftasks;m++){
                     fortaskno.add(m,-1.0);
                     fortaskno.set(m,lighttasks.get(m));
                 }*/
                
                 //System.out.println(fortaskno);
                 Arrays.sort( modifiedframeexetime);
                         //for(int m=0;m<=nooftasks;m++){
                 // System.out.print(modifiedframeexetime[m]+", ");}
                 // System.out.println(heavytasks);
                  double framesum=0.0;
                  double previousframesum=0.0;
                  for(int m=nooftasks;m>=0;m--){
                      
                      double currenttask=modifiedframeexetime[m];
                      if(currenttask>=0.0){
                           counter2++;
                          previousframesum=framesum;
                          framesum=framesum+currenttask;
                          /*int index=lighttasks.indexOf(currenttask);
                          if(framesum<=currentframesize){
                         for(int n=previousframesum;n<=framesum;n++){
                             processors[noofprocessors][n]=index;
                         }//n
                          }//if*/
                          
                          
                      }//if
                      
                  }//m
                  framesum=Math.round(framesum*1000.0)/1000.0;
               
                  
                 // System.out.println(currentnoofprocessors);
                  double remainingpower=((currentnoofprocessors))*currentframesize;
                     if(Math.abs(framesum-remainingpower)<1.0){
                         framesum=remainingpower;
                     }
                  if(framesum>remainingpower){
                      System.out.println("unschedulable2 "+framesum+" "+remainingpower);
                  }
                  else{
                      timeslots=timeslots+(remainingpower-framesum);
                  }
             //     System.out.println(timeslots);
                  double ff=0.0;
                  for(int m=1;m<=nooftasks;m++){
                     //globalframeexetime[m]=frameexetime[m];
                     frameexetime[m]=globalframeexetime[m]-frameexetime[m];
                     globalframeexetime[m]=frameexetime[m];
                     framesize[m]=(globalframesize[m]-currentframesize);
                     ff=Math.round((globalframesize[m]-currentframesize)*10.0)/10.0;
                     globalframesize[m]=framesize[m];
                     if(ff==0.0){
                         framesize[m]=period[m];
                         globalframesize[m]=period[m];
                         frameexetime[m]=exetime[m];
                         globalframeexetime[m]=exetime[m];
                         
                     }
                     
                      
                  }
                  
                  
                  
                   if(timeslots>=2.0){
                    //   System.out.println("inside");
                   globalrealpowerconsumption=globalrealpowerconsumption+((noofprocessors*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*currentframesize)-((timeslots)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency))+(timeslots*(.08)*(.08)*(.08)));
                  // System.out.println(globalrealpowerconsumption+" "+((noofprocessors*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*currentframesize)-((timeslots)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency))));
                 //  System.out.println((noofprocessors*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*currentframesize));
                 //  System.out.println(timeslots);
                   }
                   else{
                       globalrealpowerconsumption=globalrealpowerconsumption+(noofprocessors*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*currentframesize);
                   }
                   globalhighestpowerconsumption=globalhighestpowerconsumption+(noofprocessors*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*(optimalrequiredframefrequency)*currentframesize);
                  globalhighconsumption=globalhighconsumption+(noofprocessors*currentframesize);
                  
                  
                  
                  
                  
                 
                  
               
               
               
                          
             
             
                       // t++;
           t=t+currentframesize;
         
             
            // t=t+currentframesize;
         }
       //  System.out.println(counter+" "+counter2);
        // System.out.println(globalrealpowerconsumption+" "+globalhighestpowerconsumption+" "+globalhighconsumption);
        System.out.println("dpm/dvfs "+globalrealpowerconsumption/globalhighestpowerconsumption);
        System.out.println("dpm/max "+globalrealpowerconsumption/globalhighconsumption);
        
    }
}
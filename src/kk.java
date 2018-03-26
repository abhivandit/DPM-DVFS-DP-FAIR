
public class kk {
    public static void main(String [] args){
        int size=4;
        int flag=0;
        int size1=size;
        int height=(2*size1-1)+2;
        int breadth=(2*size1)+2;
        int size2=size;
        for(int i=1;i<=height;i++){
           for(int j=1;j<=breadth;j++){
                if(((i==1)||(i==height))) {


                    if ((j == 1) || (j == breadth)) {
                        System.out.print("+");
                    }
                    else{
                      System.out.print("-");
                    }

                }
                else if((j==1)||(j==breadth)){
                    
                    System.out.print("|");
                }
                
                else{
                   
                   
                        //System.out.print("ds");
                        //System.out.print(j+" "+size2);
                        if(j<size2+1){
                            System.out.print(" ");
                        }
                        if(j==(size2+1)){
                            
                            if(i==((height+1)/2)){
                            
                            System.out.print("<");
                        }
                            else if(i<((height+1)/2)){
                                System.out.print("/");
                            }
                             else if(i>((height+1)/2)){
                                System.out.print("\\");
                            }
                        }
                  
                        if((j>size2+1)&&(j<(breadth-size2))){
                            if(i%2==0){
                            System.out.print("=");
                            }
                            else{
                                if(i==9){
                                System.out.print("-");}
                                else{
                                    System.out.print("-");
                                }
                            }
                        }
                        if(j==(breadth-size2)){
                            if(i==((height+1)/2)){
                            
                            System.out.print(">");
                        }
                            else if(i<((height+1)/2)){
                                System.out.print("\\");
                            }
                             else if(i>((height+1)/2)){
                                System.out.print("/");
                            }
                        }
                        if(j>breadth-size2){
                            System.out.print(" ");
                        }
                    
                }

    }
           //System.out.print(size2);
           if(i!=1){
                if(size2>1&&flag==0){
                            size2--;
                           }
                else if(size2==1&&flag==0)   {
                    size2++;
                                   
                                    flag=1;
                                    }
                else if(flag==1)    {
                    size2++;
                }
               
                                    
                      }
            System.out.print("\n");
        }




    }

    }


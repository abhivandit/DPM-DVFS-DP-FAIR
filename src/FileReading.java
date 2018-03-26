import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 File fileRead = new File("Set_1_Input_m_16_U_90_n_200_tss_80.txt");
		 //Creating Scanner instance to read File in Java
	        Scanner scnr = null;
			try {
				scnr = new Scanner(fileRead);
				int n = 0;
				 while(n<200){
			           // String line = scnr.nextLine();
			            int id = scnr.nextInt();
			            int arrivalTime = scnr.nextInt();
			            int exeReq = scnr.nextInt();
			            int periodReq = scnr.nextInt();			            
			            System.out.println( id + " " + arrivalTime + " " + exeReq + " " + periodReq);  
			            n++;
				 } 
				
				scnr.close();
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}

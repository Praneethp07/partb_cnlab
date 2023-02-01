import java.util.*;
public class crc{
	public static void main(String[]args){
	//sender
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the message");
	String message = sc.nextLine();
	System.out.println("Enter the generator");
	String generator = sc.nextLine();
	int data[] = new int[message.length()+ generator.length() -1];
	int divisor[] = new int[generator.length()];
	for(int i=0;i<message.length();i++){
		data[i] = Integer.parseInt(message.charAt(i)+"");
	}
	for(int i=0;i<generator.length();i++){
		divisor[i] = Integer.parseInt(generator.charAt(i)+"");
	}
	
	//calacuating crc
	for(int i=0;i<message.length();i++){
		if(data[i] == 1){
			for(int j=0;j<generator.length();j++){
				data[i+j] ^= divisor[j];
			} 
		}
	}
	//displaying crc
	for(int i=0;i<message.length();i++){
		data[i] = Integer.parseInt(message.charAt(i)+"");	
	}	
	System.out.print("the checksum is:");
	for(int i=0;i<data.length;i++){
		System.out.print(data[i]);
	}
	System.out.println();
	//taking checksum input
	System.out.println("Enter the checksum");
	message = sc.nextLine();
	System.out.println("Enter the generator");
	generator = sc.nextLine();
	data = new int[message.length()];
	divisor = new int[generator.length()];
	for(int i=0;i<message.length();i++){
		data[i] = Integer.parseInt(message.charAt(i)+"");
	}
	for(int i=0;i<generator.length();i++){
		divisor[i] = Integer.parseInt(generator.charAt(i)+"");
	}
	//calculating remainder
	for(int i=0;i<message.length();i++) {
		if(data[i]==1)
			for(int j=0;j<generator.length();j++)
				data[i+j] ^= divisor[j]; 
	}
	
	//chaecking for validity
	
	boolean valid = true;
	for(int i=0;i<data.length;i++){
	System.out.print(data[i]);
		if(data[i] == 1){
			valid = false;
			break;
		}
	}
	//display
	
	if(valid){
		System.out.print("the checksum is valid");
	}else{
		System.out.print("the checksum is not valid, crc error detected");
	}
	
	
}
}


import java.io.*;
import java.util.*;
public class rsa{
	static int ptoc(int x,int y,int n){
		int k=1;
		int j;
		for(j=1;j<=y;j++)
			k = (k*x)%n;
		return k;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of prime number p and q");
		int p=sc.nextInt();
		int q=sc.nextInt();
		int n=p*q;
		int z = (p-1)*(q-1);
		System.out.println("Enter the value of e");
		int e =  sc.nextInt();
		String message;
		System.out.println("Enter the message");
		message = br.readLine();
		char msg[] = message.toCharArray();
		int pt[] = new int[100];
		int ct[] = new int[100];
		for(int i=0;i<msg.length;i++){
			pt[i] = msg[i];	
		}
		int d;
		for(d=1;d<z;d++){
			if((e*d)%z == 1){
				break;
			}	
		}
		System.out.println("p="+""+p+"\tq="+q+"\tn="+n+"\tz="+z+"\te="+e+"\td="+d);
		for(int i=0;i<msg.length;i++){
			ct[i] = ptoc(pt[i],e,n);
		}
		for(int i=0;i<msg.length;i++){
			System.out.print("\t"+ct[i]);
		}
		System.out.println("\nPlain Text = ");
		for(int i=0;i<msg.length;i++){
			pt[i] = ptoc(ct[i],d,n);
		}
		for(int i=0;i<=msg.length;i++){
			System.out.print((char)pt[i]);
		}
		
		
		
	}
	
}

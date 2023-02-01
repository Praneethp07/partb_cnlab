import java.io.*;
import java.net.*;
public class cserver{
	public static void main(String[]args)throws Exception{
	ServerSocket sersock = new ServerSocket(4000);
	System.out.println("ready for connection");
	Socket sock = sersock.accept();
	System.out.println("connected successfully");
	InputStream istream = sock.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(istream));
	String name = br.readLine();
	OutputStream ostream = sock.getOutputStream();
	PrintWriter pwrite = new PrintWriter(ostream,true);
		try(BufferedReader content = new BufferedReader(new FileReader(name))){
		String str;
		while((str = content.readLine())!= null){
		
			pwrite.println(str);
			}
		}
		catch(Exception e){
			System.out.println("file not found");
		}
		sersock.close();
		sock.close();
		pwrite.close();
	}		
}

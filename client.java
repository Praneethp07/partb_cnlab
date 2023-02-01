import java.io.*;
import java.net.*;
public class client{
	public static void main(String[]args)throws Exception{
		Socket sock = new Socket("127.0.0.1",4000);
		System.out.println("Enter the file name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream,true);
		pwrite.println(name);
		InputStream istream = sock.getInputStream();
		BufferedReader sockcont = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=sockcont.readLine())!=null){
			System.out.print(str);	
		}
		sock.close();
		istream.close();
		br.close();
		
	}
}


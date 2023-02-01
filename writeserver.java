import java.net.*;
public class writeserver{
private static int clientport = 1160;
private static int serverport = 1150;
private static int buffer_size = 1024;
private static DatagramSocket ds;
private static byte buffer[] = new byte[buffer_size];
public static void server()throws Exception{
	int pos =0;
	while(true){
	int c = System.in.read();
		switch(c)
		{
		case -1:System.out.println("server quits");
		return;
		case '\r':break;
		case '\n':ds.send(new DatagramPacket(buffer,pos,InetAddress.getLocalHost(),clientport));
		pos =0;break;
		default:buffer[pos++] = (byte)c;
		}
	}
}
public static void client()throws Exception{
	while(true){
	DatagramPacket p = new DatagramPacket(buffer,buffer.length);
	ds.receive(p);
	System.out.println(new String(p.getData(),0,p.getLength()));
	}
}
public static void main(String[]args)throws Exception{
if(args.length == 1){
	ds = new DatagramSocket(serverport);
	server();
}else{
	ds = new DatagramSocket(clientport);
	client();
}

}
}

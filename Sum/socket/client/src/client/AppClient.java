package Sum.socket.client;
import java.net.UnknownHostException;
import java.net.InetSocketAddress;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.io.IOException;

public class AppClient {
    public static void main(String[] args) {
		System.out.println("Welcome");
		Scanner scanner=new Scanner(System.in);
		
        System.out.print("n=");
        int n=scanner.nextInt();
		
        SocketChannel sc=null;
        try{
            InetSocketAddress isa=new InetSocketAddress(8000);
            sc=SocketChannel.open();
            sc.connect(isa);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }      

        ByteBuffer bb=ByteBuffer.allocate(128);
        IntBuffer lb=bb.asIntBuffer();
        lb.put(0,n);
        try{
            sc.write(bb);
            bb.clear();
            sc.read(bb);
            String r=new String(bb.array(),"UTF-8");
            System.out.println(r);
            sc.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}

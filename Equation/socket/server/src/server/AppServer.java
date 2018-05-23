package Equation.socket.server;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AppServer {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel;
        try{
            serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress isa=new InetSocketAddress(8000);
            ServerSocket ss=serverSocketChannel.socket();
            ss.bind(isa);
            System.out.println("Server Started");

            while(true)
            {
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Client Connected");
                try{
                    ByteBuffer bb = ByteBuffer.allocate(1024);
                    IntBuffer lb = bb.asIntBuffer();
                    socketChannel.read(bb);

                    int n=lb.get(0);

                    System.out.println("n="+n);

                    String result=func(n);
			
                    System.out.println(result);

                    bb.clear();
                    bb = ByteBuffer.wrap(result.getBytes("UTF-8"));

                    System.out.println("Operation Done");
                    socketChannel.write(bb);
                    socketChannel.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
	public static String func(int num)
    {
		String sir = "Sirul este:";
		StringBuilder sb = new StringBuilder (String.valueOf (sir));
		sb.append(num);
		sb.append(",");	
        int count = 0;
        while(num!=1)
        {
            if(num%2==0)
            {
                num /= 2;	
				sb.append(num);
				sb.append(",");					
            }
            else
            {
                num = 3*num + 1;
				sb.append(num);
				sb.append(",");
                count++;
            }
        }
		sb.append(" [nr pasi =");
		sb.append(count);
		sb.append("]");
        return sb.toString();
    }
}

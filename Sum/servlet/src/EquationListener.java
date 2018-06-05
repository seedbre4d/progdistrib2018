import java.io.IOException;
import javax.servlet.*;

public class SumListener implements ReadListener, WriteListener{
    private ServletInputStream input = null;
    private AsyncContext context = null;
    private ServletOutputStream out = null;
    private boolean readFinished=false;
    private String rez=null;
    private String data=null;

    public SumListener(ServletInputStream in, AsyncContext ac, ServletOutputStream output) throws IOException{
        input = in;
        context = ac;
        out = output;
        in.setReadListener(this);
        out.setWriteListener(this);
    }

    @Override
    public void onDataAvailable() {
        try {
            int len = 0;
            byte b[] = new byte[1024];
            StringBuffer sb=new StringBuffer(1024);
            while (input.isReady() && (len>-1)) {
                len=input.read(b);
                if(len>0) sb.append(new String(b,0,len));
            }
            data = sb.toString();
            System.out.println(data);
        }
        catch (IOException e) {
            System.out.println("onAvailableException : "+e.getMessage());
        }
    }

    @Override
    public void onAllDataRead() throws IOException{
        System.out.println("onAllDataRead");
        readFinished=true;
        System.out.println(data);
        rez=solver(data);
        context.complete();
        onWritePossible();

    }

    @Override
    public void onWritePossible() throws IOException {
        while(!readFinished);
        StringBuffer sb=new StringBuffer(1024);
        sb.append("<html><head><title>The result!</title></head>");
        sb.append("<body><h1>Your variable is:</h1><p>");
        sb.append(rez);
        sb.append("</p></body></html>");
        out.print(sb.toString());
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        context.complete();
    }

    //IMPLEMENT HERE
    private String solver(String data){
        String[] s0=data.split("=");
        long n=Long.parseLong(s0[1]);
        String r=func(n);
        return r;
    }

    private String func(long num){
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
    //IMPLEMENT HERE
}
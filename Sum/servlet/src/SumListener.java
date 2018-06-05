import java.io.IOException;
import javax.servlet.*;
import java.util.stream.IntStream;

public class SumListener implements ReadListener, WriteListener {
    private ServletInputStream input = null;
    private AsyncContext context = null;
    private ServletOutputStream out = null;
    private boolean readFinished = false;
    private String rez = null;
    private String data = null;

    public SumListener(ServletInputStream in, AsyncContext ac, ServletOutputStream output) throws IOException {
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
            StringBuffer sb = new StringBuffer(1024);
            while (input.isReady() && (len > -1)) {
                len = input.read(b);
                if (len > 0)
                    sb.append(new String(b, 0, len));
            }
            data = sb.toString();
            System.out.println(data);
        } catch (IOException e) {
            System.out.println("onAvailableException : " + e.getMessage());
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("onAllDataRead");
        readFinished = true;
        System.out.println(data);
        rez = solver(data);
        context.complete();
        onWritePossible();

    }

    @Override
    public void onWritePossible() throws IOException {
        while (!readFinished)
            ;
        StringBuffer sb = new StringBuffer(1024);
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

    // IMPLEMENT HERE
    private String solver(String data) {
        String[] s0 = data.split("=");
        int n = Integer.parseInt(s0[1]);
        String r = func(n);
        return r;
    }

    public String func(int n) {
        Integer sum = IntStream.range(1, n).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        return sb.toString();
    }
    // IMPLEMENT HERE
}
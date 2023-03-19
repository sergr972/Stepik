import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        test();
        convert(System.in,System.out);
    }

    private static void test() throws IOException {
        byte[] test = new byte[]{65, 13, 10, 10, 13};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(10);

        convert(new ByteArrayInputStream(test),outputStream );
        byte[] out = outputStream.toByteArray();
        for (int i: out) {
            System.out.println(i);
        }
    }

    private static void convert(InputStream inputStream, OutputStream outputStream) throws IOException {
        int prev = inputStream.read();
        int next;

        while(prev != -1){
            next = inputStream.read();
            if (next != 10 || prev != 13){
                outputStream.write(prev);
            }
            prev = next;
        }
        outputStream.flush();
    }
}

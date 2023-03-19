import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CheckSum {
    public static int checkSumOfStream(InputStream inputStream)throws IOException {
        int checkSum = 0;
        int is = inputStream.read();
        while (is != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ is;
            is = inputStream.read();
        }
        return checkSum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})));
    }
}

package securesockets;

import java.io.OutputStream;
import java.io.PrintWriter;

public class PrintWriterSecured extends PrintWriter {

    private final String ENCRYPTION_KEY;

    public PrintWriterSecured(OutputStream outputStream, boolean autoFlush, String encryption_key) {
        super(outputStream, autoFlush);
        ENCRYPTION_KEY = encryption_key;
    }

    public void printlnEncrypt(String msg) {
        println(AES.encrypt(msg, ENCRYPTION_KEY));
    }
}

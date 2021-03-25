package securesockets;

import java.io.IOException;
import java.net.Socket;

public class SecureSocket {

    private final PrintWriterSecured printWriterSecured;
    private final BufferedReaderSecured bufferedReaderSecured;
    private final Socket socket;

    public SecureSocket(PrintWriterSecured printWriterSecured, BufferedReaderSecured bufferedReaderSecured, Socket socket) {
        this.printWriterSecured = printWriterSecured;
        this.bufferedReaderSecured = bufferedReaderSecured;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReaderSecured getBufferedReaderSecured() {
        return bufferedReaderSecured;
    }

    public PrintWriterSecured getPrintWriterSecured() {
        return printWriterSecured;
    }

    public void printlnSecured(String msg) {
        printWriterSecured.printlnEncrypt(msg);
    }

    public String readLineSecured() throws IOException {
        return bufferedReaderSecured.readDecryptedLine();
    }
}

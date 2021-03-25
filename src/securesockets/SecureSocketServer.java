package securesockets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SecureSocketServer extends ServerSocket {

    public SecureSocketServer(int port) throws IOException {
        super(port);
    }

    public SecureSocket acceptSecured(String encryption_key) throws IOException {

        Socket socket = accept();

        BufferedReaderSecured bufferedReaderSecured =
                new BufferedReaderSecured(new InputStreamReader(socket.getInputStream()), encryption_key);

        PrintWriterSecured printWriterSecured =
                new PrintWriterSecured(socket.getOutputStream(), true, encryption_key);

        return new SecureSocket(printWriterSecured, bufferedReaderSecured, socket);
    }


}

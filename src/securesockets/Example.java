package securesockets;

import java.io.IOException;

public class Example {

    private static final int PORT = 0000;
    private static final String ENCRYPTION_KEY = "INSERT_KEY_HERE";

    public static void main(String[] args) {

        SecureSocketServer secureSocketServer;

        try {
            secureSocketServer = new SecureSocketServer(PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Listening to sockets . . .");


        // listen to license requests all the time
        while (true) {

            try {

                // accepts incoming sockets
                SecureSocket socket = secureSocketServer.acceptSecured(ENCRYPTION_KEY);

                // reading a decrypted message that was encrypted and sent by the client
                String message_from_client = socket.readLineSecured();

                // send an encrypted string message to client
                socket.printlnSecured("message that will be encrypted here");


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

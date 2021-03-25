package securesockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderSecured extends BufferedReader {

    private final String ENCRYPTION_KEY;

    public BufferedReaderSecured(InputStreamReader inputStreamReader, String encryption_key) {
        super(inputStreamReader);
        ENCRYPTION_KEY = encryption_key;
    }

    public String readDecryptedLine() throws IOException {
        return AES.decrypt(readLine(), ENCRYPTION_KEY);
    }
}

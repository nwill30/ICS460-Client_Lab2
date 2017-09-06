import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String args[])throws Exception{

        Socket socket = new Socket("127.0.0.1",5000);
        String message = "Accept Message";

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeBytes(message);
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}

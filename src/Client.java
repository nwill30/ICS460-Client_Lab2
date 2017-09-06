import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String args[])throws Exception{

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 5000);
        }catch (ConnectException e){
            e.printStackTrace();
            System.out.println("Err: No connection available at specified location.");

        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file directory of a location on the server.");
        String userInput = scanner.nextLine();

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeBytes(userInput);

        dataOutputStream.close();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(inputStream));

        String readLine = bufferedReader.readLine();

        System.out.println(readLine);

//        bufferedReader.close();
//        inputStream.close();
//        socket.close();

    }
}

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

            Socket socket = null;
            InputStreamReader inputStreamReader = null;
            OutputStreamWriter outputStreamWriter = null;
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your username:");
            String username = scanner.nextLine();

        try{
            socket = new Socket("localhost",6009);

            // This part handles reading data sent from the server converting it into character stream.
            // socket.getInputStream() opens a stream to receive data from the server.
            inputStreamReader = new InputStreamReader(socket.getInputStream());

            // This part handles sending data to the server converting it into byte stream.
            // socket.getOutputStream() opens a stream to send data to the server.
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            // Wrapping InputStreamReader and OutputStreamWriter with BufferedReader and BufferedWriter
            // for more efficient reading and writing of data (line by line).
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            while(true) {
                System.out.println("Enter a message: ");
                String messageTosend = username +": "+ scanner.nextLine();
                String[] splitUsername = messageTosend.split(": ");

                if (splitUsername[1].equalsIgnoreCase("exit")) {
                    break;
                }

                bufferedWriter.write(messageTosend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                //receiving the message from server and showing it to the console
                String messageToreceive = bufferedReader.readLine();
                System.out.println("Server: " + messageToreceive );


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer{
    public static void main(String[] args) throws IOException {
        Socket socket = null;

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        Scanner scanner = new Scanner(System.in);

        try{
            //listening on port 6009
            ServerSocket serverSocket = new ServerSocket(6009);
            // waiting for client connection
            System.out.println("Waiting for Client...");
            socket = serverSocket.accept();
            System.out.println("Client Connected!");

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
                String messageFromClient = bufferedReader.readLine();
                System.out.println(messageFromClient);

                bufferedWriter.write("Message Received!");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if (messageFromClient.equalsIgnoreCase("exit")) {
                    continue;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


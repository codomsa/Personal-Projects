package UDPClient;
import java.io.*;
import java.net.*;

class UDPClient {
    public static void main(String args[]) throws Exception {
        InetAddress serverAddr = InetAddress.getByName("127.0.0.1");
        int port = 5678;

        // creez socket
        DatagramSocket clientSocket = new DatagramSocket();

        // input de la tastatura
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a message: ");
        String message = br.readLine();

        // trimit mesajul catre server
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddr, port);
        clientSocket.send(sendPacket);

        // primesc feedback
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String response = new String(receivePacket.getData()).trim();

        System.out.println("Response from server: " + response);

        // Sayonara, Socket-san
        clientSocket.close();
    }
}
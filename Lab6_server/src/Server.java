import managers.CommandManagers;
import request.Request;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    private DatagramSocket socket;
    private InetAddress address;
    int port;
    private byte[] buffer = new byte[5000];

    public Server(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void listen() throws Exception {
        while (true) {
            Request request = getRequest();

            if (request == null || request.getMessage() == null) {
                System.err.println("Received a null request or message.");
                continue; // Пропустить итерацию и ожидать следующего запроса
            }

            String message = CommandManagers.startExecuting(request);
            request.setMessage(message);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(request);
            objectOutputStream.close();
            DatagramPacket sendPacket = new DatagramPacket(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, address, port);

            socket.send(sendPacket);
        }
    }

    public Request getRequest() throws IOException, ClassNotFoundException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        address = packet.getAddress();
        port = packet.getPort();

        Request request;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        request = (Request) objectInputStream.readObject();
        objectInputStream.close();

        return request;
    }
}

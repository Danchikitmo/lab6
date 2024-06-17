package server;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import request.Request;

public class Server {
    private DatagramChannel datagramChannel;
    private InetSocketAddress inetSocketAddress;

    public Server() throws IOException {
        datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        inetSocketAddress = new InetSocketAddress("localhost", 1234);
    }

    public String senMessage(Request request) throws IOException {
        String firstLineFromClient = request.getMessage();

        if (firstLineFromClient == null) {
            System.err.println("Request message is null.");
            return "Request message is null.";
        }

        // Serialize the request object to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        objectOutputStream.close();
        byte[] serializedRequest = byteArrayOutputStream.toByteArray();

        // Send serialized data via DatagramChannel
        ByteBuffer byteBuffer = ByteBuffer.wrap(serializedRequest);
        datagramChannel.send(byteBuffer, inetSocketAddress);

        // Prepare to receive response
        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_READ);
        selector.select(3000);

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
        ByteBuffer receiveBuffer = ByteBuffer.allocate(3000);

        while (keyIterator.hasNext()) {
            SelectionKey key = keyIterator.next();
            if (key.isReadable()) {
                receiveBuffer.clear();
                datagramChannel.receive(receiveBuffer);
                receiveBuffer.flip();

                // Deserialize response
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receiveBuffer.array(),
                        receiveBuffer.position(), receiveBuffer.limit() - receiveBuffer.position());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    request = (Request) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    objectInputStream.close();
                }
            }
            keyIterator.remove();
        }

        if (request == null || request.getMessage() == null) {
            return "Server did not send a valid response.";
        }

        // Check if the response matches the initial request
        if (request.getMessage().equals(firstLineFromClient)) {
            return "Server is not available";
        }
        return request.getMessage();
    }

    public void close() throws IOException {
        datagramChannel.close();
    }
}

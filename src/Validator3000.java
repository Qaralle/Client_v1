import packet.CommandA;
import packet.Country;
import packet.WrongTypeOfFieldException;
import sun.nio.ch.DefaultAsynchronousChannelProvider;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Executors;


/**
 * Абстрактный класс, выполняющий функци инвокера
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class Validator3000 implements invoker {

    //private boolean WORK=true;
    static String ACCESS;

    static byte[] finalReceiveData;
    static DatagramSocket clientSocket;

    protected Map<String, String> bufferMap;
    protected String[] bufferStringForArgs;

    {
        ACCESS="DEFAULT";
    }
    @Override
    public void interactiveMod(String del, int port) throws IOException, SocketException, UnknownHostException, InterruptedException {

        clientSocket = new DatagramSocket(port);
        System.out.print(del);
        Thread receiver = new Thread(new Receiver());
        Thread Sanders = new Thread(new Sender());
        synchronized (ACCESS) {
            receiver.start();
            Sanders.start();
            Sanders.join();
        }
    }





}

import java.io.*;
import java.net.*;
import java.util.Map;


/**
 * Абстрактный класс, выполняющий функци инвокера
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class Validator3000 implements invoker {

    public Validator3000(OnExitThread thread){
        this.thread=thread;
    }
    //private boolean WORK=true;
    static String ACCESS;

    static byte[] finalReceiveData;
    static DatagramSocket clientSocket;
    OnExitThread thread;
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
        Thread Sanders = new Thread(new Sender(thread));
        synchronized (ACCESS) {
            receiver.start();
            Sanders.start();
            Sanders.join();
        }
    }





}

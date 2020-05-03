import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketTimeoutException;
import java.util.Optional;

public class Sender implements Runnable {
    private String string_to_print;
    byte[] receiveData = new byte[4*1024];

    @Override
    public void run() {
        while (true) {
            try {
                getSmth();
                System.out.print(string_to_print);
            } catch (IOException sex) {

            }
        }
    }
    private void getSmth() throws IOException {
        string_to_print="stroka kotoryy ti nikogda ne bydesh ispolzovat" ;
        Validator3000.clientSocket.setSoTimeout(5000);
        DatagramPacket pack = new DatagramPacket(receiveData,receiveData.length);
        Validator3000.clientSocket.receive(pack);
        int size = pack.getLength();
        Validator3000.finalReceiveData = new byte[size];
        for (int i = 0; i < size; ++i){
            Validator3000.finalReceiveData[i] = receiveData[i];
        }

        string_to_print= new String(Validator3000.finalReceiveData);


        if (string_to_print.indexOf("&") != -1){
            Validator3000.ACCESS= Optional.ofNullable(string_to_print.split("&",2)[1])
                    .filter(str -> str.length() != 0)
                    .map(str -> str.substring(0, str.length() - 1))
                    .orElse(string_to_print.split("&",2)[1]);


        }
        //return new String(finalReceiveData);

    }
}

import java.net.SocketException;

public class ClientMain
{
    public static void main(String args[]) throws Exception
    {

        Validator3000 terminal = new Validator3000();
        try {
            System.out.println(args[0]);
            terminal.interactiveMod("$", Integer.valueOf(args[0]));
        }catch (Exception ex){
            terminal.interactiveMod("$", 12345);
        }

/*        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));*/

        String str = null;
        String str2 = str;

    }
}
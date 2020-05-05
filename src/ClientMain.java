import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Основной класс, реализующий работу клиентского приложения
 */
public class ClientMain {
    /**
     * Запуск приложения
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        OnExitThread onExitThread = new OnExitThread();
        Runtime.getRuntime().addShutdownHook(onExitThread);
        Validator3000 terminal = new Validator3000(onExitThread);
        try {
            //System.out.println(args[0]);
            terminal.interactiveMod("$", Integer.valueOf(args[0]));
        }catch (Exception arex){
            //terminal.interactiveMod("$",12345);
            System.out.println("Пожалуйста, введите другой номер порта");
            while (true) {
                try {
                    System.out.print("$");
                    String sb = scanner.nextLine();
                    if (!sb.equals("")){
                        terminal.interactiveMod("$",Integer.parseInt(sb));
                        break;
                    }
                } catch (Exception ex) {
                    System.out.println("Пожалуйста, введите другой номер порта");
                }
            }
        }

    }
}
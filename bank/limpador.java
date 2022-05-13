package bank;
import java.io.IOException;
//import java.util.Scanner;
public class limpador {
    public static void limpa() throws IOException, InterruptedException {
        System.out.println("Pressione Enter para continuar...");
        System.in.read();
        // System.out.println(System.getProperty("os.name"));
        
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{    
                // Runtime.getRuntime().exec("clear");
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}

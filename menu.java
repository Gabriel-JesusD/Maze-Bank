
import bank.banco;
import bank.limpador;
import java.io.IOException;
import java.util.*;

public class menu {
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        banco meu_banco = new banco();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("=============MAZE BANK=============\nSelecione uma opcao");
            System.out.println(
                    "(1) Criar conta\n(2) Saque\n(3) Deposito\n(4) Usar credito\n(5) Alterar limite\n(6) Ver extrato\n(0) Sair\n");
            int op;
            try{
                op = scan.nextInt();
            }
            catch(Exception e){
                op = -1;
            }
            
            if (op < 0 || op > 6) {
                System.out.println("Operacao invalida, somente numeros de 0 a 6 sao aceitos");
                limpador.limpa();
                scan.nextLine();
                continue;
            }

            if (op == 0) {
                System.out.println("Obrigado, volte sempre!");
                break;
            } else if (op == 1) {
                meu_banco.criar_conta();
                System.out.printf("Conta de numero %d criada com sucesso\n", meu_banco.ultima_conta_criada());
                limpador.limpa();    
            } else if(meu_banco.existe_conta()){
                meu_banco.adm(op,scan);
                
            }
            else{
                limpador.limpa();
            }
            

        }
        scan.close();
    }
}

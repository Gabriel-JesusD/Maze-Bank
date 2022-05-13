package bank;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class banco {
    private int conta_atual = 0;
    ArrayList<conta> CONTAS = new ArrayList<conta>();
    public boolean existe_conta(){
        if(CONTAS.size() > 0) return true;
        System.out.println("Nao e possivel realizar tal operacao por falta de contas no banco");
        return false;
    }
    public int ultima_conta_criada(){
        return conta_atual-1;
    }
    public boolean conta_valida(int i){
        if(i < 0 || i >= CONTAS.size()){
            System.out.println("Conta nao existente :( , tente novamente"); 
            return false;
        }
        return true;
    }
    public String extrato(int i){
        return CONTAS.get(i).dados();
    }
    public void criar_conta(){
        conta aux = new conta(conta_atual++);
        CONTAS.add(aux);
    }
    public String admInterface(int id_conta, int op,double valor_op){
        String resposta = "a";
        if(op == 5){
            this.CONTAS.get(id_conta).alterar_limite((int)valor_op);
            resposta = "Limite alterado para R$ " + valor_op + "0";
        }
        else if(op == 6){
            resposta = this.extrato(id_conta);
        }
        else{
            switch(op){
                case 2:
                resposta = this.CONTAS.get(id_conta).saque(valor_op);
                break;
                case 3:
                resposta = this.CONTAS.get(id_conta).deposito(valor_op);
                break;
                case 4:
                resposta = this.CONTAS.get(id_conta).credito(valor_op);
                break;
            }
        }
        return resposta;
    }
    public void adm(int op, Scanner scan) throws IOException,InterruptedException{
        while(true){
            System.out.printf("\n\nDigite o numero da conta: ");
            int num_conta = scan.nextInt();
            if(conta_valida(num_conta)){
                int novo_lim;
                if(op == 5) {
                    System.out.printf("\n\nDigite o valor do novo limite: ");
                    novo_lim = scan.nextInt();
                    this.CONTAS.get(num_conta).alterar_limite(novo_lim);
                }
                else if(op == 6)
                    this.extrato(num_conta);
        
                if(op >= 5){
                    limpador.limpa();
                    scan.nextLine();
                    return;
                }
                System.out.printf("\n\nDigite o valor da operacao: ");
                double val;
                val = scan.nextDouble();
                
                switch(op){
                    case 2:
                    this.CONTAS.get(num_conta).saque(val);
                    break;
                    case 3:
                    this.CONTAS.get(num_conta).deposito(val);
                    break;
                    case 4:
                    this.CONTAS.get(num_conta).credito(val);
                    break;
                }
                limpador.limpa();
                scan.nextLine();
                return;
            }

        }
        
    }

}

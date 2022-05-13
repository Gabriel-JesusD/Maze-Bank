package bank;

public class conta {
    private int numero_conta;
    private double saldo = 0;
    private double credito = 0;
    private int lim = 100;
    
    conta(int num){
        this.numero_conta = num;
    }
    public String dados(){
        System.out.printf("Conta numero %d\nSaldo de R$ %.2f\nCredito disponivel de R$ %.2f\nLimite atual de R$ %d.00\n",numero_conta,saldo,credito,lim);
        return "<html>Conta n\u00famero " + numero_conta + "<br/>Saldo de R$ " + saldo + "0<br/>Cr\u00e9dito dispon\u00edvel de R$ " + credito +"0<br/>Limite atual de R$ " + lim + ".00</html>" ;
    }

    public String deposito(double val){
        credito += val;
        if(credito > 0){
            saldo += credito;
            credito -= credito;
        }
        System.out.printf("R$ %.2f depositados com sucesso!\n", val);
        return "<html>R$ " + val + "0 depositados com sucesso!";
    }
    public String saque(double val){
        if(saldo - val >= 0){
            saldo -= val;
            System.out.println("Saque realizado com sucesso!");
            return "Saque realizado com sucesso!";
        }
        System.out.printf("Nao foi possivel realizar o saque\nSaldo disponivel de R$ %.2f\n", saldo);
        return "<html> N\u00e3o foi poss\u00edvel realizar o saque<br/>Saldo dispon\u00edvel de R$ " + saldo +"0</html>";
    }
    public String credito(double val){
        if(credito - val < -lim){
            System.out.println("Tu ta pobre nao deu :(");
            return "<html>Tu t\u00e1 pobre n\u00e3o deu :(</html>";
        }
        credito -= val;
        System.out.println("Boa, passou no credito!");
        return "<html>Boa, passou no cr\u00e9dito!</html>";
    }
    public void alterar_limite(int novo_lim){
        lim = novo_lim;
    }
}

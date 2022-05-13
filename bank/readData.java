package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import bank.banco;
import bank.limpador;
import java.io.IOException;
import java.util.*;


public class readData extends JFrame implements ActionListener,KeyListener{
    
    Font f = new Font("Roboto",Font.PLAIN,30);
    Font g = f.deriveFont(Font.ITALIC); 
    JLabel[] title = {new JLabel("Num Conta:"), new JLabel("Conta invalida, tente novamente!")/*,new JLabel("Conta nao existente, tente novamente!")*/, 
    new JLabel("<html>Nao e possivel realizar tal operacao por:<br/>falta de contas no banco</html>"),new JLabel()};
    JTextField entrada = new JTextField(10);
    JButton confirm = new JButton("Confirmar");
    banco meu_banco;
    String inp = "a";
    int conta, count = 0, operation;
    double valor;
   
    public void windowClosing(WindowEvent e){
        dispose();
    }
    public void actionPerformed(ActionEvent e){
        
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
    public void error(int i){
        /*title[(i+1)%3==0?1:2].setVisible(false);
        title[i].setVisible(true);*/
        String[] auxiliar = {"<html>Conta inv\u00e1lida, tente novamente!</html>","<html>Conta inexistente, tente novamente!</html>","<html>Valor inv\u00e1lido, tente novamente!</html>","<html>Valor inexistente, tente novamente!</html>"};
        title[1].setText(auxiliar[i]);
        title[1].setVisible(true);
        entrada.setText("");
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            inp = entrada.getText();
            if(count == 0){
                try{
                    conta = Integer.parseInt(inp);
                    if(!meu_banco.conta_valida(conta)){
                        error(0);
                    }
                    else if(operation == 6){
                        entrada.setVisible(false);
                        title[0].setVisible(false);
                        title[1].setVisible(false);
                        definition(2, new Rectangle(100,100,600,300), f);
                        title[2].setText(meu_banco.admInterface(conta, operation, 0));
                        title[2].setVisible(true);
                    }
                    else{
                        title[0].setText("<html>Valor: R$</html>");
                        entrada.setText("");
                        count++;
                        for(int i = 1; i < title.length; i++) title[i].setVisible(false);
                    }
                }
                catch(Exception qualquer){
                    error(1);
                }
            }
            else{
                try{
                    valor = Double.parseDouble(inp);
                    String resposta = meu_banco.admInterface(conta, operation, valor);
                    entrada.setVisible(false);
                    for(int i = 0; i < title.length; i++) title[i].setVisible(false);
                    title[2].setText(resposta);
                    title[2].setVisible(true);
                }
                catch(Exception qualquer){
                    error(3);
                }
            }
        }
    }
    public void definition(int i , Rectangle r, Font a){
        if(i == title.length){
            entrada.setBounds(r);
            entrada.setFont(a);
            return;
        }
        title[i].setBounds(r);
        title[i].setFont(a);

    }
    public readData(String op, banco b, int num_op){
        operation = num_op;
        meu_banco = b;
        setLayout(null);
        title[0].setFont(f);
        entrada.addKeyListener(this);
        definition(title.length, new Rectangle(320,200,80,50),   f);
        definition(0, new Rectangle(100,200,200,50),  f);
        definition(1, new Rectangle(100,270,500,50),  g);
        //definition(2, new Rectangle(100,270,500,50),  g);
        definition(2, new Rectangle(100,200,600,100), f);
        definition(3, new Rectangle(100,200,600,100), f);
       // definition(5, new Rectangle(100,200,200,50),  f);
        for(int i = 0; i < title.length; i++){
            add(title[i]);
            title[i].setVisible(false);
        }

        //add(title[3]);
        if(op.equals("Criar conta")){
            //title[3].setVisible(false);
            meu_banco.criar_conta();
            title[3].setText("Conta de numero "+ meu_banco.ultima_conta_criada()+" criada com sucesso");
            title[3].setVisible(true);
            //add(title[4]);
        } else if(meu_banco.existe_conta()){
            /*add(title[0]);
            add(title[1]);
            add(title[2]);*/
            // if(num_op == 6){
            //     definition(2, new Rectangle(100,100,600,300), f);
            //     title[2].setText(meu_banco.admInterface(0, num_op, 0));
            //     title[2].setVisible(true);
            // } else{
                title[0].setVisible(true);
                add(entrada);
            // }
            
            /*for(int i = 1; i <= 3; i++)
            title[i].setVisible(false);*/
        }
        else{
            title[2].setVisible(true);
        }
  
        setTitle(op);
        setSize(720,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

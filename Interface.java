
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import bank.*;
import java.io.IOException;
import java.util.*;
 

public class Interface extends JFrame implements ActionListener{
    JButton[] buttons = new JButton[7];
    String[] names = {"Criar conta", "Saque","Deposito", "Usar credito","Alterar limite", "Ver extrato","Sair"};
    Font f = new Font("Roboto",Font.BOLD,80); 
    JLabel title = new JLabel("MAZE BANK");
    banco meu_banco = new banco();


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttons[6]){ 
            System.exit(0);
        }
        else{
            String aux = "as"; 
            int operation = -1;
            for(int i = 0; i < 6; i++){
                if(e.getSource() == buttons[i]){
                    operation = i+1;
                    aux = buttons[i].getText();
                }
            }
            System.out.println(operation);
           new readData(aux, meu_banco,operation);

        }
        
    }

    public Interface(){
        setLayout(null);
        title.setBounds(110,80,500,100);
        title.setFont(f);
        add(title);
        int cont = 0;
        int x = 67,y = 250;
        for(int i = 0; i <= 6; i++){
            if(cont == 2){
                y = 250;
                x += 210;
                cont = 0;
            }
            if(i == 6){
                x = 277;
                y = 410;
            }
            buttons[i] = new JButton(names[i]);
            buttons[i].setBounds(x,y,150,60);
            buttons[i].addActionListener(this);
            add(buttons[i]);
            y += 80;
            cont++;
        }
        
        setTitle("menu");
        setSize(720,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new Interface();
    }    
}

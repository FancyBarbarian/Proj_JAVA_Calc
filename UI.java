import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI{
     static UI var = null;
     long ans = 0;
     JButton [] keys = null;
     JFrame window = null;
     JLabel input = null;
     JPanel textpanel = null;
     JPanel keyPad = null;
     
     UI(){
        window = new JFrame("Calculator");
        window.setSize(400,600);
        keys = new JButton[16];
        String [] keyStrs = {"1","2","3","c","4","5","6","*","7","8","9","-",".","0","=","+"};
        input = new JLabel("0");
        input.setFont(new Font("Arial",Font.PLAIN,50));
        keyPad = new JPanel();
        keyPad.setLayout(new GridLayout(4,4));
        for(int i = 0 ; i < 16 ; ++i){
            keys[i] = new JButton(keyStrs[i]);
            keys[i].setFont(new Font("Arial",Font.PLAIN,50));
            keys[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JButton b = (JButton)e.getSource();
                    String text = b.getText();
                    String expr = input.getText();
                    if(expr == "0")
                        expr = "";
                    if(text.charAt(text.length() - 1) == 'c'){
                        input.setText("0");
                    }
                    else if(text.charAt(text.length() - 1) == '=')
                        input.setText(expr + "\nAns: "+new Calculator().evaluate(expr));
                    else 
                        input.setText(expr + text);
                }
            });
            keyPad.add(keys[i]);
            //System.out.println(keys[i].getText());
        }
        textpanel = new JPanel();
        textpanel.setPreferredSize(new Dimension(400,100));
        keyPad.setPreferredSize(new Dimension(400,500));
        textpanel.add(input);
        window.setLayout(new BorderLayout());
        window.add(textpanel,BorderLayout.NORTH);
        window.add(keyPad,BorderLayout.SOUTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
    public static  UI getUI(){
        if(var == null)
            var = new UI();   
        return var;
    }
}

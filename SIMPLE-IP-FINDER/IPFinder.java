import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
class IPFinder extends JFrame implements ActionListener{
    String h;
    JTextField textfield;
    JLabel label;
    JButton button;
    IPFinder(){
        textfield = new JTextField();
        textfield.setBounds(50,50,200,20);
        add(textfield);
        label = new JLabel();
        label.setBounds(50,100,300,20);
        add(label);
        button = new JButton("Find IP");
        button.setBounds(50, 150, 90, 30);
        button.addActionListener(this);
        add(button);
        setLayout(null);
        setSize(400,400);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try{
        h = textfield.getText();
        String IP = InetAddress.getByName(h).getHostAddress();
        label.setText("IP of "+h+" is "+IP);
        }
        catch(Exception ex){
            label.setText("IP of "+h+" is Unknown");
            System.out.print(ex);
        }
    }
    public static void main(String args[]){
        new IPFinder();
    }
}
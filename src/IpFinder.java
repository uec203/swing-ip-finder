import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import javax.swing.*;

/*
 * IpFinder class Represents the user interface(UI) of the Application
 * 
 * It extends JFrame for window management and implements ActionListener 
 * to handle user input and actions within the interface 
 */

class IpFinder extends JFrame implements ActionListener {

    // JTextField for user input the domain name, used to resolve it to its corresponding IP address
    JTextField textfield = new JTextField();
    
    // JLabel to provide description for domain name input
    JLabel domainLabel = new JLabel("Enter Domain Name:");

    // JLabel to display the corresponding IP address for the given domain name
    JLabel outputlabel = new JLabel();

    // JButton to trigger the process of finding the corresponding IP address
    JButton button = new JButton("Find IP");

    // Constructor to initialize the IpFinder UI, sets the layout, and configures the window size and visiblity
    IpFinder() {

        initializeUICompenents();

        // Set the title of the frame
        setTitle("IP Finder Application");

        setLayout(null);
        setSize(400, 400);
        setVisible(true);
    }

    // Initializes and positions the UI components (textfield, label, and button) on the frame
    private void initializeUICompenents(){

        domainLabel.setBounds(50, 30, 200, 20);
        add(domainLabel);
        textfield.setBounds(50, 60, 200, 20);
        add(textfield);

        outputlabel.setBounds(50, 100, 300, 20);
        add(outputlabel);

        button.setBounds(50, 150, 90, 30);
        button.addActionListener(this);
        add(button);
    }
    
    // Handles the action Event when user  clicks the "Find IP" button.
    // Resolves the domain name entered in the textfield to its corresponding IP address and displays it in the label.
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String input = textfield.getText(); // Get the domain name entered by the user

            String Ip = InetAddress.getByName(input).getHostAddress(); // Resolve domain name to its IP address
            outputlabel.setText("IP Address of " + input + " is " + Ip); // Display the IP address in the label
        } catch (Exception ex) {

            outputlabel.setText("An error occured and please retry again"); // Show error message if domain resolution fails
        }
    }
    
    // Main method to launch the IP Finder application
    public static void main(String args[]) {
        new IpFinder(); // Instantiate IpFinder to initialize the window and set up the UI components
    }
}

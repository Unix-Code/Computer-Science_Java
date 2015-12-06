import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class SwingJPanelDemo extends Frame implements ActionListener {

    private JLabel labelUsername = new JLabel("Enter username: ");
    private JLabel labelPassword = new JLabel("Enter password: ");

    private JTextField textUsername = new JTextField(20);
    private JPasswordField fieldPassword = new JPasswordField(20);
    private JButton buttonLogin = new JButton("Login");

    public SwingJPanelDemo() {
        setTitle("User Login");

        addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we)
                {
                    System.exit(0);
                }
            });
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(labelUsername, constraints);

        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);

        constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
        buttonLogin.addActionListener(this);
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent e) {
        if (!(textUsername.getText().equals("")) && fieldPassword.getPassword().length != 0) {
            setVisible(false);
            Window2 newWindow = new Window2();
            newWindow.loginText(textUsername.getText() + " Logged In");
        }
    }

    public static void main(String[] args) {
        SwingJPanelDemo frame = new SwingJPanelDemo();
        frame.setVisible(true);
    }
}
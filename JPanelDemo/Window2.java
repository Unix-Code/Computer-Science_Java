import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Window2 extends Frame {
    private JLabel status = new JLabel();

    public Window2() {
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
        constraints.insets = new Insets(10, 10, 10, 10);
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridy = 2;
        newPanel.add(status, constraints);

        add(newPanel);

        pack();
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void loginText(String text) {
        status.setFont(new Font("Verdana", Font.PLAIN, 30));

        status.setText(text);
    }

}
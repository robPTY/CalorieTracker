import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void initialize(User user) {
        //Panel that contains all the user details in DB
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(0, 2, 5, 5));
        userPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        userPanel.add(new JLabel("Name"));
        userPanel.add(new JLabel(user.name));
        userPanel.add(new JLabel("Email"));
        userPanel.add(new JLabel(user.email));
        userPanel.add(new JLabel("Phone"));
        userPanel.add(new JLabel(user.phone));
        userPanel.add(new JLabel("Address"));
        userPanel.add(new JLabel(user.address));
        //Set the font for all the labels the same
        Component[] labels = userPanel.getComponents();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("Tunga", Font.BOLD, 16));
        }
        add(userPanel, BorderLayout.NORTH);
        
        //Add buttons
        
        //Add Images
        
        //Add Food Item
        
        //Set customization of the frame
        setTitle("Calorie Tracker");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

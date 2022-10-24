import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class MainFrame extends JFrame {
    private JPanel left, main;
    public void initialize(User user) {
        JLabel TT = new JLabel("Calorie Tracker - EST. 2022", SwingConstants.CENTER);
        TT.setForeground(Color.white);

        left = new JPanel();
        left.setLayout(new GridLayout(1,4,10,10));

        JPanel sl1 = new JPanel();
        sl1.setBorder(new LineBorder(Color.WHITE,1));
        left.add(sl1);


        JPanel sl2 = new JPanel();
        sl2.setBorder(new LineBorder(Color.WHITE,1));
        left.add(sl2);

        JPanel sl3 = new JPanel();
        sl3.setBorder(new LineBorder(Color.WHITE,1));
        left.add(sl3);

        //Create labels
        JLabel FL = new JLabel("LOG FOOD", SwingConstants.CENTER);
        FL.setForeground(Color.white);
        sl1.add(FL);
       
        JLabel WL = new JLabel("LOG WORKOUT", SwingConstants.CENTER);
        WL.setForeground(Color.white);
        sl2.add(WL);
       
        JLabel PL = new JLabel("PROFILE INFO", SwingConstants.CENTER);
        PL.setForeground(Color.white);
        sl3.add(PL);

        //Create buttons 
        JButton FLB = new JButton("Add Food");
        //FLB.add(sl1);

        main =new JPanel();
        main.setLayout(new BorderLayout());
        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.add(TT);
        main.add(left, BorderLayout.CENTER);
        add(main);
        /* 
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(0, 3, 5, 5));
        EmptyBorder panelBorder = new EmptyBorder(10, 60, 10, 60);
        userPanel.setBorder(panelBorder);
        //userPanel.setBackground(Color.white);

        */
        /* 
        userPanel.add(new JLabel("Name"));
        userPanel.add(new JLabel(user.name));
        userPanel.add(new JLabel("Email"));
        userPanel.add(new JLabel(user.email));
        userPanel.add(new JLabel("Phone"));
        userPanel.add(new JLabel(user.phone));
        userPanel.add(new JLabel("Address"));
        userPanel.add(new JLabel(user.address));
        */
        //Set the font for all the labels the same
        FL.setFont(new Font("Tunga", Font.BOLD, 32));
        WL.setFont(new Font("Tunga", Font.BOLD, 32));
        PL.setFont(new Font("Tunga", Font.BOLD, 32));

        //Set customization of the frame
        setTitle("Calorie Tracker");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}

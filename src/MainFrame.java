import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent; //Needed for buttons
import java.awt.event.ActionListener; //Needed for buttons
public class MainFrame extends JFrame {
    private JPanel left, main;
    Color myColor1 = new Color(57, 119, 93); //green
    Color myColor2 = new Color(122, 143, 217); //green
    public void initialize(User user) {
        JLabel TT = new JLabel("Calorie Tracker - EST. 2022", SwingConstants.CENTER);
        TT.setForeground(Color.white);

        left = new JPanel();
        left.setLayout(new GridLayout(1,4,10,10));

        JPanel sl1 = new JPanel();
        //sl1.setLayout(new GridLayout(6,1,10,10));
        sl1.setBorder(new LineBorder(Color.BLACK,2));
        sl1.setBackground(myColor1);
        left.add(sl1);

        JPanel sl2 = new JPanel();
        sl2.setBorder(new LineBorder(Color.BLACK,2));
        sl2.setBackground(myColor1);
        left.add(sl2);

        JPanel sl3 = new JPanel();
        sl3.setBorder(new LineBorder(Color.WHITE,1));
        left.add(sl3);

        //Create labels
        JLabel FL = new JLabel("LOG CALORIES", SwingConstants.CENTER);
        FL.setForeground(Color.white);
        sl1.add(FL);
       
        JLabel WL = new JLabel("LOG WORKOUT", SwingConstants.CENTER);
        WL.setForeground(Color.white);
        sl2.add(WL);
       
        JLabel PL = new JLabel("PROFILE INFO", SwingConstants.CENTER);
        PL.setForeground(Color.white);
        sl3.setBackground(myColor1);
        sl3.setBorder(new LineBorder(Color.BLACK, 2));
        sl3.add(PL);

        //Add images
        JLabel img1 = new JLabel();
        ImageIcon imgThisImg = new ImageIcon("C:/Users/rcagu/Desktop/Java Projects/LogInForm/src/Images/food2.png");
        img1.setIcon(imgThisImg);
        img1.setPreferredSize(new Dimension(500,400));
        
        JLabel img2 = new JLabel();
        ImageIcon imgThisImg2 = new ImageIcon("C:/Users/rcagu/Desktop/Java Projects/LogInForm/src/Images/workout12.png");
        img2.setIcon(imgThisImg2);
        img2.setPreferredSize(new Dimension(500,400));

        //Create buttons 
        JButton FLB = new JButton("  Add Food  ");
        FLB.setBackground(Color.white);
        FLB.setForeground(Color.black);
        FLB.setBorder(new LineBorder(Color.BLACK, 2));
        //FLB.setPreferredSize(new Dimension(30,80));
        sl1.add(img1, JLabel.CENTER_ALIGNMENT);
        sl1.add(FLB);
        sl2.add(img2);
        FLB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FoodLog fl = new FoodLog();
                fl.initialize();
                dispose();
            }
        });

        JButton WLB = new JButton("  Add Workout  ");
        WLB.setBackground(Color.white);
        WLB.setForeground(Color.black);
        WLB.setBorder(new LineBorder(Color.BLACK, 2));
        sl2.add(WLB);
        WLB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Workout w1 = new Workout();
                w1.initialize();
                dispose();
            }
        });

        JButton PFB = new JButton("  Profile Info.  ");
        PFB.setBackground(Color.white);
        PFB.setForeground(Color.black);
        PFB.setBorder(new LineBorder(Color.BLACK, 2));
        PFB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile p1 = new Profile();
                p1.initialize();
                dispose();
            }
        });
        sl3.add(PFB);

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
        WLB.setFont(new Font("Tunga", Font.BOLD, 16));
        PFB.setFont(new Font("Tunga", Font.BOLD, 16));
        FLB.setFont(new Font("Tunga", Font.BOLD, 16));
        FL.setFont(new Font("Tunga", Font.BOLD, 32));
        WL.setFont(new Font("Tunga", Font.BOLD, 32));
        PL.setFont(new Font("Tunga", Font.BOLD, 32));

        //Set customization of the frame
        setTitle("Calorie Tracker");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        //setResizable(false);
    }
}

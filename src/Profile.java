import java.awt.*;
import java.sql.*; //Connect to Database for user logIn
import javax.swing.*;
import java.awt.Color;
//import java.awt.event.*;
//import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.border.*;
import java.awt.event.ActionEvent; //Needed for buttons
import java.awt.event.ActionListener; //Needed for buttons
public class Profile extends JFrame{
    final private Font programFont = new Font("Tunga", Font.BOLD, 16);
    final private Font programFont2 = new Font("Tunga", Font.BOLD, 28);
    Color myColor1 = new Color(57, 119, 93); //green
    public void initialize(){
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(Color.BLACK, 2));
        //leftPanel.setLayout(new GridLayout(5,1,10,10));
        leftPanel.setBackground(myColor1);

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        rightPanel.setBackground(myColor1);

        infoPanel.add(leftPanel);
        infoPanel.add(rightPanel);

        JLabel lb1 = new JLabel();

        JLabel img1 = new JLabel();
        ImageIcon imgThisImg = new ImageIcon("C:/Users/rcagu/Desktop/Java Projects/LogInForm/src/Images/Add Profile Pic Here1.png");
        img1.setIcon(imgThisImg);
        img1.setPreferredSize(new Dimension(480,400));

        JButton but1 = new JButton(" Add Profile Picture ");
        but1.setPreferredSize(new Dimension(200, 50));
        but1.setBorder(new LineBorder(Color.BLACK, 2));
        but1.setFont(programFont);
        but1.setBackground(Color.WHITE);
        but1.setForeground(Color.BLACK);

        JButton but2 = new JButton("Return home");
        but2.setBorder(new LineBorder(Color.BLACK,2));
        but2.setFont(programFont2);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame m1 = new MainFrame();
                User user = new User();
                m1.initialize(user);
                dispose();
            }
        });

        rightPanel.add(but2);

        JLabel nameLB = new JLabel(getUserName(), SwingConstants.CENTER);
        nameLB.setFont(programFont2);

        JLabel accLevel = new JLabel("Rookie | ", SwingConstants.CENTER);
        accLevel.setFont(programFont2);

        //leftPanel.add(lb1);
        leftPanel.add(img1, SwingConstants.CENTER);
        leftPanel.add(but1);
        leftPanel.add(nameLB, SwingConstants.CENTER);
        leftPanel.add(accLevel, SwingConstants.CENTER);

        add(infoPanel);
        setTitle("Calorie++: Profile Information");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private String getUserName(){
        User user = null;
        //Connect to Database
        final String DB_URL = "jdbc:mysql://localhost/calorieTracker?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //Creates connection between program and database
            // Connected to database successfully...

            String sql = "SELECT name FROM users";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { //Here the values for the Module User.JAVA are being taken from the Database
                user = new User();
                user.name = resultSet.getString("name");
                //System.out.println(user.name);
            }
            preparedStatement.close();
            conn.close();
        }catch(Exception e){
            System.out.println("Database connexion failed!");
        }

        return user.name;
    }
}

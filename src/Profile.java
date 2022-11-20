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
    final private Font programFont = new Font("Tunga", Font.BOLD, 28);
    Color myColor1 = new Color(57, 119, 93); //green
    public void initialize(){
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 3, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(10, 1, 10, 10));
        leftPanel.setBackground(myColor1);

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(3, 1, 10, 10));
        //midPanel.setBackground(myColor1);

        JLabel nameLB = new JLabel(getUserName(), SwingConstants.CENTER);
        nameLB.setFont(programFont);

        JLabel accLevel = new JLabel("Rookie", SwingConstants.CENTER);
        accLevel.setFont(programFont);

        for(int i = 0; i < 5; i++){
            JLabel blank = new JLabel("");
            leftPanel.add(blank);
        }

        infoPanel.add(leftPanel);
        infoPanel.add(midPanel);

        leftPanel.add(nameLB);
        leftPanel.add(accLevel);

        add(infoPanel);
        setTitle("Calorie Tracker: Profile Information");
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


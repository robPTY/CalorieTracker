import javax.swing.*;
import java.awt.*;
import java.sql.*; //Connect to Database for user registration
import java.awt.event.ActionEvent; //Needed for buttons
import java.awt.event.ActionListener; //Needed for buttons
public class Register extends JFrame {
    final private Font programFont = new Font("Tunga", Font.BOLD, 18);
    JTextField IDTF, NMTF, EMTF, PHTF, ADTF;
    JPasswordField PWF;
    public void RegisterInfo(){
        JLabel titleLabel = new JLabel("Please Enter Details For Registration:", SwingConstants.CENTER);
        titleLabel.setFont(programFont);

        //ID Label
        JLabel IDLB = new JLabel("User ID:", SwingConstants.CENTER);
        IDLB.setFont(programFont);
        IDTF = new JTextField();
        IDTF.setFont(programFont);

        //Name Label
        JLabel nameLB = new JLabel("Name & Last Name:", SwingConstants.CENTER);
        nameLB.setFont(programFont);
        NMTF = new JTextField();
        NMTF.setFont(programFont);

        //Email label
        JLabel EMLB = new JLabel("Email: ", SwingConstants.CENTER);
        EMLB.setFont(programFont);
        EMTF = new JTextField();
        EMTF.setFont(programFont);

        //Phone label
        JLabel PHLB = new JLabel("Phone Number:", SwingConstants.CENTER);
        PHLB.setFont(programFont);
        PHTF = new JTextField();
        PHTF.setFont(programFont);

        //Address label
        JLabel ADLB = new JLabel("Address (City, State): ", SwingConstants.CENTER);
        ADLB.setFont(programFont);
        ADTF = new JTextField();
        ADTF.setFont(programFont);
        //Password label
        JLabel PWLB = new JLabel("Password:", SwingConstants.CENTER);
        PWLB.setFont(programFont);
        PWF = new JPasswordField();
        PWF.setFont(programFont);

        JPanel regPanel = new JPanel();
        regPanel.setLayout(new GridLayout(0, 1, 10, 1));
        regPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        regPanel.add(titleLabel);
        regPanel.add(IDLB);
        regPanel.add(IDTF);
        regPanel.add(nameLB);
        regPanel.add(NMTF);
        regPanel.add(EMLB);
        regPanel.add(EMTF);
        regPanel.add(PHLB);
        regPanel.add(PHTF);
        regPanel.add(ADLB);
        regPanel.add(ADTF);
        regPanel.add(PWLB);
        regPanel.add(PWF);
        add(regPanel, BorderLayout.NORTH);

        //Create registration button
        JButton regButt = new JButton("Finish Registration");
        regButt.setFont(programFont);
        //Here is the action of the button
        regButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Gets all user information from form
                String userID = IDTF.getText();
                String nameLb = NMTF.getText();
                String email = EMTF.getText();
                String phone = PHTF.getText();
                String address = ADTF.getText();
                String password = String.valueOf(PWF.getPassword());
                User user = getRegistered(userID, nameLb, email, phone, address, password); //checks if the user is registered
                /* 
                if (user != null) //If user is registered in database, go to application
                {
                    GUI gui = new GUI();
                    gui.initialize();
                    dispose();
                }
                else //If not registered, display error mesage
                {
                    JOptionPane.showMessageDialog(Register.this,
                            "Registration failed",
                            "Please Try Again",
                            JOptionPane.ERROR_MESSAGE);
                }
                */
                JOptionPane.showMessageDialog(Register.this, "Registration Successful", "Proceed to Log In", JOptionPane.INFORMATION_MESSAGE);
                GUI gui = new GUI();
                gui.initialize();
                dispose();
            }
        });
        

        //Creation of panel for the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(regButt);

        add(buttonsPanel, BorderLayout.SOUTH);
        //Set customization of the frame
        setTitle("Registration for Calorie Tracker");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(550, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private User getRegistered(String userID, String name, String email, String phone, String address, String password){
        //Use all information to put the user into  database. 
        //After registration, if the user is in the database, go back to login page.
        User user = null;
        //Connect to Database
        final String DB_URL = "jdbc:mysql://localhost/calorieTracker?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //Creates connection between program and database
            // Connected to database successfully...
            //System.out.println("Connected.");
            String sql = "INSERT INTO users (id, name, email, phone, address, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate();

            /* 
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { //Here the values for the Module User.JAVA are being taken from the Database
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }
            */
            preparedStatement.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("Database connexion failed!");
        }
        return user;
    }
}

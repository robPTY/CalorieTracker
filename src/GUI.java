import java.awt.*; //Buttons, labels, etc.
import java.awt.event.ActionEvent; //Needed for buttons
import java.awt.event.ActionListener; //Needed for buttons
import java.sql.*; //Connect to Database for user logIn
import javax.swing.*; //GUI technology
import com.formdev.flatlaf.FlatDarculaLaf; //Makes GUI dark mode

public class GUI extends JFrame {
    final private Font programFont = new Font("Tunga", Font.BOLD, 18);
    JTextField emailTF;
    JPasswordField passwPF;
    ImageIcon image;

    public void initialize() {
        //Create labels + textfield for email and password
        JLabel titleLabel = new JLabel("Welcome to Calorie Tracker", SwingConstants.CENTER);
        titleLabel.setFont(programFont);

        //Add app logo to GUI 
        //image = new ImageIcon(getClass().getResource("LogoCalTracker.png"));
        //JLabel displayImage = new JLabel(image);
        //displayImage.setIcon(new ImageIcon(new ImageIcon("LogoCalTracker.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        ImageIcon logo = new ImageIcon("C:/Users/rcagu/Desktop/Java Projects/LogInForm/src/Images/Logo1.png");
        logo.setImage(logo.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        JLabel image = new JLabel(logo);
        //Resize logo

        //Email LB + TF
        JLabel emailLB = new JLabel("Email");
        emailLB.setFont(programFont);
        emailTF = new JTextField();
        emailTF.setFont(programFont);
        //Password LB + TF
        JLabel passwLB = new JLabel("Password");
        passwLB.setFont(programFont);
        passwPF = new JPasswordField();
        passwPF.setFont(programFont);

        //Create panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(titleLabel);
        formPanel.add(image);
        formPanel.add(emailLB);
        formPanel.add(emailTF);
        formPanel.add(passwLB);
        formPanel.add(passwPF);

        //Create buttons and add actions
        JButton logInButt = new JButton("Login");
        logInButt.setFont(programFont);
        logInButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Gets email and password from user input
                String email = emailTF.getText();
                String password = String.valueOf(passwPF.getPassword());
                User user = getAuthenticatedUser(email, password); //checks if the user is registered
                if (user != null) //If user is registered in database, go to application
                {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                }
                else //If not registered, display erroe mesage
                {
                    JOptionPane.showMessageDialog(GUI.this,
                            "Email or Password Invalid",
                            "Please Try Again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //Add button for if user wants to register since they do not have an account
        JButton registerButt = new JButton("Register");
        registerButt.setFont(programFont);
        registerButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Closes GUI
                dispose();
            }
            
        });

        //Creation of panel for the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(logInButt);
        buttonsPanel.add(registerButt);

        //Frame Initialization
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
        //JFrame customization
        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450)); //Change frame size
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    //This method gets the URL for the Database and then checks to see if the user is a registered user
    private User getAuthenticatedUser(String email, String password) {
        User user = null;
        //Connect to Database
        final String DB_URL = "jdbc:mysql://localhost/calorieTracker?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //Creates connection between program and database
            // Connected to database successfully...

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { //Here the values for the Module User.JAVA are being taken from the Database
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }
            preparedStatement.close();
            conn.close();
        }catch(Exception e){
            System.out.println("Database connexion failed!");
        }

        return user;
    }


    public static void main(String[] args) {
        //This makes sure that the GUI is dark mode
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        //Call function to initialize the GUI
        GUI logInForm = new GUI();
        logInForm.initialize();
        
        //Prepare to call register function
    }
}

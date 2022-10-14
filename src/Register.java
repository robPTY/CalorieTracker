import javax.swing.*;
import java.awt.*;
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
    
        //Add Image
        
        //Create registration button

        //Set customization of the frame
        setTitle("Registration for Calorie Tracker");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(550, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

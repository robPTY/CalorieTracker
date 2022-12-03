import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.border.*;
import java.awt.event.ActionEvent; //Needed for buttons
import java.awt.event.ActionListener; //Needed for buttons
import javax.swing.table.DefaultTableModel;
public class Workout extends JFrame {
    int lbX = 1;
    int lbY = 1;
    int dez = 0;
    int tfY = lbY +1;
    int rowNum;
    JPanel main;
    JPanel lower;
    Color myColor1 = new Color(57, 119, 93); //green
    Color myColor2 = new Color(103, 0, 0); //red
    Color myColor3 = new Color(230, 188, 2); //yellow
    Color myColor4 = new Color(255, 159, 24); //orange
    final private Font programFont = new Font("Tunga", Font.BOLD, 18);
    final private Font calFont = new Font("Tunga", Font.BOLD, 64);
    public void initialize(){
        main = new JPanel();
        main.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lower =  new JPanel();
        lower.setBorder(new LineBorder(Color.WHITE, 1));

        //Title Label
        JLabel title = new JLabel("Daily Workout Log", SwingConstants.CENTER);
        title.setFont(programFont);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        main.add(title, c);
        createRow(c);
        rowNum++;
        //Button 
        JButton but1 = new JButton("Add More Workouts?");
        but1.setFont(programFont);
        but1.setBackground(myColor1);
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbX = 1;
                if(rowNum < 6){
                    createRow(c);
                    rowNum++;
                }
            }
        });
        c.gridx = 2;
        c.gridy = 10;
        c.fill = GridBagConstraints.HORIZONTAL;
        main.add(but1, c);

        JButton but3 = new JButton("Calculate Workout Score");
        but3.setFont(programFont);
        //but1.setBackground()
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* 
                CalcScore cs = new CalcScore();
                cs.initialize();
                dispose();
                */
                displayScore();
            }
        });
        c.gridx = 2;
        c.gridy = 11;
        main.add(but3, c);


        JButton but2 = new JButton("Return to home");
        but2.setFont(programFont);
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame m1 = new MainFrame();
                User user = new User();
                m1.initialize(user);
                dispose();
            }
        });
        c.gridx = 2;
        c.gridy = 12;
        c.fill = GridBagConstraints.HORIZONTAL;
        main.add(but2, c);



        //main.add(lower,c);

        add(main);
        //add(lower);
        setTitle("Calorie++: Workout Log");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void createRow(GridBagConstraints c){
        JLabel ex = new JLabel("Excercise:", SwingConstants.LEFT);
        ex.setFont(programFont);
        JTextField extf = new JTextField();
        extf.setBorder(new LineBorder(Color.WHITE, 2));
        extf.setFont(programFont);

        JLabel time = new JLabel("Time:", SwingConstants.CENTER);
        time.setFont(programFont);
        JTextField ttf = new JTextField();
        ttf.setBorder(new LineBorder(Color.WHITE, 2));
        ttf.setFont(programFont);

        JLabel level = new JLabel("Intensity Level:", SwingConstants.CENTER);
        level.setFont(programFont);
        JTextField ltf = new JTextField();
        ltf.setBorder(new LineBorder(Color.WHITE, 2));
        ltf.setFont(programFont);

        c.gridx = lbX;
        c.gridy = lbY;
        main.add(ex, c);
        c.gridx = lbX;
        c.gridy = tfY;

        lbX++;

        main.add(extf, c);
        c.gridx = lbX;
        c.gridy = lbY;
        main.add(time, c);
        c.gridx = lbX;
        c.gridy = tfY;

        lbX++;

        main.add(ttf, c);
        c.gridx = lbX;
        c.gridy = lbY;
        main.add(level, c);
        c.gridx = lbX;
        c.gridy = tfY;
        main.add(ltf, c);      
        
        // 1 2 3 (0, 0, 0)
        // 1 2 3 (1, 1, 1)
        lbY++;
        tfY++;
        System.out.println("Added row.");
        setVisible(true);
    }

    public void displayScore(){
        int score;
        main.setVisible(false);
        JPanel newPan = new JPanel();
        newPan.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
    
        JLabel title2 = new JLabel("Based of your workouts, your Total Workout Score is... ", SwingConstants.CENTER);
        title2.setFont(programFont);
        newPan.add(title2 ,gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        score = 55;
        JLabel calScore = new JLabel("Score: " + score, SwingConstants.CENTER);
        calScore.setFont(calFont);
        if(score < 30){
            calScore.setForeground(myColor2);
        }
        else if(score > 30 && score < 60){
            calScore.setForeground(myColor4);
        }
        else if(score > 60 &&  score < 90){
            calScore.setForeground(myColor3);
        }
        else{
            calScore.setForeground(myColor1);
        }
        newPan.add(calScore, gbc);
        JButton but4 = new JButton("Return");
        but4.setFont(programFont);
        but4.setBackground(myColor1);
        but4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Workout ws1 = new Workout();
                ws1.initialize();
                dispose();
            }
        });
        newPan.add(but4, gbc);


        add(newPan);
    }
}

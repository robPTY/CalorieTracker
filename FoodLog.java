import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.border.*;
import java.awt.event.ActionEvent; //Needed for buttons
import java.awt.event.ActionListener; //Needed for buttons
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
public class FoodLog extends JFrame{
    final private Font programFont = new Font("Tunga", Font.BOLD, 18);
    final private Font calFont = new Font("Tunga", Font.BOLD, 64);
    Color myColor3 = new Color(243, 214, 106); //yellow
    Color myColor1 = new Color(57, 119, 93);
    int totalCals = 0;
    int calGoal = 2000;
    private JPanel main;
    public void initialize(){
        main = new JPanel();
        main.setLayout(new GridLayout(1,2,0,10));

        JPanel sl1 = new JPanel();
        sl1.setLayout(new GridLayout(10,3,10,10));
        sl1.setBorder(new LineBorder(Color.WHITE,1));
        main.add(sl1);

        JPanel sl2 = new JPanel();
        sl2.setLayout(new GridLayout(2,3,10,0));
        sl2.setBorder(new LineBorder(Color.WHITE,1));
        JPanel upper = new JPanel();
        upper.setLayout(new GridLayout(3, 1, 10, 0));
        upper.setBorder(new LineBorder(Color.WHITE,1));

        //Add label to upper
        JLabel title2 = new JLabel("Total Calories:", SwingConstants.CENTER);
        title2.setFont(programFont);
        JLabel calInf = new JLabel(totalCals+ "/"+ calGoal, SwingConstants.CENTER);
        calInf.setFont(calFont);
        calInf.setForeground(myColor1);
        JLabel calMot = new JLabel("You are " + (calGoal - totalCals) + " calories away from your daily goal.", SwingConstants.CENTER);
        calMot.setFont(programFont);
        upper.add(title2);
        upper.add(calInf);
        upper.add(calMot);

        JPanel lower = new JPanel();
        lower.setBorder(new LineBorder(Color.WHITE,1));
        lower.setLayout(new GridLayout(4,1, 5,5));
        sl2.add(upper);
        sl2.add(lower);
        main.add(sl2);

        //Reset to 0:
        JButton reset = new JButton(" Reset Calories ");
        reset.setFont(programFont);
        //reset.setBackground(myColor1);
        //reset.setForeground(Color.white);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalCals = 0;
                calInf.setText(totalCals + "/" + calGoal);
                calInf.setForeground(myColor1);
                calMot.setText("You are " + (calGoal - totalCals) + " calories away from your daily goal.");
            }
        });
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reset.setBackground(myColor1);
                reset.setForeground(Color.white);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset.setBackground(new JButton().getBackground());
                reset.setForeground(Color.WHITE);
            }
        });


        JTextField newCals = new JTextField("New Calorie Goal");
        newCals.setFont(programFont);
        newCals.setHorizontalAlignment(JTextField.CENTER);
        lower.add(newCals);
        newCals.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                newCals.setText("");
            }
        
            public void focusLost(FocusEvent e) {
                // nothing
            }
        });

        JButton changeCals = new JButton(" Change Calories Goal ");
        changeCals.setFont(programFont);
        //changeCals.setBackground(Color.white);
        changeCals.setForeground(Color.WHITE);
        changeCals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeCals.setBackground(myColor1);
                changeCals.setForeground(Color.white);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeCals.setBackground(new JButton().getBackground());
                changeCals.setForeground(Color.WHITE);
            }
        });
        changeCals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int CalNumsNew = Integer.parseInt(newCals.getText());
                calGoal = CalNumsNew;
                calInf.setText(totalCals + "/" + calGoal);
            }
        });
        //changeCals.setBorder(new LineBorder(Color.BLACK, 2));
        lower.add(changeCals);
        lower.add(reset);

        //Add button to lower
        JButton getBack = new JButton(" Return to home ");
        getBack.setFont(programFont);
        getBack.setForeground(Color.WHITE);
        getBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame m1 = new MainFrame();
                User user = new User();
                m1.initialize(user);
                dispose();
            }
        });
        getBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                getBack.setBackground(myColor1);
                getBack.setForeground(Color.white);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                getBack.setBackground(new JButton().getBackground());
                getBack.setForeground(Color.WHITE);
            }
        });
        lower.add(getBack);

        //Title
        JLabel title1 = new JLabel("Daily Food Log", SwingConstants.CENTER);
        title1.setFont(programFont);
        title1.setSize(300,300);
        //title1.setMaximumSize(new Dimension(150, 150));
        //title1.setMinimumSize(new Dimension(150, 150));
        sl1.add(title1);
        //Breakfast
        JLabel breakfast = new JLabel("Breakfast: ", SwingConstants.CENTER);
        breakfast.setFont(programFont);
        JTextField bkf = new JTextField();
        bkf.setFont(programFont);
        sl1.add(breakfast);
        sl1.add(bkf);
        //Lunch
        JLabel lunch = new JLabel("Lunch: ", SwingConstants.CENTER);
        lunch.setFont(programFont);
        JTextField lnf = new JTextField();
        lnf.setFont(programFont);
        sl1.add(lunch);
        sl1.add(lnf);
        //Dinner
        JLabel dinner = new JLabel("Dinner: ", SwingConstants.CENTER);
        dinner.setFont(programFont);
        JTextField dnf = new JTextField();
        dnf.setFont(programFont);
        sl1.add(dinner);
        sl1.add(dnf);
        //Snacks
        JLabel snacks = new JLabel("Snacks: ", SwingConstants.CENTER);
        snacks.setFont(programFont);
        JTextField snf = new JTextField();
        snf.setFont(programFont);
        sl1.add(snacks);
        sl1.add(snf);


        //Log Button
        JButton log = new JButton("Log Food");
        log.setFont(programFont);
        log.setBackground(myColor1);
        log.setForeground(Color.white);
        sl1.add(log);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This button will log all values from textfields into a function that calculates total calories.
                String brkCal = bkf.getText();
                String lcal = lnf.getText();
                String dcal = dnf.getText();
                String scal = snf.getText();
                totalCals += calcTotCals(brkCal, lcal, dcal, scal);
                if(totalCals > calGoal){
                    calInf.setText(totalCals + "/" + calGoal);
                    calInf.setForeground(Color.red);
                    calMot.setText("You are " + (calGoal - totalCals) + " calories above from your daily goal.");
                }
                else if(totalCals < calGoal && totalCals > calGoal/2){
                    calInf.setText(totalCals + "/" + calGoal);
                    calInf.setForeground(Color.orange);
                    calMot.setText("You are " + (calGoal - totalCals) + " calories away from your daily goal.");
                }
                else{
                    calInf.setText(totalCals + "/" + calGoal);
                    calMot.setText("You are " + (calGoal - totalCals) + " calories away from your daily goal.");
                }
                bkf.setText("");
                lnf.setText("");
                dnf.setText("");
                snf.setText("");
            }
        });
        

        add(main);
        setTitle("Calorie++: Food Log");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public int calcTotCals(String breakfast, String lunch, String dinner, String snacks){
        int total = 0;
        int bk,lc,dn,sn;
        bk = Integer.parseInt(breakfast);
        lc = Integer.parseInt(lunch);
        dn = Integer.parseInt(dinner);
        sn = Integer.parseInt(snacks);
        total += (bk + lc + dn + sn);
        return total;
    }
}

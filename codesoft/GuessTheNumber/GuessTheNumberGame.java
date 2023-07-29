
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGame extends JFrame {
    private int guptnumber;
    private int attempts;

    private JLabel labels;
    private JTextField textfields;
    private JButton subbutton;


    private int generateRandomNumber(int small, int large) {
        return (int) (Math.random() * (large - small + 1)) + small;
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(textfields.getText());
            attempts++;
            if (guess == guptnumber) {
                JOptionPane.showMessageDialog(this, "Congratulations! You guessed the number in " + attempts + " attempts!");
                resetGame();
            } else if (guess < guptnumber) {
                JOptionPane.showMessageDialog(this, "Try again. The secret number is higher.");
            } else {
                JOptionPane.showMessageDialog(this, "Try again. The secret number is lower.");
            }
            textfields.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }


    public GuessTheNumberGame() {
        setTitle("Guess The Number Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(252, 228, 236));

        guptnumber = generateRandomNumber(1, 100);
        attempts = 0;

        labels = new JLabel("Enter your guess:");
        textfields = new JTextField(10);
        subbutton = new JButton("Submit");


        subbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        setLayout(new FlowLayout());
        add(labels);
        add(textfields);
        add(subbutton);

        setVisible(true);
    }



    private void resetGame() {
        guptnumber = generateRandomNumber(1, 100);
        attempts = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessTheNumberGame();
            }
   });
}
}

package Exercises_Arrays;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RPS {
    private int gamesPlayed = 0;
    private int computerWins = 0;
    private int userWins = 0;
    private Random random = new Random();

    public static void main(String[] args) {
        RPS rps = new RPS();
        rps.createAndShowGUI();

    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Rock, Paper, Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(650, 80));

        /**
         * GUI for rock
         */
        JButton rockButton = new JButton("Rock");
        rockButton.setPreferredSize(new Dimension(200, 50));
        rockButton.addActionListener(e -> playGame(1));
        panel.add(rockButton);

        /**
         * GUI for paper
         */
        JButton paperButton = new JButton("Paper");
        paperButton.setPreferredSize(new Dimension(200, 50));
        paperButton.addActionListener(e -> playGame(2));
        panel.add(paperButton);

        /**
         * GUI for scissors
         */
        JButton scissorsButton = new JButton("Scissors");
        scissorsButton.setPreferredSize(new Dimension(200, 50));
        scissorsButton.addActionListener(e -> playGame(3));
        panel.add(scissorsButton);

        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private void playGame(int userChoice) {
        int computerChoice = random.nextInt(3) + 1;

        System.out.println("The computer chose ");
        if (computerChoice == 1) {
            System.out.println("rock.");
        } else if (computerChoice == 2) {
            System.out.println("paper.");
        } else {
            System.out.println("scissors.");
        }

        if (userChoice == computerChoice) {
            JOptionPane.showMessageDialog(null, "It's a tie.");
        } else if (userChoice == 1 && computerChoice == 3 || userChoice == 2 && computerChoice == 1
                || userChoice == 3 && computerChoice == 2) {
            JOptionPane.showMessageDialog(null, "You win.");
            userWins++;
        } else {
            JOptionPane.showMessageDialog(null, "You lose.");
            computerWins++;
        }
        gamesPlayed++;


        System.out.println("\nNumber of games played: " + gamesPlayed);
        System.out.println("Number of computer wins: " + computerWins);
        System.out.println("Number of user wins: " + userWins);
    }

}

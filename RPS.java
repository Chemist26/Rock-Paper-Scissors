package Exercises_Arrays;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RPS {
    private int gamesPlayed = 0;
    private int computerWins = 0;
    private int userWins = 0;
    private Random random = new Random();
    private JTextArea historyTextArea; // Added for displaying game history
    private ArrayList<String> gameHistory = new ArrayList<>();

    public static void main(String[] args) {
        RPS rps = new RPS();
        rps.createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Rock, Paper, Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(650, 80));

        // GUI for rock
        JButton rockButton = new JButton("Rock");
        rockButton.setPreferredSize(new Dimension(200, 50));
        rockButton.addActionListener(e -> playGame(1));
        panel.add(rockButton);

        // GUI for paper
        JButton paperButton = new JButton("Paper");
        paperButton.setPreferredSize(new Dimension(200, 50));
        paperButton.addActionListener(e -> playGame(2));
        panel.add(paperButton);

        // GUI for scissors
        JButton scissorsButton = new JButton("Scissors");
        scissorsButton.setPreferredSize(new Dimension(200, 50));
        scissorsButton.addActionListener(e -> playGame(3));
        panel.add(scissorsButton);

        // Add a JTextArea for game history
        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        JScrollPane historyScrollPane = new JScrollPane(historyTextArea);
        historyScrollPane.setPreferredSize(new Dimension(650, 150));

        // Create a panel to contain the game and history components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.NORTH);
        mainPanel.add(historyScrollPane, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private void playGame(int userChoice) {
        int computerChoice = random.nextInt(3) + 1;

        // Display the computer's choice
        String computerMove;
        if (computerChoice == 1) {
            computerMove = "rock.";
        } else if (computerChoice == 2) {
            computerMove = "paper.";
        } else {
            computerMove = "scissors.";
        }
        gameHistory.add("Game " + (gamesPlayed + 1) + ": You chose " + getMoveName(userChoice) + ", Computer chose " + getMoveName(computerChoice));

        // Determine the result of the game
        String resultMessage;
        if (userChoice == computerChoice) {
            resultMessage = "It's a tie.";
        } else if ((userChoice == 1 && computerChoice == 3) || (userChoice == 2 && computerChoice == 1)
                || (userChoice == 3 && computerChoice == 2)) {
            resultMessage = "You win.";
            userWins++;
        } else {
            resultMessage = "You lose.";
            computerWins++;
        }
        gamesPlayed++;

        // Display the result and game statistics
        JOptionPane.showMessageDialog(null,
                resultMessage +
                        "\n\nNumber of games played: " + gamesPlayed +
                        "\nNumber of computer wins: " + computerWins +
                        "\nNumber of user wins: " + userWins);

        // Update the history JTextArea
        updateHistoryTextArea();
    }

    private String getMoveName(int move) {
        switch (move) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }

    private void updateHistoryTextArea() {
        // Clear and update the history JTextArea
        historyTextArea.setText("");
        for (String historyItem : gameHistory) {
            historyTextArea.append(historyItem + "\n");
        }
    }
}

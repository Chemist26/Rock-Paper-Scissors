package Exercises_Arrays;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RPS {
    private int gamesPlayed;
    private int computerWins;
    private int userWins;
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
        JButton rockButton = new JButton();
        rockButton.setIcon(new ImageIcon("res/rock.png"));  // Set the image
        rockButton.setPreferredSize(new Dimension(200, 50));
        rockButton.addActionListener(e -> playGame(Move.ROCK));
        panel.add(rockButton);

        // GUI for paper
        JButton paperButton = new JButton();
        paperButton.setIcon(new ImageIcon("res/paper.png"));  // Set the image
        paperButton.setPreferredSize(new Dimension(200, 50));
        paperButton.addActionListener(e -> playGame(Move.PAPER));
        panel.add(paperButton);

        // GUI for scissors
        JButton scissorsButton = new JButton();
        scissorsButton.setIcon(new ImageIcon("res/scissors.png"));  // Set the image
        scissorsButton.setPreferredSize(new Dimension(200, 50));
        scissorsButton.addActionListener(e -> playGame(Move.SCISSORS));
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

    public void playGame(Move userChoice) {
        Move computerChoice = Move.values()[random.nextInt(3)];

        // Display the computer's choice
        String computerMove = getMoveName(computerChoice);
        gameHistory.add("Game " + (gamesPlayed + 1) + ": You chose " + userChoice + ", Computer chose " + computerMove);

        // Determine the result of the game
        String resultMessage;
        if (userChoice == computerChoice) {
            resultMessage = "<html><font color='blue'><b>It's a tie.</b></font></html>";
        } else if ((userChoice == Move.ROCK && computerChoice == Move.SCISSORS) ||
                (userChoice == Move.PAPER && computerChoice == Move.ROCK) ||
                (userChoice == Move.SCISSORS && computerChoice == Move.PAPER)) {
            resultMessage = "<html><font color='green'><b>You win.</b></font></html>";
            userWins++;
        } else {
            resultMessage = "<html><font color='red'><b>You lose.</b></font></html>";
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




    private String getMoveName(Move move) {
        switch (move) {
            case ROCK:
                return "Rock";
            case PAPER:
                return "Paper";
            case SCISSORS:
                return "Scissors";
            default:
                return "";
        }
    }


    private void updateHistoryTextArea() {
        // Check if historyTextArea is initialized
        if (historyTextArea != null) {
            // Clear and update the history JTextArea
            historyTextArea.setText("");
            for (String historyItem : gameHistory) {
                historyTextArea.append(historyItem + "\n");
            }
        }
    }


    // Add getters for game statistics
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getUserWins() {
        return userWins;
    }

}

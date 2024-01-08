package Exercises_Arrays.test;

import Exercises_Arrays.Move;
import Exercises_Arrays.RPS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RPSTest {

    @Test
    public void testPlayGame() {
        RPS rps = new RPS();

        // Test a tie game
        rps.playGame(Move.ROCK);
        assertEquals(1, rps.getGamesPlayed());
        assertEquals(0, rps.getComputerWins());
        assertEquals(0, rps.getUserWins());

        // Test a user win
        rps.playGame(Move.PAPER);
        assertEquals(2, rps.getGamesPlayed());
        assertEquals(0, rps.getComputerWins());
        assertEquals(1, rps.getUserWins());

        // Test a computer win
        rps.playGame(Move.SCISSORS);
        assertEquals(3, rps.getGamesPlayed());
        assertEquals(1, rps.getComputerWins());
        assertEquals(1, rps.getUserWins());
    }
}

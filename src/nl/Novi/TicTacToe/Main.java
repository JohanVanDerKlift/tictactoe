package nl.Novi.TicTacToe;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom bij Boter kaas en eieren");
        System.out.println("Wat is de naam van speler A: ");
        String playerAName = scanner.nextLine();
        System.out.println("Wat is de naam van speler B: ");
        String playerBName = scanner.nextLine();

        Player playerA = new Player(playerAName, "X");
        Player playerB = new Player(playerBName, "O");
        FileManager writeFile = new FileManager("scores.txt");

        boolean quit = false;
        int gameNumber = 0;

        while (!quit) {

            Board board = new Board();
            board.printBoard();

            Game game = new Game(playerA, playerB);

            boolean hasWon = false;

            while (!hasWon) {

                System.out.println("\n" + game.getCurrentPlayer().getName() + " is aan de beurt");
                System.out.println("\nVoer een cijfer van 1 t/m 9 in om op het bord een " + game.getCurrentPlayer().getToken() + " te zetten");
                int selectedField = scanner.nextInt() -1;

                String currentPlayerToken = game.getCurrentPlayer().getToken();
                board.setField(selectedField, currentPlayerToken);

                board.printBoard();
                hasWon = game.hasPlayerWon(board.getField());
                if (hasWon) {
                    game.getCurrentPlayer().setScore(1);
                }

                game.switchPlayer();
            }

            gameNumber += 1;
            System.out.println("\nSpeler " + playerA.getName() + " heeft een score van " + playerA.getScore());
            System.out.println("Speler " + playerB.getName() + " heeft een score van " + playerB.getScore());
            writeFile.writeGameNumber(gameNumber);
            writeFile.writeToFile(playerA.getName(), playerA.getScore());
            writeFile.writeToFile(playerB.getName(), playerB.getScore());
            writeFile.writeLine();
            System.out.println("Wilt u het spel nog een keer spelen?");
            System.out.println("Toets 1 voor ja en 2 voor nee: ");
            int playAgain = scanner.nextInt();
            if (playAgain == 2) {
                quit = true;
            }
        }
        writeFile.closeFile();

    }
}

package Battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

        public static Board board = new Board();
        public static SlowPrint printer = new SlowPrint();
        public static Scanner in = new Scanner(System.in);

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static void main(String[] args)
                        throws NumberFormatException, InterruptedException, InputMismatchException {
                int row;
                char column;

                int totalPlayerHit = 0;
                int totalCPUHit = 0;

                board.pickCPUBoard();

                printer.slowDisplay("Welcome to \"Battleship\"");
                printer.slowDisplay("The goal of the game is to sink your enemies ships before they sink yours.");
                printer.slowDisplay("Here is the board: ");
                board.displayBoard();
                printer.slowDisplay("First, pick where you would like to place your ships");
                printer.slowDisplay("First ship: 3 spots horizontally");
                printer.slowDisplay(
                                "Where would you like to place the ship? \n (Coordinate picked will then place ship left to right)");
                boolean isInput = true;
                while (isInput) {

                        try {
                                row = Integer.parseInt(in.next());
                                column = in.next().charAt(0);
                                board.addShip1(row, column);
                                isInput = false;
                        } catch (InputMismatchException | NumberFormatException b) {
                                printer.slowDisplay("ERROR \nEnter new coordinates");
                        }
                }
                isInput = true;

                printer.slowDisplay("Next, pick where you would like to place your second ship");
                printer.slowDisplay("Second ship: 3 spots vertically");
                printer.slowDisplay(
                                "Where would you like to place the ship? \n (Coordinate picked will then place ship top to bottom)");
                while (isInput) {

                        try {
                                row = Integer.parseInt(in.next());
                                column = in.next().charAt(0);
                                board.addShip2(row, column);
                                isInput = false;
                        } catch (InputMismatchException | NumberFormatException b) {
                                printer.slowDisplay("ERROR \nEnter new coordinates");
                        }
                }
                isInput = true;

                printer.slowDisplay("Next, pick where you would like to place your third ship");
                printer.slowDisplay("Third ship: 4 spots horizontally");
                printer.slowDisplay(
                                "Where would you like to place the ship? \n (Coordinate picked will then place ship left to right)");
                while (isInput) {

                        try {
                                row = Integer.parseInt(in.next());
                                column = in.next().charAt(0);
                                board.addShip3(row, column);
                                isInput = false;
                        } catch (InputMismatchException | NumberFormatException b) {
                                printer.slowDisplay("ERROR \nEnter new coordinates");
                        }
                }
                isInput = true;

                printer.slowDisplay("Now that you have placed all your ships, time to sink your opponents ships");
                printer.slowDisplay("Time to play! ");

                do {
                        printer.slowDisplay("Enter coordinates: ");
                        row = in.nextInt();
                        column = in.next().charAt(0);
                        totalCPUHit = board.attackEnemy(row, column, totalCPUHit);
                        totalPlayerHit = board.attackPlayer(totalPlayerHit);
                } while (totalCPUHit != 10 && totalPlayerHit != 10);

                if (totalCPUHit == 10) {

                        printer.slowDisplay("Congrats!! \nYou Won!!");
                } else {
                        printer.slowDisplay("Oh man!! \nYou lost :(");
                }

        }

}
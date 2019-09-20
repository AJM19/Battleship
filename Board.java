package Battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
    public static Scanner in = new Scanner(System.in);
    private static SlowPrint printer = new SlowPrint();
    // --------------------------------------------------------------------------------------------------------------------------------
    private String[][] playerBoard = new String[6][6];

    private String[][] cpuBoard1 = new String[6][6];
    private String[][] cpuBoard2 = new String[6][6];
    private String[][] cpuBoard3 = new String[6][6];
    private String[][] cpuBoard4 = new String[6][6];
    private String[][] cpuBoardMain = new String[6][6];
    // --------------------------------------------------------------------------------------------------------------------------------

    int newR;
    char newC;
    boolean fits = false;
    // --------------------------------------------------------------------------------------------------------------------------------

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // --------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------------------------------------------------------------

    public Board() {

        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                playerBoard[x][y] = " ";
            }

        }

        cpuBoard1[1][2] = "X";
        cpuBoard1[1][3] = "X";
        cpuBoard1[1][4] = "X";
        cpuBoard1[1][5] = "X";
        cpuBoard1[2][1] = "X";
        cpuBoard1[3][1] = "X";
        cpuBoard1[4][1] = "X";
        cpuBoard1[5][3] = "X";
        cpuBoard1[5][4] = "X";
        cpuBoard1[5][5] = "X";

        cpuBoard2[0][0] = "X";
        cpuBoard2[1][0] = "X";
        cpuBoard2[2][0] = "X";
        cpuBoard2[3][3] = "X";
        cpuBoard2[3][4] = "X";
        cpuBoard2[3][5] = "X";
        cpuBoard2[5][0] = "X";
        cpuBoard2[5][1] = "X";
        cpuBoard2[5][2] = "X";
        cpuBoard2[5][3] = "X";

        cpuBoard3[0][5] = "X";
        cpuBoard3[1][5] = "X";
        cpuBoard3[2][1] = "X";
        cpuBoard3[2][2] = "X";
        cpuBoard3[2][3] = "X";
        cpuBoard3[2][4] = "X";
        cpuBoard3[2][5] = "X";
        cpuBoard3[4][0] = "X";
        cpuBoard3[4][1] = "X";
        cpuBoard3[4][2] = "X";

        cpuBoard4[0][0] = "X";
        cpuBoard4[0][1] = "X";
        cpuBoard4[0][2] = "X";
        cpuBoard4[0][3] = "X";
        cpuBoard4[3][1] = "X";
        cpuBoard4[3][2] = "X";
        cpuBoard4[3][3] = "X";
        cpuBoard4[3][4] = "X";
        cpuBoard4[2][4] = "X";
        cpuBoard4[4][4] = "X";

    }

    public void displayBoard() {

        for (int column = 65; column < 71; column++) {
            System.out.print("   " + (char) (column));
        }
        System.out.println("\n" + "---------------------------");

        for (int x = 0; x < 6; x++) {
            if (x != 0) {
                System.out.println("---------------------------");
            }

            System.out.print(x + ":| ");
            for (int y = 0; y < 6; y++) {
                System.out.print(playerBoard[x][y] + " | ");
            }
            System.out.println();

        }
        System.out.println("---------------------------");

    }

    public void addShip1(int row, char column) throws ArrayIndexOutOfBoundsException, InputMismatchException {// THREE
                                                                                                              // HORIZONTAL
                                                                                                              // (L to
                                                                                                              // R)
        // A = 0, B = 1, C = 2, D = 3, E = 4, F = 5

        char newC;
        int newR;
        column = Character.toUpperCase(column);
        int realColumn = ((int) (column) - 65);

        try {
            playerBoard[row][realColumn + 2] = (ANSI_RED + "X" + ANSI_RESET);
            playerBoard[row][realColumn + 1] = (ANSI_RED + "X" + ANSI_RESET);
            playerBoard[row][realColumn] = (ANSI_RED + "X" + ANSI_RESET);
            fits = true;
            System.out.println();
            displayBoard();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Does not fit on board");
            System.out.print("Enter new coordinates: ");
            newR = in.nextInt();
            newC = in.next().charAt(0);
            addShip1(newR, newC);
        }

    }

    public void addShip2(int row, char column) throws ArrayIndexOutOfBoundsException { // THREE VERTICAL (U to D)
        // A = 0, B = 1, C = 2, D = 3, E = 4, F = 5
        char newC;
        int newR;
        column = Character.toUpperCase(column);
        int realColumn = ((int) (column) - 65);

        try {
            if (playerBoard[row][realColumn] == (ANSI_RED + "X" + ANSI_RESET)
                    || playerBoard[row + 2][realColumn] == (ANSI_RED + "X" + ANSI_RESET)
                    || playerBoard[row + 1][realColumn] == (ANSI_RED + "X" + ANSI_RESET)) {

                System.out.println("Already ship there");
                System.out.println("Enter new coordinates: ");
                newR = in.nextInt();
                newC = in.next().charAt(0);
                addShip2(newR, newC);

            } else {

                try {
                    playerBoard[row + 2][realColumn] = (ANSI_BLUE + "X" + ANSI_RESET);
                    playerBoard[row + 1][realColumn] = (ANSI_BLUE + "X" + ANSI_RESET);
                    playerBoard[row][realColumn] = (ANSI_BLUE + "X" + ANSI_RESET);
                    System.out.println();
                    displayBoard();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Does not fit on board");
                    System.out.print("Enter new coordinates: ");
                    newR = in.nextInt();
                    newC = in.next().charAt(0);
                    addShip2(newR, newC);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Does not fit on board");
            System.out.println("Enter new coordinates: ");
            newR = in.nextInt();
            newC = in.next().charAt(0);
            addShip2(newR, newC);
        }
    }

    public void addShip3(int row, char column) throws ArrayIndexOutOfBoundsException {// THREE HORIZONTAL (L to R)
        // A = 0, B = 1, C = 2, D = 3, E = 4, F = 5

        char newC;
        int newR;
        column = Character.toUpperCase(column);
        int realColumn = ((int) (column) - 65);
        try {
            if (playerBoard[row][realColumn] == (ANSI_BLUE + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn] == (ANSI_RED + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn + 1] == (ANSI_BLUE + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn + 1] == (ANSI_RED + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn + 2] == (ANSI_RED + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn + 2] == (ANSI_BLUE + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn + 3] == (ANSI_BLUE + "X" + ANSI_RESET)
                    || playerBoard[row][realColumn + 3] == (ANSI_RED + "X" + ANSI_RESET)) {

                System.out.println("Already ship there");
                System.out.println("Enter new coordinates: ");
                newR = in.nextInt();
                newC = in.next().charAt(0);
                addShip3(newR, newC);
                return;

            } else {
                try {
                    playerBoard[row][realColumn + 3] = (ANSI_GREEN + "X" + ANSI_RESET);
                    playerBoard[row][realColumn + 2] = (ANSI_GREEN + "X" + ANSI_RESET);
                    playerBoard[row][realColumn + 1] = (ANSI_GREEN + "X" + ANSI_RESET);
                    playerBoard[row][realColumn] = (ANSI_GREEN + "X" + ANSI_RESET);
                    fits = true;
                    System.out.println();
                    displayBoard();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: Does not fit on board");
                    System.out.print("Enter new coordinates: ");
                    newR = in.nextInt();
                    newC = in.next().charAt(0);
                    addShip3(newR, newC);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error: Does not fit on board");
            System.out.println("Enter new coordinates: ");
            newR = in.nextInt();
            newC = in.next().charAt(0);
            addShip3(newR, newC);

        }

    }

    public void pickCPUBoard() throws InterruptedException {

        int random = (int) ((Math.random() * 4) + 1);
        switch (random) {
        case 1:
            cpuBoardMain = cpuBoard1;
            break;
        case 2:
            cpuBoardMain = cpuBoard2;
            break;
        case 3:
            cpuBoardMain = cpuBoard3;
            break;
        case 4:
            cpuBoardMain = cpuBoard4;
            break;

        }

        System.out.println(ANSI_YELLOW + "Playing with Board #" + random + ANSI_RESET);
        printer.slowDisplay("---------------------------");

    }

    public int attackEnemy(int row, char column, int totalHit)
            throws InterruptedException, ArrayIndexOutOfBoundsException {

        printer.slowDisplay("Firing....");
        printer.slowDisplay(".......");
        printer.slowDisplay(".......");

        int total = totalHit;

        column = Character.toUpperCase(column);
        int realColumn = ((int) (column) - 65);
        try {
            if (cpuBoardMain[row][realColumn] == "X") {
                cpuBoardMain[row][realColumn] = (ANSI_PURPLE + "O" + ANSI_RESET);
                printer.slowDisplay("HIT! (at " + row + "," + column + ")");
                total += 1;

            } else {
                printer.slowDisplay("Aghh, no ship there...");

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Could not fire");
            newR = in.nextInt();
            newC = in.next().charAt(0);
            attackEnemy(newR, newC, total);
        }
        displayCPUBoard();
        return total;
    }

    public int attackPlayer(int totalHit) throws InterruptedException {

        int total = totalHit;

        int row = (int) ((Math.random() * 3) + 1);
        int column = (int) ((Math.random() * 3) + 1);

        char realColumn = (char) (65 + column);

        printer.slowDisplay("Now it's your opponent's turn...");
        printer.slowDisplay("Opponent fire incoming....");
        printer.slowDisplay(".......");
        printer.slowDisplay(".......");

        if (playerBoard[row][column] == (ANSI_GREEN + "X" + ANSI_RESET)
                || playerBoard[row][column] == (ANSI_RED + "X" + ANSI_RESET)
                || playerBoard[row][column] == (ANSI_BLUE + "X" + ANSI_RESET)) {

            printer.slowDisplay("Oof! Your ship was hit (at " + row + "," + realColumn + ")");
            playerBoard[row][column] = " ";
            total += 1;
        } else {
            printer.slowDisplay("Ayyyyy, your opponent missed...");
        }

        displayBoard();

        return total;
    }

    public void displayCPUBoard() {

        System.out.println(ANSI_CYAN + "ENEMY SHIPS HIT: " + ANSI_RESET);
        for (int column = 65; column < 71; column++) {
            System.out.print("   " + (char) (column));
        }
        System.out.println("\n" + "---------------------------");

        for (int x = 0; x < 6; x++) {
            if (x != 0) {
                System.out.println("---------------------------");
            }

            System.out.print(x + ":| ");
            for (int y = 0; y < 6; y++) {
                if (cpuBoardMain[x][y] == (ANSI_PURPLE + "O" + ANSI_RESET)) {
                    System.out.print(cpuBoardMain[x][y] + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();

        }
        System.out.println("---------------------------");
    }

}

package Battleship;

public class SlowPrint {

    String message;
    char[] letters;

    public void slowDisplay(String message) throws InterruptedException {
        // Get message, convert to char array
        this.message = message;
        letters = message.toCharArray();

        // Print a char from the array, then sleep shortly
        for (int i = 0; i < letters.length; i++) { // Repeat for all chars
            System.out.print(letters[i]);
            Thread.sleep(25);
        }
        System.out.println();
        System.out.println("-----------------------------------");

    }

}
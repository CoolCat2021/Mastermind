import java.util.Scanner;

public class Mastermind {

  private int[] secret = new int[4];
  private int[][] guesses = new int[10][4];
  private char[] colors = {'R','G','B','Y','O','P'};
  private int guessRound = 0;

  public Mastermind() {
  }

  //play game - which is made up of:
   //generate a secret code
   //ask user to guess until the guess matches the secret

  public void playGame() {
    //comments and/or instructions
    genSecret();
    askUser();
    checkGuess();


  }
  public void genSecret() {
    for (int x = 0; x < 4; x++) {
      secret[x] =(int)(Math.floor(Math.random() * 6));
      System.out.println(secret[x]);
    }
  }

  public void askUser() {
    char[] pegGuesses = new char[4];
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter your guess for the first peg(R, G, B, Y, O, or P): ");
    pegGuesses[0] = scan.next().charAt(0);
    System.out.println("Enter your guess for the second peg(R, G, B, Y, O, or P): ");
    pegGuesses[1] = scan.next().charAt(0);
    System.out.println("Enter your guess for the third peg(R, G, B, Y, O, or P): ");
    pegGuesses[2] = scan.next().charAt(0);
    System.out.println("Enter your guess for the fourth peg(R, G, B, Y, O, or P): ");
    pegGuesses[3] = scan.next().charAt(0);
    for(int x = 0; x < 4; x++) {
      if (pegGuesses[x] == 'R') {
        guesses[guessRound][x] = 0;
      }
      else if (pegGuesses[x] == 'G') {
        guesses[guessRound][x] = 1;
      }
      else if (pegGuesses[x] == 'B') {
        guesses[guessRound][x] = 2;
      }
      else if (pegGuesses[x] == 'Y') {
        guesses[guessRound][x] = 3;
      }
      else if (pegGuesses[x] == 'O') {
        guesses[guessRound][x] = 4;
      }
      else if (pegGuesses[x] == 'P') {
        guesses[guessRound][x] = 5;
      }
    }
  }


  public void checkGuess() {
    boolean areAllCorrect = true;

    if(guesses[guessRound][0] == secret[0]) {
      System.out.print("The peg in the first position is correct. ");
    }
    else {
      System.out.print("The peg in the first position is not correct. ");
      areAllCorrect = false;
    }

    if(guesses[guessRound][1] == secret[1]) {
      System.out.print("The peg in the second position is correct. ");
    }
    else {
      System.out.print("The peg in the second position is not correct. ");
      areAllCorrect = false;
    }

    if(guesses[guessRound][2] == secret[2]) {
      System.out.print("The peg in the third position is correct. ");
    }
    else {
      System.out.print("The peg in the third position is not correct. ");
      areAllCorrect = false;
    }

    if(guesses[guessRound][3] == secret[3]) {
      System.out.println("The peg in the fourth position is correct. ");
    }
    else {
      System.out.println("The peg in the fourth position is not correct. ");
      areAllCorrect = false;
    }
    if (areAllCorrect == true) {
      System.out.println("You won!");
    }
    else {
      System.out.println("Next round: ");
      askUser();
      checkGuess();
    }
    guessRound++;
  }

}

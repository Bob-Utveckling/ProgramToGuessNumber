import java.io.Console;
import java.util.Scanner;

/**
 * Assignment 1 - Guessing Game
 * 
 * Here's the unfinished source code
 * for the Guesser class. It is your
 * task to complete the missing parts.
 */
public class Guesser{
  private int low;
  private int high;

   public static void main (String[] args) {
      Guesser newGuesser = new Guesser(0,1000);
      System.out.println ("new guesser created.");
      newGuesser.start();
      
   }
   
  /*
   * Task 1. Write code here for a constructor
   * which takes two int arguments and saves
   * them in the instance variables low and high.
   *
   * If you don't remember the syntax for how to write
   * constructors, revisit the chapter "Classes"
   * and review the section about constructors.
   *
   */
  
  // Write the constructor below this line.
  public Guesser (int givenLow, int givenHigh) {
      if (givenLow > givenHigh) { 
            throw new IllegalArgumentException("This first parameter must be lower than the second parameter");
         }
      this.low = givenLow;
      this.high = givenHigh;
      System.out.println ("Created Guesser with: "
          + this.low + " and " + this.high);
  }

  public String toString() {
   return "low: " + low + " high: " + high;
  }

  /*
   * Task 2. Complete the start() method, so that
   * in the method body, you call first the
   * rules() method, next the doGuesses() method.
   */
  public void start(){
    // call the rules method here
    // call the doGuesses() method here
    rules();
    doGuesses();
    
  }

  private void rules(){
    System.out.println("Think of a number between " +
                       low + " and "  + high);
    System.out.println("I'm going to ask a few questions in order " +
                       "to guess the number.");
    System.out.println("Please answer T for true, and F for false.\n");
  }

  /*
   * Task 3. Complete the code for the getReply() method.
   * In the current version below, it returns null each
   * call, which is not what this method is supposed to do.
   * 
   * Instead, change the method so that it reads a reply
   * from the player, and if it is "T" or "F", we have
   * a valid reply. Return the String that you read from
   * the player.
   */
  private String getReply(){
    String reply = null;
    // Write code here which reads a String from the console.
    // As long as it is not a valid reply (one of "T" and "F")
    // write an error message, and read a new reply.
    // When you have gotten a valid reply, return it.
    Scanner sc = new Scanner(System.in);
    reply = sc.nextLine();    
    //reply = new Scanner(System.in).nextLine();
    while ( !reply.equals("T") && !reply.equals("F")) {
      System.out.println("Wrong value. Please type either 'T' or 'F'");
      //Fix an error here in the reutn [20nov2018 22.00]
      reply = new Scanner(System.in).nextLine();
          System.out.println("reply: " + reply);
    }
    return reply;
  }

  private void doGuesses(){
    int i=0; // number of guesses
    int middle=0;
    while(low<high){
      // Set next guess to the middle between
      // current low and current high
      middle=low + (high-low)/2;

      System.out.println("Is the number less than or equal to " +
                         middle + "?");
      String reply = getReply();
      if("T".equals(reply)){
        // The number is less than or equal to middle
        // so we move down high to middle
        high = middle;
      }else{
        // The number is greater than middle,
        // so we move up low to middle + 1
        low = middle + 1;
      }
      i++; // One more guess!
    }
    // When low has met high, we don't enter the loop
    // and we have found the number
    answer(low, i);
  }

  private void answer(int guess, int numberOfGuesses){
    System.out.println("You were thinking about " +
                       guess +
                       " (took me " + numberOfGuesses +
                       " guesses)");
  }

}
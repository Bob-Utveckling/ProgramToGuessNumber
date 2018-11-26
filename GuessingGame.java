
public class GuessingGame {


   public static void main (String[] args) {

      IntervalParser range = new IntervalParser(args);
      if (! range.couldParse()) {
         System.err.println(range.getErrorMessage());
         usage();
         System.exit(range.getErrorCode());
      }
      
      Guesser newGuesser = new Guesser(range.low(), range.high());
      newGuesser.start();
      
      /*
      //System.out.println (args.length);
      if (args.length != 2) {
         usage();
         System.exit(1);
       }
      
      int low = 0;
      int high = 1000;
      try {
         //use arguments that are integers
          low = Integer.parseInt( args[0] );
          high = Integer.parseInt( args[1] );
      } catch (Exception e) {
         System.out.println("Wrong argument type.");
         System.out.println("Exiting.");
         System.exit(1);
      }
      newGuesser = new Guesser(low, high);
      newGuesser.start();
      */ 


   }
   
   private static void usage() {
      System.out.println("Usage: java GuessingGame low high");
      System.out.println("where low is an integer for the lower bound");
      System.out.println("and high is an integer for the uppper bound");      
      System.out.println("of the interval for the number of the GuessingGame");      
   }

}
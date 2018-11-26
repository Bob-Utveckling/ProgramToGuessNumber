public class IntervalParser {
   private int low;
   private int high;
   private int errorCode;
   private String error;
   
   
  /* Constructor 
   * This is where you do all the checks.
   *
   * If a check fails, set the error to an appropriate message
   * and the errorCode to a unique number. You may use the
   * following error codes:
   * 1: Wrong number of arguments test fails
   * 2: Integer.parseInt fails
   * 3: low < high check fails
   *
   * If nothing fails, then save the
   * parsed value from args[0] in low,
   * and the parsed value from args[1]
   * in high.
   */
   public IntervalParser(String[] args) {
      if (args.length == 2) {
         try {
            low = Integer.parseInt( args[0] );
            high = Integer.parseInt( args[1] );
            if (high <= low) {
               errorCode = 3;
               error = "Low value (first parameter) should be less than High value (second parameter)";
            }
         } catch (NumberFormatException nfe) {
            System.err.println (nfe);
            errorCode = 2;
            error = "Arguments should be two numerical values.";
         }
      } else {
            errorCode = 1;
            error = "Two numerical values are required for the program.";
      }
   }   
   
   public int getErrorCode() {
      return errorCode;
   }
   
   public boolean couldParse() {
      return error==null;
   }
   
   public String getErrorMessage() {
      return error;
   }
   
   public int low() {
      return this.low;
   }
   
   public int high() {
      return this.high;
   }
}

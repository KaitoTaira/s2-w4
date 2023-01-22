public class CokeCooler extends Refillable {

   public CokeCooler (int initialAmount) {
      super (initialAmount);
   }

   public void useUp (int amount) {
      super.useUp (amount);
      System.out.println ("There are now " +
	    currentAmount ( ) + " Cokes in the cooler.");
   }

   public void refill (int amount) {
      super.refill (amount);
      System.out.println ("There are now " +
	    currentAmount ( ) + " Cokes in the cooler.");
   }
}
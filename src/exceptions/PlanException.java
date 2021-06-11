package exceptions;

@SuppressWarnings("serial")
public class PlanException extends Exception {
	
	private int amountPlan;
	
	public PlanException(int amount) {
		super("Cannot choose more than one plan.");
		amountPlan=amount;
	}

	public int getAmountPlan() {
		return amountPlan;
	}
	
}

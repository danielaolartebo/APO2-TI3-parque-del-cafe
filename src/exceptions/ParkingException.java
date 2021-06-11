package exceptions;

@SuppressWarnings("serial")
public class ParkingException extends Exception{
	private double numberParking;

	public ParkingException(double parking) {
		super("This spaces is reserved.");
		numberParking = parking;
	}
	
	public double getNumberParking() {
		return numberParking;
	}
}

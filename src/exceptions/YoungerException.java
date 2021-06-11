package exceptions;

@SuppressWarnings("serial")
public class YoungerException extends Exception{

	private int age;
	public YoungerException(int a) {
		super("This person is a younger.");
		age = a;
	}
	
	public int getAge() {
		return age;
	}
}


public class Double extends Password
{
	private int pin;
	
	public Double(int pin, String password)
	{
		super(password);
		this.pin = pin;
	}
	
	public boolean equals(Object otherObject)
	{
		return super.equals(otherObject) && ((Double)otherObject).pin == this.pin;
	}
}

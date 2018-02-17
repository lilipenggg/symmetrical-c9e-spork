
public class Password extends Lock
{
	private String password;
	
	public Password(String password)
	{
		this.password = password;
	}
	
	public boolean equals(Object otherObject)
	{
		return super.equals(otherObject) && ((Password)otherObject).password == this.password;
	}
}

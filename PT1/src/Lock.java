
public class Lock 
{
	public boolean equals(Object otherObject)
	{
		if (this == otherObject)
			return true;
		
		if (otherObject == null)
			return false;
		
		return this.getClass() == otherObject.getClass();
		
	}
}

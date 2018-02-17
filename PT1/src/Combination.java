
public class Combination extends Lock
{
	private int first;
	private int second;
	private int third;
	
	public Combination(int first, int second, int third)
	{
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public boolean equals(Object otherObject)
	{
		Combination c = (Combination)otherObject;
		return super.equals(otherObject) && c.first == this.first && c.second == this.second && c.third == this.third;
	}
	
}

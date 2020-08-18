package problem1;

public class PrimeThread extends Thread
{
	private int low;
	private int high;
	private static int highest;
	
	public PrimeThread(int low, int high)
	{
		this.low = low;
		this.high = high;
	}
	
	public void run()
	{
		int highest = 0;
		
		for(int i = low; i <= high; i++)
		{
			if(prime(i)  && i % 10 == 7 && i >  highest)
				highest = i;
		}
		
		changeHighest(highest);
	}
	
	public int getHighest()
	{
		return PrimeThread.highest;
	}
	
	synchronized public void changeHighest(int highest)
	{
		PrimeThread.highest = highest;
	}
	
	public static boolean prime(int n) 
	{
		boolean prime = true;
		
		for(int i = 2; i <= n; i++)
		{
			prime = true;
			
			for(int j = 1; j < i; j++)
			{
				if(i % j == 0 && j != i && j != 1)
					prime = false;
			}
			
		}
		
		return prime;
	}
}

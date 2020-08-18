package problem1;

public class Threads_Driver 
{

	public static void main(String[] args) throws InterruptedException 
	{
		long startTime = System.nanoTime();
		
		PrimeThread thread1 = new PrimeThread(1, 2500);
		PrimeThread thread2 = new PrimeThread(2501, 5000);
		PrimeThread thread3 = new PrimeThread(5001, 7500);
		PrimeThread thread4 = new PrimeThread(7501, 10000);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		System.out.println("Highest : " + thread1.getHighest());
		System.out.println("Final time: " +  (System.nanoTime() - startTime) * .000001);
	}

}

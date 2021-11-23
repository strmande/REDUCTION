import java.util.Arrays;
import java.util.Random;

public class A2Work {
	/*
	 * NOTES: 
	 * Include notes about f(N) for partial credit, similar to what I put in sum0()
	 * your f(N) does not need to produce the exact answer as your op count for all sums, but it should be close
	 * use estimates based on rules we discussed to determine f(N)
	 * For algorithm 1-3, assume random number generator never produces the same value twice in a given loop, but that it does produce the worst possible order of values
	 * 
	 */
	
	/*
	 * Grading:
	 * THIS IS AN EXAMPLE
	 */
	public static String[] sum0(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = 5N+4";//sum assignment, loop, and return combined
		String On = "O(N) = N";//Growth rate of function as value of N changes - Linear
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as loop starts
		opCount++;//comparison - happens as loop starts
		for(int i = 0; i < N; i++)//5N+2 - +2 for components that happen as loop starts
		{
			//all work inside of loop is 5 units
			//loop runs N times
			//internal work of loop is 5N
			
			sum++;
			opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
			
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of loop
			opCount++;//comparison - happens at end of loop
		}
		
		opCount++;//return - don't need to count construction of return array for this assignment
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static String[] sum1(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = 5(N*N)+4";
		String On = "O(N) = N*N";
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as loop starts
		opCount++;//comparison - happens as loop starts
		for(int i = 0; i < N*N; i++)//5(N*N)+2 - + 2 for components that happen as loop starts
		{
			sum++;
			opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
			
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of loop
			opCount++;//comparison - happens at end of loop
		}
		opCount++;//return
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static String[] sum2(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = 5(N*N)+5N+4";
		String On = "O(N) = N*N";
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for(int i = 0; i < N; i++)// (N*(5N+5))+2=5(N*N)+5N+2 - +2 for components that happen as outer loop starts
		{
			//5N+2+3= 5N+5 - +3 for components that happens at end of each iteration of outer loop
			
			opCount++;//assignment of j - happens as nested loop starts
			opCount++;//comparison - happens as nested loop starts
			for(int j = 0; j < N; j++) // 5N+2 - +2 for components that happen as nested loop starts
			{
				sum++;
				opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
				
				opCount+=2;//j++ :: j=j+1 - addition and assignment at end of each iteration of nested loop
				opCount++;//comparison - happens at end of nested loop
			}
			
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of outer loop
			opCount++;//comparison - happens at end of outer loop
		}
		opCount++;//return
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static String[] sum3(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = 5(N*N*N)+5N+4";
		String On = "O(N) = N*N*N";
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for(int i = 0; i < N; i++) //(N*(5(N*N)+5))+2=5(N*N*N)+5N+2 - +2 for components that happen as outer loop starts
		{
			//5(N*N)+2+3= 5(N*N)+5 - +3 for components that happens at end of each iteration of outer loop
			
			opCount++;//assignment of j - happens as nested loop starts
			opCount++;//comparison - happens as nested loop starts
			for(int j = 0; j < N*N; j++)//5(N*N)+2 - +2 for components that happen as nested loop starts
			{
				sum++;
				opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
				
				opCount+=2;//j++ :: j=j+1 - addition and assignment at end of each iteration of nested loop
				opCount++;//comparison - happens at end of nested loop
			}
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of outer loop
			opCount++;//comparison - happens at end of outer loop
		}
		opCount++;//return
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static String[] sum4(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) =((N/2)*(5N+5))+4";
		                   // 5(N*N/2)+5(N/2)+4
		String On = "O(N) = N*N";
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for(int i = 0; i < N; i++)// runs N/2 times in worst case because j<i, 
			                      //when j=i there is no summation
			                      // ((N/2)*(5N+5)) + 2 __ +2 for components that happen at the start of the outer loop
		{
			//5N+2+3= 5N+5 __ +3 for operations that happen at the end of the outer loop
			
			opCount++;//assignment of j - happens as nested loop starts
			opCount++;//comparison - happens as nested loop starts
			for(int j = 0; j < i; j++) // runs N times __ 5N+2 __ +2 for operations that happen at the start of the nested loop
			{
				sum++;
				opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
				
				opCount+=2;//j++ :: j=j+1 - addition and assignment at end of each iteration of nested loop
				opCount++;//comparison - happens at end of nested loop
			}
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of outer loop
			opCount++;//comparison - happens at end of outer loop
		}
		opCount++;//return
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static String[] sum5(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = ((N*N)*(((N/2)*(5N+5)+5))+4";//{(N*N)*{[(N/2)*(5N+5)]+5}}+4
		String On = "O(N) = N^5";
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for(int i = 0; i < N; i++)// j<i*i - runs close to N*N times in worst case - {(N*N)*{[(N/2)*(5N+5)]+5}}+2
			
		{
			//((N/2)*(5N+5))+2+3 = ((N/2)*(5N+5))+5 - +3 for components that happen at the end of the outer loop
			
			opCount++;//assignment of j - happens as first nested loop starts
			opCount++;//comparison - happens as first nested loop starts
			for(int j = 0; j < i*i; j++) // runs N/2 times because k<j
				                         // ((N/2)*(5N+5))+2 - +2 for components that happen as first nested loop starts
			{
				//5N+2+3 = 5N+5 - +3 for components that happen at the end of the second nested loop
				
				opCount++;//assignment of k - happens as second nested loop starts
				opCount++;//comparison - happens as second nested loop starts
				for(int k = 0; k < j; k++)// runs N times - 5N+2 - +2 for components that happen as second nested loop starts
				{
					sum++;
					opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
					
					opCount+=2;//k++ :: k=k+1 - addition and assignment at end of each iteration of second nested loop
					opCount++;//comparison - happens at end of second nested loop
				}
				opCount+=2;//j++ :: j=j+1 - addition and assignment at end of each iteration of first nested loop
				opCount++;//comparison - happens at end of first nested loop
			}
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of outer loop
			opCount++;//comparison - happens at end of outer loop
		}
		opCount++;//return
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static String[] sum6(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = [answer]";
		String On = "O(N) = N^4";
		//BEGIN opCounts
		long sum = 0;
		opCount++;//assignment of sum
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for(int i = 1; i < N; i++)//i starts at 1 to prevent division error in if statement
		{
			opCount++;//assignment of j - happens as first nested loop starts
			opCount++;//comparison - happens as first nested loop starts
			for(int j = 0; j < i*i; j++)
			{
				opCount++; //comparison in if statement
				if(j%i == 0)
				{
					opCount++;//assignment of k - happens as second nested loop starts
					opCount++;//comparison - happens as second nested loop starts
					for(int k = 0; k < j; k++)
					{
						sum++;
						opCount+=2;//sum++ :: sum=sum+1 - addition and assignment
						
						opCount+=2;//k++ :: k=k+1 - addition and assignment at end of each iteration of second nested loop
						opCount++;//comparison - happens at end of second nested loop
					}
				}
				opCount+=2;//j++ :: j=j+1 - addition and assignment at end of each iteration of first nested loop
				opCount++;//comparison - happens at end of first nested loop
			}
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of outer loop
			opCount++;//comparison - happens at end of outer loop
		}
		opCount++;//return
		return new String[] {fn, On, opCount+""};
	}
	/*
	 * Grading:
	 * Correctly follow the described algorithm to complete the method - 1.5pt
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static Object[] algorithm1(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = (N/2)*(5N+8)+5";//N*(5N+8) + 2 +3
		String On = "O(N) = N^3";
		//BEGIN opCounts
		int[] arr = new int[N];
		opCount++; //assignment of arr
		Random randGen = new Random(123456789);
		opCount++; // assignment of randGen 
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for (int i=0; i<N; i++) //j<i, runs N/2 times, (N/2)*(5N+8) + 2
		{
			//5N+2+6=5N+8
			
			int randomNumber = randGen.nextInt(N);
			opCount++;//assignment of randomNumber
			
			opCount++;// comparison in if statement
			if (i==0) {
				arr[i] = randomNumber;
				opCount++; // adding random number to arr
			} else {
				
				opCount++;//assignment of j - happens as nested loop starts
				opCount++;//comparison - happens as nested loop starts
				for(int j=0; j<i; j++){ //5N+2
					
					opCount++;//comparison in if statement
					if (arr[j] == randomNumber) {
						randomNumber = randGen.nextInt(N);
						opCount++;//assignment of randomNumber
						break;
					}
					opCount+=2;//j++ :: j=j+1 - addition and assignment at end of each iteration of nested loop
					opCount++;//comparison - happens at end of nested loop
				}
				
				
				
				arr[i] = randomNumber;
				opCount++;//adding random number to arr
			}
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of outer loop
			opCount++;//comparison - happens at end of outer loop
		}
	
		
		/*
		 * Use the following method to fill the array
		 * For each position in the array, generate a random number between zero and N
		 * - If N = 10, random numbers should be 0-9
		 * Check if that random number is used in any previous position in the array
		 * - If it is used anywhere else, generate a new number and try again
		 * - If it is not used anywhere else, place it into the position and move forward
		 */
		
		/**
		 * use a loop to add element to the array
		 * start at index 0, check if index 0 just add
		 * for any other none index 0 check if the number is already in the array
		 * if in array, generate new if not add it
		 * if not check if array contains number with contains methods or streams or any other method with own loop/method
		 * */
		
		opCount++;//return
		return new Object[] {arr, new String[] {fn, On, opCount+""}};
	}
	/*
	 * Grading:
	 * Correctly follow the described algorithm to complete the method - 1.5pt
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static Object[] algorithm2(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = 10N+6";
		String On = "O(N) = N^2";
		//BEGIN opCounts
		int[] arr = new int[N];
		opCount++; //assignment of arr
		boolean[] used = new boolean[N];
		opCount++; //assignment of used
		Random randGen = new Random(123456789);
		opCount++; //assignment of randomGen

		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for (int i=0; i<N; i++) { //10N+2 - +2 for components that happen as loop starts
			int randomNumber = randGen.nextInt(N);
			opCount++;//assignment of randomNumber
			
			opCount++;// comparison in if statement
			if (i == 0) {
				arr[i] = randomNumber;
				opCount++; // assignment
				used[randomNumber] = true;
				opCount++; // assignment
			} else {
				if (used[randomNumber]) {
					randomNumber = randGen.nextInt(N);
					opCount++; // assignment of randomNumber
				}		
				
				arr[i] = randomNumber;
				opCount++; // assignment
				used[randomNumber] = true;
				opCount++; // assignment
			}
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of loop
			opCount++;//comparison - happens at end of loop
		}

		/*
		 * Use the following method to fill the array
		 * For each position in the array, generate a random number between zero and N
		 * - If N = 10, random numbers should be 0-9
		 * Check if that used[random] is true
		 * - If it is, generate a new number and try again
		 * - If it is not, place it into the position, set used[random] = true, and move forward
		 */
		opCount++;//return
		return new Object[] {arr, new String[] {fn, On, opCount+""}};
	}
	/*
	 * Grading:
	 * Correctly follow the described algorithm to complete the method - 1.5pt
	 * Add operation counts - 0.5pt
	 * f(N) formula (show your work) - 0.5pt
	 * O(N) reduction - 0.5pt
	 */
	public static Object[] algorithm3(int N)
	{
		//DO NOT COUNT IN opCount
		long opCount = 0;
		String fn = "f(N) = 13N+7 ";//(8N+2)+(5N+2)+3
		String On = "O(N) = N";
		//BEGIN opCounts
		int[] arr = new int[N];
		opCount++; //assignment of arr
		Random randGen = new Random(123456789);
		opCount++; //assignment of randGen
		
		opCount++;//assignment of i - happens as outer loop starts
		opCount++;//comparison - happens as outer loop starts
		for (int i=0; i<N; i++) //5N+2 - for components that happen as loop starts
		{
			int randomNumber = randGen.nextInt(N);
			opCount++;//assignment of randomNumber
			
			arr[i] = randomNumber;
			opCount++; // adding random number to arr
			
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of loop
			opCount++;//comparison - happens at end of loop
		}
		opCount++;//assignment of i - happens as loop starts
		opCount++;//comparison - happens as loop starts
		for (int i=0; i<N; i++)//8N+2 - +2 for components that happen as loop starts
		{
			int randomPosition = randGen.nextInt(N);
			opCount++;//assignment of randomNumber
			arr[i] = randomPosition;
			opCount++; // adding random position to arr
			int temp = arr[i];
			opCount++; // assignment of temp
			arr[i] = arr[randomPosition];
			opCount++; // assignment of arr[i]
			arr[randomPosition] = temp;
			opCount++; // assignment of arr[randomPosition]
			
			opCount+=2;//i++ :: i=i+1 - addition and assignment at end of each iteration of loop
			opCount++;//comparison - happens at end of loop
		}
		/*
		 * Use the following method to fill the array
		 * Fill the arr with zero to N-1 in order
		 * Run a loop through each position
		 * - For each position, swap that position and a randomly chosen position
		 */
		opCount++;//return
		return new Object[] {arr, new String[] {fn, On, opCount+""}};
	}
}

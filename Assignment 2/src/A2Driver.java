import java.util.Arrays;

public class A2Driver {

	public static void main(String[] args) {
		int N = 10;
		System.out.println("N = "+N);
		String[] ans = A2Work.sum0(N);
		System.out.println("Sum0:");
		System.out.println((ans[0].equals("f(N) = 5N+4"))?"f(N) Correct (0.5pts)":ans[0]+" : f(N) = 5N+4");
		System.out.println((ans[1].equals("O(N) = N"))?"O(N) Correct (0.5pts)":ans[1]+" : O(N) = N");
		long count = Long.parseLong(ans[2]);
		long correct = 54;
		double accuracy = Math.abs(correct-count)/(double)correct*100;//allow up to 5% off
		System.out.println((accuracy <= 5)?"opCount Correct (0.5pts)":ans[2]+" : 504");
		System.out.println();
		System.out.println("Sum0:"+Arrays.toString(A2Work.sum0(N)));
		System.out.println("Sum1:"+Arrays.toString(A2Work.sum1(N)));
		System.out.println("Sum2:"+Arrays.toString(A2Work.sum2(N)));
		System.out.println("Sum3:"+Arrays.toString(A2Work.sum3(N)));
		System.out.println("Sum4:"+Arrays.toString(A2Work.sum4(N)));
		System.out.println("Sum5:"+Arrays.toString(A2Work.sum5(N)));
		System.out.println("Sum6:"+Arrays.toString(A2Work.sum6(N)));
		System.out.println();
		System.out.println("N = "+N);
		System.out.println("Alg 1");
		Object[] answer = A2Work.algorithm1(N);
		System.out.println("Array Data Check:"+checkArray((int[])answer[0]));
		System.out.println(Arrays.toString((String[])answer[1]));
		System.out.println("Alg 2");
		answer = A2Work.algorithm2(N);
		System.out.println("Array Data Check:"+checkArray((int[])answer[0]));
		System.out.println(Arrays.toString((String[])answer[1]));
		System.out.println("Alg 3");
		answer = A2Work.algorithm3(N);
		System.out.println("Array Data Check:"+checkArray((int[])answer[0]));
		System.out.println(Arrays.toString((String[])answer[1]));
		System.out.println();
	}

	public static boolean checkArray(int[] arr)
	{
		Arrays.sort(arr);
		int size = arr.length;
		for(int i = 1; i < size; i++)
		{
			if(arr[i] == arr[i-1])//all values must be unique
			{
				return false;
			}
			if(arr[i] >= size)//no value larger than the size, use zero to N-1
			{
				return false;
			}
		}
		
		return true;
	}
}

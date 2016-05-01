package shutils.array;

/**
 * This class contains various utilities implemented as static methods that allow to work with standard arrays.
 * @author Matteo Nardini
 */
public class SHArray {

	
	/*
	 *  FIND MAX
	 */
	
	
	/**
	 * Finds the max element of the array in the interval {@code (i;j)}.
	 * @param A The array which max has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The max element of the array {@code A} in the interval {@code (i;j)}.
	 * @throws IllegalArgumentException When {@code i > j}.
	 * @throws IndexOutOfBoundsException When {@code i < 0} or {@code j >= A.length}.
	 */
	public static <T extends Comparable<T>> T findMaxInRange(T[] A, int i, int j)
	{
		if(A.length == 0) return null;
		
		checkEndpoints(A.length, i, j);
		
		T max = A[i];
		for(;i <= j; i++)
		{
			if(A[i].compareTo(max) > 0) max = A[i];
		}
		
		return max;
	}
	
	/**
	 * Finds the max element of the array.
	 * @param A The array which max has to be found.
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The max element of the array {@code A}.
	 */
	public static <T extends Comparable<T>> T findMax(T[] A)
	{
		return findMaxInRange(A, 0, A.length - 1);
	}
	
	
	/**
	 * Finds the max element position of the array in the interval {@code (i;j)}.
	 * @param A The array which max position has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The max element position of the array {@code A} in the interval {@code (i;j)}.
	 * @throws IllegalArgumentException When {@code i > j}.
	 * @throws IndexOutOfBoundsException When {@code i < 0} or {@code j >= A.length}.
	 */
	public static <T extends Comparable<T>> Integer findMaxPosInRange(T[] A, int i, int j)
	{
		if(A.length == 0) return null;
		
		checkEndpoints(A.length, i, j);
		
		int maxPos = i;
		
		for (; i <= j; i++)
		{
			if (A[i].compareTo(A[maxPos]) > 0)
			{
				maxPos = i;
			}
		}
		
		return maxPos;
	}

	/**
	 * Finds the max element position of the array.
	 * @param A The array which max position has to be found.
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The max element position of the array {@code A}.	
	 */
	public static <T extends Comparable<T>> Integer findMaxPos(T[] A)
	{
		return findMaxPosInRange(A, 0, A.length - 1);
	}
	
	
	
	
	
	
	
	
	
	/*
	 *  FIND MIN
	 */
	
	/**
	 * Finds the min element of the array in the interval {@code (i;j)}.
	 * @param A The array which min has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @return The min element of the array {@code A} in the interval {@code (i;j)}.
	 * @throws IllegalArgumentException When {@code i > j}.
	 * @throws IndexOutOfBoundsException When {@code i < 0} or {@code j >= A.length}.
	 */
	public static <T extends Comparable<T>> T findMinInRange(T[] A, int i, int j)
	{
		if(A.length == 0) return null;
		
		if (i > j) throw new IllegalArgumentException("The lower endpoint is greater than the upper one.");
		
		checkEndpoints(A.length, i, j);
		
		T min = A[i];
		for(;i <= j; i++)
		{
			if(A[i].compareTo(min) < 0) min = A[i];
		}
		
		return min;
	}
	
	
	/**
	 * Finds the min element of the array.
	 * @param A The array which min has to be found.
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The min element of the array {@code A}.
	 */
	public static <T extends Comparable<T>> T findMin(T[] A)
	{
		return findMinInRange(A, 0, A.length - 1);
	}
	
	
	/**
	 * Finds the min element position of the array in the interval {@code (i;j)}.
	 * @param A The array which min position has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The min element position of the array {@code A} in the interval {@code (i;j)}.
	 * @throws IllegalArgumentException When {@code i > j}.
	 * @throws IndexOutOfBoundsException When {@code i < 0} or {@code j >= A.length}.
	 */
	public static <T extends Comparable<T>> Integer findMinPosInRange(T[] A, int i, int j)
	{
		if(A.length == 0) return null;
		
		checkEndpoints(A.length, i, j);
		
		int minPos = i;
		
		for (; i <= j; i++)
		{
			if (A[i].compareTo(A[minPos]) < 0)
			{
				minPos = i;
			}
		}
		
		return minPos;
	}

	/**
	 * Finds the min element position of the array.
	 * @param A The array which min position has to be found.
	 * @param <T> The type of elements contained in {@code A}.
	 * @return The min element position of the array {@code A}.	
	 */
	public static <T extends Comparable<T>> Integer findMinPos(T[] A)
	{
		return findMinPosInRange(A, 0, A.length - 1);
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * 	INTERNAL UTILITIES 
	 */

	/**
	 * Internal utility to check if the endpoints are valid.
	 * @param l The length of the array.
	 * @param i The left (lower) endpoint.
	 * @param j The right (greater) endpoint. 
	 * @throws IllegalArgumentException When {@code i > j}.
	 * @throws IndexOutOfBoundsException When {@code i < 0} or {@code j >= A.length}.
	 */
	private static void checkEndpoints(int l, int i, int j)
	{		
		if (i > j) throw new IllegalArgumentException("The lower endpoint is greater than the upper one.");
		
		if (i < 0 || j >= l)
			throw new IndexOutOfBoundsException("The endpoints are not valid.");
	}
	
}

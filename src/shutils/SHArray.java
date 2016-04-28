package shutils;

/**
 * Since in the Data Structure and Algorithms we are not allowed to use imports,
 * here is a generic library useful to work with arrays.
 * @author Matteo Nardini
 */
public class SHArray {

	/**
	 * Finds the max element of the array in the interval @code{(i;j)}.
	 * @param A The array which max has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @return The max element of the array @code{A} in the interval @code{(i;j)}.
	 * @throws IllegalArgumentException When @code{i > j}.
	 */
	public static <T extends Number> T findMax(T[] A, int i, int j)
	{
		if (i > j) throw new IllegalArgumentException("The lower endpoint is greater than the upper one.");
		
		T max = A[i];
		for(;i <= j; i++)
		{
			if(A[i].longValue() > max.longValue()) max = A[i];
		}
		
		return max;
	}
	
	/**
	 * Finds the max element position of the array in the interval @code{(i;j)}.
	 * @param A The array which max position has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @return The max element position of the array @code{A} in the interval @code{(i;j)}.
	 * @throws IllegalArgumentException When @code{i > j}.
	 */
	public static <T extends Number> int findMaxPos(T[] A, int i, int j)
	{
		if (i > j) throw new IllegalArgumentException("The lower endpoint is greater than the upper one.");
		
		int maxPos = i;
		
		for (; i <= j; i++)
		{
			if (A[i].longValue() > A[maxPos].longValue())
			{
				maxPos = i;
			}
		}
		
		return maxPos;
	}
	
	/**
	 * Finds the min element of the array in the interval @code{(i;j)}.
	 * @param A The array which min has to be found.
	 * @param i The lower endpoint of the search interval (inclusive).
	 * @param j The upper endpoint of the search interval (inclusive).
	 * @return The min element of the array @code{A} in the interval @code{(i;j)}.
	 * @throws IllegalArgumentException When @code{i > j}.
	 */
	public static <T extends Number> T findMin(T[] A, int i, int j)
	{
		if (i > j) throw new IllegalArgumentException("The lower endpoint is greater than the upper one.");
		
		T min = A[i];
		for(;i <= j; i++)
		{
			if(A[i].longValue() < min.longValue()) min = A[i];
		}
		
		return min;
	}
	
	/**
	 * Swaps two elements of the array.
	 * @param A The array which elements are to be swapped.
	 * @param i The index of the first element to be swapped.
	 * @param j The index of the second element to be swapped.
	 */
	public static <T> void swap(T[] A, int i, int j)
	{
		T tmp;
		tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	/**
	 * Shifts all the elements of @code{A} starting from position @code{i} and reaching position @code{j}.
	 * The element @code{A[i]} is unchanged.
	 * @param A The array which element are to be shifted.
	 * @param i The starting position for the shift.
	 * @param j The end position for the shift.
	 */
	public static <T> void shiftRight(T[] A, int i, int j)
	{		
		for(; j > i; j--)
		{
			A[j] = A[j - 1];
		}
	}
	
	/**
	 * Shifts all the elements of @code{A} starting from position @code{j} and reaching position @code{i}.
	 * The element @code{A[j]} is unchanged.
	 * @param A The array which element are to be shifted.
	 * @param i The end position for the shift.
	 * @param j The start position for the shift.
	 */
	public static <T> void shiftLeft(T[] A, int i, int j)
	{
		for(; i < j; i++)
		{
			A[i] = A[i + 1];
		}
	}

	/**
	 * Creates a random int array.
	 * @param size The size of the array to be created.
	 * @param min The minimum value allowed in the array (inclusive).
	 * @param max The maximum value allowed in the array (inclusive).
	 * @return The random int array.
	 * @throws IllegalArgumentException When @code{min > max}.
	 */
	public static int[] createRandomArray(int size, int min, int max)
	{
		if (min > max) throw new IllegalArgumentException("min is greater than max.");
		
		int[] ans = new int[size];
		
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (int)(Math.random() * (max-min + 1) + min);
		}
		
		return ans;
	}
	

	/**
	 * Creates a random double array.
	 * @param size The size of the array to be created.
	 * @param min The minimum value allowed in the array (inclusive).
	 * @param max The maximum value allowed in the array (inclusive).
	 * @return The random double array.
	 * @throws IllegalArgumentException When @code{min > max}.
	 */
	public static double[] createRandomArray(int size, double min, double max)
	{
		if (min > max) throw new IllegalArgumentException("min is greater than max.");
		
		double[] ans = new double[size];
		
		for (int i = 0; i < ans.length; i++) {
			ans[i] = (double)(Math.random() * (max-min + 1) + min);
		}
		
		return ans;
	}
	
	
	/**
	 * Creates a random int matrix.
	 * @param rows The number of rows of the matrix to be created.
	 * @param cols The number of columns of the matrix to be created.
	 * @param min The minimum value allowed in the matrix (inclusive).
	 * @param max The maximum value allowed in the matrix (inclusive).
	 * @return The random int matrix.
	 * @throws IllegalArgumentException When @code{min > max}
	 */
	public static int[][] createRandomMatrix(int rows, int cols, int min, int max)
	{
		if (min > max) throw new IllegalArgumentException("min is greater than max.");
		
		int[][] ans = new int[rows][cols];
		
		for (int i = 0; i < ans.length; i++)
		{
			for (int j = 0; j < ans[i].length; j++)
			{
				ans[i][j] = (int)(Math.random() * (max-min + 1) + min);
			}
		}
		
		return ans;
	}
	
	/**
	 * Creates a random double matrix.
	 * @param rows The number of rows of the matrix to be created.
	 * @param cols The number of columns of the matrix to be created.
	 * @param min The minimum value allowed in the matrix (inclusive).
	 * @param max The maximum value allowed in the matrix (inclusive).
	 * @return The random double matrix.
	 * @throws IllegalArgumentException When @code{min > max}
	 */
	public static double[][] createRandomMatrix(int rows, int cols, double min, double max)
	{
		if (min > max) throw new IllegalArgumentException("min is greater than max.");
		
		double[][] ans = new double[rows][cols];
		
		for (int i = 0; i < ans.length; i++)
		{
			for (int j = 0; j < ans[i].length; j++)
			{
				ans[i][j] = (double)(Math.random() * (max-min + 1) + min);
			}
		}
		
		return ans;
	}
	

	/**
	 * Copies an array to another array. The copy is shallow.
	 * @param A The array to be copied.
	 * @return A shallow copy of the array.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] copyArray(T[] A)
	{
		Object[] copy = new Object[A.length];
		
		for (int i = 0; i < A.length; i++)
		{
			copy[i] = A[i];
		}
		
		return (T[]) copy;
	}
	
	/**
	 * Finds an element in the array.
	 * @param A The array to be searched.
	 * @param q The value to be found.
	 * @return The position of the searched element in the array. If it doesn't exist, the method returns @code{-1}.
	 */
	public static <T> int findInArray(T[] A, T q)
	{
		for (int i = 0; i < A.length; i++)
		{
			if (A[i].equals(q)) return i;
		}
		
		return -1;
	}
	
	/**
	 * Finds an element in a sorted array. Internally a binary search is performed.
	 * @param A The sorted array to be searched.
	 * @param q The value to be found.
	 * @return The position of the searched element in the array. If it doesn't exist, the method returns @code{-1}.
	 */
	public static <T extends Comparable<T>> int findInSortedArrary(T[] A, T q)
	{
		// The array is sorted, I can perform a binarySearch
		return binarySearch(A, 0, A.length - 1, q);
	}
	
	/**
	 * Finds the first occurrence of an element in a sorted array. Internally a binary search is performed.
	 * @param A The sorted array to be searched.
	 * @param q The value to be found.
	 * @return The position of the first occurrence searched element in the array. If it doesn't exist, the method returns @code{-1}.
	 */
	public static <T extends Comparable<T>> int findFirstInSortedArrary(T[] A, T q)
	{
		// The array is sorted, I can perform a binarySearch
		int pos = binarySearch(A, 0, A.length - 1, q);
		
		// If the element isn't found I just return -1
		if (-1 == pos) return -1;
		
		// Otherwise I search to the left of the found element until I reach
		// the first match for q in the array.
		while (pos >= 0 && A[pos] == q)
		{
			pos--;
		}
		
		return pos + 1;
	}
	
	
	private static <T extends Comparable<T>> int binarySearch(T[] A, int i, int j, T q)
	{
		// Finds the middle element
		int middle = (i + j) / 2;
		
		// If it is equal to q, then I found what was requested.
		if (A[middle] == q) return middle;
		
		// If middle equals one of the two endpoints of this subset and
		// A[middle] != q, then the element doesn't exist in this array
		if (middle == i || middle == j) return -1;
		
		if (q.compareTo(A[middle]) < 0) //q < A 
		{
			// If the searched value is lower than A[middle], then I search
			// in the left half of this subset of A
			return binarySearch(A, i, middle - 1, q);
		}else{
			//otherwise in its right half
			return binarySearch(A, middle + 1, j, q);	
		}
	}
	
}

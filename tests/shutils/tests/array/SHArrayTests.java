package shutils.tests.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import shutils.array.SHArray;

public class SHArrayTests {

	// FIND MAX
	
	/*
	 *	findMaxInRange 
	 */
	
	@Test
	public void testFindMaxInRange_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(8, (int)SHArray.findMaxInRange(A, 0, A.length - 1));
	}
	
	@Test
	public void testFindMaxInRange_01() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(7, (int)SHArray.findMaxInRange(A, 1, 3));
	}
	
	@Test
	public void testFindMaxInRange_02() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(5, (int)SHArray.findMaxInRange(A, 1, 1));
	}
	
	@Test
	public void testFindMaxInRange_03() {
		
		Integer[] A = {};
		
		assertEquals(null, SHArray.findMaxInRange(A, 0, 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMaxInRange_04() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxInRange(A, 6, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMaxInRange_05() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxInRange(A, -1, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMaxInRange_06() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxInRange(A, 5, 6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMaxInRange_07() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxInRange(A, 1, -1);
	}
	

	
	/*
	 *	findMax
	 */
	
	@Test
	public void testFindMax_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(8, (int)SHArray.findMax(A));
	}

	
	/*
	 *	findMaxPosInRange 
	 */
	
	@Test
	public void testFindMaxPosInRange_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(4, (int)SHArray.findMaxPosInRange(A, 0, A.length - 1));
	}
	
	@Test
	public void testFindMaxPosInRange_01() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(3, (int)SHArray.findMaxPosInRange(A, 1, 3));
	}
	
	@Test
	public void testFindMaxPosInRange_02() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(1, (int)SHArray.findMaxPosInRange(A, 1, 1));
	}
	
	@Test
	public void testFindMaxPosInRange_03() {
		
		Integer[] A = {};
		
		assertEquals(null, SHArray.findMaxPosInRange(A, 0, 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMaxPosInRange_04() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxPosInRange(A, 6, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMaxPosInRange_05() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxPosInRange(A, -1, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMaxPosInRange_06() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxPosInRange(A, 5, 6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMaxPosInRange_07() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMaxPosInRange(A, 1, -1);
	}
	

	
	/*
	 *	findMaxPos
	 */
	
	@Test
	public void testFindMaxPos_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(4, (int)SHArray.findMaxPos(A));
	}

	
	
	// FIND MIN
	/*
	 *	findMinInRange 
	 */
	
	@Test
	public void testFindMinInRange_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(2, (int)SHArray.findMinInRange(A, 0, A.length - 1));
	}
	
	@Test
	public void testFindMinInRange_01() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(4, (int)SHArray.findMinInRange(A, 1, 3));
	}
	
	@Test
	public void testFindMinInRange_02() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(5, (int)SHArray.findMinInRange(A, 1, 1));
	}
	
	@Test
	public void testFindMinInRange_03() {
		
		Integer[] A = {};
		
		assertEquals(null, SHArray.findMinInRange(A, 0, 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMinInRange_04() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinInRange(A, 6, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMinInRange_05() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinInRange(A, -1, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMinInRange_06() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinInRange(A, 5, 6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMinInRange_07() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinInRange(A, 1, -1);
	}
	

	
	/*
	 *	findMin
	 */
	
	@Test
	public void testFindMin_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(2, (int)SHArray.findMin(A));
	}

	
	/*
	 *	findMinPosInRange 
	 */
	
	@Test
	public void testFindMinPosInRange_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(0, (int)SHArray.findMinPosInRange(A, 0, A.length - 1));
	}
	
	@Test
	public void testFindMinPosInRange_01() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(2, (int)SHArray.findMinPosInRange(A, 1, 3));
	}
	
	@Test
	public void testFindMinPosInRange_02() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(1, (int)SHArray.findMinPosInRange(A, 1, 1));
	}
	
	@Test
	public void testFindMinPosInRange_03() {
		
		Integer[] A = {};
		
		assertEquals(null, SHArray.findMinPosInRange(A, 0, 0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMinPosInRange_04() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinPosInRange(A, 6, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMinPosInRange_05() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinPosInRange(A, -1, 2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testFindMinPosInRange_06() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinPosInRange(A, 5, 6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindMinPosInRange_07() {
		
		Integer[] A = {3, 6, 5, 8};
		
		SHArray.findMinPosInRange(A, 1, -1);
	}
	

	
	/*
	 *	findMinPos
	 */
	
	@Test
	public void testFindMinPos_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(0, (int)SHArray.findMinPos(A));
	}
	
	
}

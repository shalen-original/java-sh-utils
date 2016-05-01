package shutils.tests.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import shutils.array.SHArray;

public class SHArrayTests {

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
	 *	findMax
	 */
	
	@Test
	public void testFindMaxPos_00() {
		
		Integer[] A = {2, 5, 4, 7, 8, 7, 2};
		
		assertEquals(4, (int)SHArray.findMaxPos(A));
	}

}

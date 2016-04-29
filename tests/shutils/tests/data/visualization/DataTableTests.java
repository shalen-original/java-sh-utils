package shutils.tests.data.visualization;

import static org.junit.Assert.*;

import org.junit.Test;

import shutils.data.visualization.DataTable;

/**
 * @author Matteo Nardini
 *
 */
public class DataTableTests {

	/*
	 * -------------------------------------
	 * 		GET HEADINGS
	 * -------------------------------------
	 */
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getHeadings()}.
	 */
	@Test
	public void testGetHeadings_00() {
		
		DataTable<Integer> t = new DataTable<>(3);
		
		assertEquals(true, t.getHeadings() == null);
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getHeadings()}.
	 */
	@Test
	public void testGetHeadings_01() {
		
		DataTable<Integer> t = new DataTable<>("Test", "Test 2");
		
		boolean same = true;
		String[] h = t.getHeadings();
		String[] a = {"Test", "Test 2"};
		for (int i = 0; i < h.length; i++)
		{
			if (!h[i].equals(a[i]))
				same = false;
		}
		
		assertEquals(true, same);
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getHeadings()}.
	 */
	@Test
	public void testGetHeadings_02() {
		
		DataTable<Integer> t = new DataTable<>("");
		
		assertEquals(true, t.getHeadings().length == 1 && t.getHeadings()[0].equals(""));
		
	}
	
	
	
	/*
	 * -------------------------------------
	 * 		SET HEADINGS
	 * -------------------------------------
	 */
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#setHeadings()}.
	 */
	@Test
	public void testSetHeadings_00() {
		
		DataTable<Integer> t = new DataTable<>(2);
		
		t.setHeadings("Test", "Test 2");
		
		boolean same = true;
		String[] h = t.getHeadings();
		String[] a = {"Test", "Test 2"};
		for (int i = 0; i < h.length; i++)
		{
			if (!h[i].equals(a[i]))
				same = false;
		}
		
		assertEquals(true, same);
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#setHeadings()}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetHeadings_01() {
		
		DataTable<Integer> t = new DataTable<>(2);
		
		t.setHeadings("Test", "Test 2", "Test 3");
		
	}

}

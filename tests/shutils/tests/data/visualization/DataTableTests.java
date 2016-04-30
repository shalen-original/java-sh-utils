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
	 * 		getHeadings
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
	 * 		setHeadings
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
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#setHeadings()}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetHeadings_02() {
		
		DataTable<Integer> t = new DataTable<>(2);
		
		t.setHeadings("Test");
		
	}
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		addRow
	 * -------------------------------------
	 */
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#addRow(Object[])}.
	 */
	@Test
	public void testAddRow_00() {
		
		DataTable<Integer> t = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		t.addRow(a);
		
		assertEquals("Test 1;Test 2;Test 3\n1;2;3", t.toString());
		
	}
	
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#addRow(Object[])}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddRow_01() {
		
		DataTable<Integer> t = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3, 4};
		t.addRow(a);
		
	}
	
	
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		removeRowAtIndex
	 * -------------------------------------
	 */
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#removeRowAtIndex(Object[])}.
	 */
	@Test
	public void testRemoveRowAtIndex_00() {
		
		DataTable<Integer> t = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		t.addRow(a);
		t.addRow(a);
		t.removeRowAtIndex(1);
		
		assertEquals("Test 1;Test 2;Test 3\n1;2;3", t.toString());
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#removeRowAtIndex(Object[])}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveRowAtIndex_01() {
		
		DataTable<Integer> t = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		t.addRow(a);
		t.removeRowAtIndex(6);
	}
	
	
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		getRowCount
	 * -------------------------------------
	 */
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_00() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals(3, d.getRowCount());
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_01() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals(3, d.getRowCount(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_02() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals(2, d.getRowCount(false));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_03() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		assertEquals(1, d.getRowCount(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_04() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals(2, d.getRowCount(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_05() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals(2, d.getRowCount(false));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#getRowCount()()}.
	 */
	@Test
	public void testGetRowCount_06() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		assertEquals(0, d.getRowCount(true));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		toCSVTableString
	 * -------------------------------------
	 */
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_00() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("Test 1;Test 2;Test 3\n1;2;3\n1;2;3", d.toCSVTableString(true, ";"));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_01() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("1;2;3\n1;2;3", d.toCSVTableString(true, ";"));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_02() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("Test 1 ; Test 2 ; Test 3\n1 ; 2 ; 3\n1 ; 2 ; 3", d.toCSVTableString(true, " ; "));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_03() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("1 ; 2 ; 3\n1 ; 2 ; 3", d.toCSVTableString(true, " ; "));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_04() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("1;2;3\n1;2;3", d.toCSVTableString(false, ";"));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_05() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("1;2;3\n1;2;3", d.toCSVTableString(false, ";"));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_06() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("1 ; 2 ; 3\n1 ; 2 ; 3", d.toCSVTableString(false, " ; "));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_07() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("1 ; 2 ; 3\n1 ; 2 ; 3", d.toCSVTableString(false, " ; "));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_08() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		assertEquals("Test 1;Test 2;Test 3", d.toCSVTableString(true, ";"));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toCSVTableString}.
	 */
	@Test
	public void testToCSVTableString_09() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		assertEquals("", d.toCSVTableString(true, ";"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		toLatexTableString
	 * -------------------------------------
	 */
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toLatexTableString}.
	 */
	@Test
	public void testToLatexTableString_00() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("\\begin{center}{\\renewcommand{\\arraystretch}{1.5}\\renewcommand{\\tabcolsep}"
				+ "{0.2cm}\\begin{tabular}{|c|c|c|c|}\\hline Test 1 & Test 2 & Test 3\\\\ \\hline 1 & 2 & 3"
				+ "\\\\ \\hline 1 & 2 & 3\\\\ \\hline \\end{tabular}}\\end{center}", d.toLatexTableString(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toLatexTableString}.
	 */
	@Test
	public void testToLatexTableString_01() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("\\begin{center}{\\renewcommand{\\arraystretch}{1.5}\\renewcommand{\\tabcolsep}"
				+ "{0.2cm}\\begin{tabular}{|c|c|c|c|}\\hline 1 & 2 & 3\\\\ \\hline 1 & 2 & 3\\\\ \\hline "
				+ "\\end{tabular}}\\end{center}", d.toLatexTableString(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toLatexTableString}.
	 */
	@Test
	public void testToLatexTableString_02() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("\\begin{center}{\\renewcommand{\\arraystretch}{1.5}\\renewcommand{\\tabcolsep}"
				+ "{0.2cm}\\begin{tabular}{|c|c|c|c|}\\hline 1 & 2 & 3\\\\ \\hline 1 & 2 & 3\\\\ \\hline "
				+ "\\end{tabular}}\\end{center}", d.toLatexTableString(false));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toLatexTableString}.
	 */
	@Test
	public void testToLatexTableString_03() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("\\begin{center}{\\renewcommand{\\arraystretch}{1.5}\\renewcommand{\\tabcolsep}"
				+ "{0.2cm}\\begin{tabular}{|c|c|c|c|}\\hline 1 & 2 & 3\\\\ \\hline 1 & 2 & 3\\\\ \\hline "
				+ "\\end{tabular}}\\end{center}", d.toLatexTableString(false));
		
	}
	
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toLatexTableString}.
	 */
	@Test
	public void testToLatexTableString_04() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		assertEquals("\\begin{center}{\\renewcommand{\\arraystretch}{1.5}"
				+ "\\renewcommand{\\tabcolsep}{0.2cm}\\begin{tabular}{|c|c|c|c|}\\hline Test "
				+ "1 & Test 2 & Test 3\\\\ \\hline \\end{tabular}}\\end{center}", d.toLatexTableString(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toLatexTableString}.
	 */
	@Test
	public void testToLatexTableString_05() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		assertEquals("", d.toLatexTableString(true));
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		toMatlabMatrixString
	 * -------------------------------------
	 */
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toMatlabMatrixString}.
	 */
	@Test
	public void testToMatlabMatrixString_00() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("Test = [1 2 3;1 2 3];", d.toMatlabMatrixString("Test"));
		
	}
	
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toMatlabMatrixString}.
	 */
	@Test
	public void testToMatlabMatrixString_01() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		assertEquals("Test = [];", d.toMatlabMatrixString("Test"));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toMatlabMatrixString}.
	 */
	@Test
	public void testToMatlabMatrixString_02() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		assertEquals("Test = [];", d.toMatlabMatrixString("Test"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * -------------------------------------
	 * 		toHTMLTableString
	 * -------------------------------------
	 */
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toHTMLTableString}.
	 */
	@Test
	public void testToHTMLTableString_00() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("<table><tr><td>Test 1</td><td>Test 2</td><td>Test 3</td></tr><tr><td>1</td><td>2</td>"
				+ "<td>3</td></tr><tr><td>1</td><td>2</td><td>3</table>", d.toHTMLTableString(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toHTMLTableString}.
	 */
	@Test
	public void testToHTMLTableString_01() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("<table><tr><td>1</td><td>2</td><td>3</td></tr>"
				+ "<tr><td>1</td><td>2</td><td>3</table>", d.toHTMLTableString(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toHTMLTableString}.
	 */
	@Test
	public void testToHTMLTableString_02() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("<table><tr><td>1</td><td>2</td><td>3</td></tr>"
				+ "<tr><td>1</td><td>2</td><td>3</table>", d.toHTMLTableString(false));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toHTMLTableString}.
	 */
	@Test
	public void testToHTMLTableString_03() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		Integer[] a = {1, 2, 3};
		d.addRow(a);
		d.addRow(a);
		
		assertEquals("<table><tr><td>1</td><td>2</td><td>3</td></tr>"
				+ "<tr><td>1</td><td>2</td><td>3</table>", d.toHTMLTableString(false));
		
	}
	
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toHTMLTableString}.
	 */
	@Test
	public void testToHTMLTableString_04() {
		
		DataTable<Integer> d = new DataTable<>("Test 1", "Test 2", "Test 3");
		
		assertEquals("<table><tr><td>Test 1</td><td>Test 2</td><td>Test 3</table>", d.toHTMLTableString(true));
		
	}
	
	/**
	 * Test method for {@link shutils.data.visualization.DataTable#toHTMLTableString}.
	 */
	@Test
	public void testToHTMLTableString_05() {
		
		DataTable<Integer> d = new DataTable<>(3);
		
		assertEquals("", d.toHTMLTableString(true));
		
	}
	

}

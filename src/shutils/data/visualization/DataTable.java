package shutils.data.visualization;

import java.util.ArrayList;

public class DataTable <T> {
	
	String[] headings;
	ArrayList<T[]> table;
	
	int columnNumber;
	
	// Test change
	
	
	
	private DataTable()
	{
		this.table = new ArrayList<T[]>();
	}
	
	public DataTable(int columnNumber)
	{
		this();
		
		this.columnNumber = columnNumber;
		this.headings = null;
	}
	
	public DataTable(String... headings)
	{		
		this();
		
		this.columnNumber = headings.length;
		this.headings = headings;
	}
	
	
	
	
	public void addRow(T[] row)
	{
		if (row.length != columnNumber)
			throw new IllegalArgumentException("The length of the new row is different from the"
					+ " one of the rows of the table");
		
		table.add(row);
	}
	
	public void removeRowAtIndex(int i)
	{
		if (i >= table.size())
			throw new IndexOutOfBoundsException("The index is greater than the current length of the table");
		
		table.remove(i);
	}
	
	
	
	
	
	public void setHeadings(String...newHeadings)
	{
		if (columnNumber != newHeadings.length)
			throw new IllegalArgumentException("The number of new headings differs from the number"
					+ " of columns of the table");
		
		headings = newHeadings;			
	}
	
	public String[] getHeadings()
	{
		return headings;
	}
	
	
	
	
	
	
	public int getRowCount()
	{
		return getRowCount(false);
	}
	
	public int getRowCount(boolean includeHeadings)
	{
		if (includeHeadings)
			return table.size() + 1;
		else
			return table.size();
	}
	
	
	
	@Override
	public String toString()
	{
		return toCSVTableString(true);
	}
	
	public String toCSVTableString(boolean includeHeadings)
	{
		return "";
	}
	
	public String toLatexTableString(boolean includeHeadings)
	{
		return "";
	}
	
	public String toMatlabMatrixString(boolean includeHeadings)
	{
		return "";
	}
	
	public String toHTMLTableString(boolean includeHeadings)
	{
		return "";
	}

}

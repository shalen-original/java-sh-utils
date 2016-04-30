package shutils.data.visualization;

import java.util.ArrayList;

public class DataTable <T> {
	
	String[] headings;
	ArrayList<T[]> table;
	
	int columnNumber;
	
	
	
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
		return getRowCount(true);
	}
	
	public int getRowCount(boolean includeHeadings)
	{
		if (includeHeadings)
			return table.size() + (headings == null ? 0 : 1);
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
		return toCSVTableString(includeHeadings, ";");
	}
	
	public String toCSVTableString(boolean includeHeadings, String separator)
	{
		StringBuilder ans = new StringBuilder();
		
		if (includeHeadings && headings != null)
		{
			ans.append(rowArrayToCSVString(headings, separator));		
		}
		
		for (T[] row : table)
		{
			ans.append(rowArrayToCSVString(row, separator));
		}
		
		if(ans.length() > 0)
			ans.delete(ans.length() - "\n".length(), ans.length());
		
		return ans.toString();
	}
	
	public String toLatexTableString(boolean includeHeadings)
	{
		StringBuilder ans = new StringBuilder();
		String CSV = toCSVTableString(includeHeadings, " & ");
		
		if (CSV.equals("")) return "";
		
		ans.append("\\begin{center}");
		ans.append("{");
		
			ans.append("\\renewcommand{\\arraystretch}{1.5}");
			ans.append("\\renewcommand{\\tabcolsep}{0.2cm}");
			
			ans.append("\\begin{tabular}{|c|c|c|c|}");
				ans.append("\\hline ");
				ans.append(CSV.replace("\n", "\\\\ \\hline "));
				ans.append("\\\\ \\hline ");
			ans.append("\\end{tabular}");
		
		ans.append("}");
		ans.append("\\end{center}");
		
		
		return ans.toString();
	}
	
	public String toMatlabMatrixString(String matrixName)
	{
		StringBuilder ans = new StringBuilder();
		String CSV = toCSVTableString(false, " ");
		
		ans.append(matrixName);
		ans.append(" = [");
		
		ans.append(CSV.replace("\n", ";"));
		
		ans.append("];");
		
		
		return ans.toString();
	}
	
	public String toHTMLTableString(boolean includeHeadings)
	{
		StringBuilder ans = new StringBuilder();
		String CSV = toCSVTableString(includeHeadings, "</td><td>");
		
		if (CSV.equals("")) return "";
		
		ans.append("<table>");
		
		ans.append("<tr><td>");
		ans.append(CSV.replace("\n", "</td></tr><tr><td>"));
		
		ans.append("</table>");
		
		
		return ans.toString();
	}
	
	
	private <E> String rowArrayToCSVString(E[] row, String separator)
	{
		StringBuilder ans = new StringBuilder();
		
		if (row.length == 0) return "";
		
		for (E rowElement : row)
		{
			ans.append(rowElement.toString());
			ans.append(separator);
		}
		
		if(ans.subSequence(ans.length() - separator.length(), ans.length()).equals(separator))
			ans.delete(ans.length() - separator.length(), ans.length());
		
		ans.append("\n");
		
		return ans.toString();
	}

}

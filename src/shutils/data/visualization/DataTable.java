package shutils.data.visualization;

import java.util.ArrayList;

/**
 * Basic implementation of a class that describes a table of data.
 * 
 * @author Matteo Nardini
 *
 * @param <T> The type of the data to be stored in the table
 */
public class DataTable <T> {
	
	/**
	 * Stores the headings of the current table. This field is needed because, usually, the type
	 * of the data held in the table will not be @code{String}.
	 */
	String[] headings;
	
	/**
	 * Stores all the data of the current table.
	 */
	ArrayList<T[]> table;
	
	/**
	 * The number of column of the current table. This value is immutable (e.g. can only be set
	 * when the object is created).
	 */
	int columnNumber;
	
	
	/**
	 * Private constructor, used to perform common tasks.
	 */
	private DataTable()
	{
		this.table = new ArrayList<T[]>();
	}
	
	/**
	 * Creates a new empty data table.
	 * @param columnNumber The number of columns of the new data table.
	 */
	public DataTable(int columnNumber)
	{
		this();
		
		this.columnNumber = columnNumber;
		this.headings = null;
	}
	
	/**
	 * Creates a new empty data table which defined headings.
	 * @param headings The list of String containing the headings of the data table.
	 */
	public DataTable(String... headings)
	{		
		this();
		
		this.columnNumber = headings.length;
		this.headings = headings;
	}
	
	
	
	/**
	 * Adds a row to the data table.
	 * @param row The row to be added.
	 * @throws IllegalArgumentException if the length of the row differs from the number of
	 * columns of the table.
	 */
	public void addRow(T[] row)
	{
		if (row.length != columnNumber)
			throw new IllegalArgumentException("The length of the new row is different from the"
					+ " one of the rows of the table");
		
		table.add(row);
	}
	
	/**
	 * Removes a row from the data table.
	 * @param i The index of the row to be removed.
	 * @throws IndexOutOfBoundsException If {@code i} is greater than the number of rows of the table
	 * or lower than zero.
	 */
	public void removeRowAtIndex(int i)
	{
		if (i >= table.size() || i < 0)
			throw new IndexOutOfBoundsException("The index is greater than the current length of the table or lower than zero");
		
		table.remove(i);
	}
	
	
	
	
	/**
	 * Sets the headings of the data table.
	 * @param newHeadings The list of String containing the new headings of the data table.
	 * @throws IllegalArgumentException If the number of headings differs from the number of column of the data table.
	 */
	public void setHeadings(String...newHeadings)
	{
		if (columnNumber != newHeadings.length)
			throw new IllegalArgumentException("The number of new headings differs from the number"
					+ " of columns of the table");
		
		headings = newHeadings;			
	}
	
	/**
	 * Returns the current headings of the data table.
	 * @return The current headings of the data table.
	 */
	public String[] getHeadings()
	{
		return headings;
	}
	
	
	
	
	
	/**
	 * Returns the row count of the current table, including the row reserved for headings.
	 * @return Returns the row count of the current table, , including the row reserved for headings.
	 */
	public int getRowCount()
	{
		return getRowCount(true);
	}
	
	/**
	 * Returns the row count of the current table. If {@code includeHeadings} is true, the count includes
	 * the row reserved for headings. Otherwise, it does not.
	 * @param includeHeadings Whether to include the headings row in the row count or not.
	 * @return Returns the row count of the current table. If {@code includeHeadings} is true, the count includes
	 * the row reserved for headings. Otherwise, it does not.
	 */
	public int getRowCount(boolean includeHeadings)
	{
		if (includeHeadings)
			return table.size() + (headings == null ? 0 : 1);
		else
			return table.size();
	}
	
	
	/**
	 * Returns the CSV String representation of the current table, including the headings
	 */
	@Override
	public String toString()
	{
		return toCSVTableString(true);
	}
	
	/**
	 * Returns the CSV String representation of the current table. If {@code includeHeadings} is true the 
	 * headings row is included, otherwise it is excluded.
	 * @param includeHeadings Whether to include the headings row in the string or not.
	 * @return Returns the CSV String representation of the current table.
	 */
	public String toCSVTableString(boolean includeHeadings)
	{
		return toCSVTableString(includeHeadings, ";");
	}
	
	/**
	 * Returns the CSV String representation of the current table. If {@code includeHeadings} is true the 
	 * headings row is included, otherwise it is excluded.
	 * @param includeHeadings Whether to include the headings row in the string or not.
	 * @param separator The separator to use for the CSV String.
	 * @return Returns the CSV String representation of the current table.
	 */
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
	
	
	/**
	 * Returns the Latex table string representation of the current table. If {@code includeHeadings} is true the 
	 * headings row is included, otherwise it is excluded.
	 * @param includeHeadings Whether to include the headings row in the string or not.
	 * @return Returns the Latex table string representation of the current table.
	 */
	public String toLatexTableString(boolean includeHeadings)
	{
		// This routines builds the internal of the Latex table by generating the CSV string
		// with the appropriate separator " & ". Then, the return characters "\n" are replaced
		// with the appropriate Latex delimiter.
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
	
	/**
	 * Returns the Matlab matrix string representation of the current table. If {@code includeHeadings} is true the 
	 * headings row is included, otherwise it is excluded.
	 * @param includeHeadings Whether to include the headings row in the string or not.
	 * @return Returns the Matlab matrix string representation of the current table.
	 */
	public String toMatlabMatrixString(String matrixName)
	{
		// This routines builds the Matlab matrix string by generating the CSV string
		// with the appropriate separator " ". Then, the return characters "\n" are replaced
		// with the appropriate Matlab delimiter.
		StringBuilder ans = new StringBuilder();
		String CSV = toCSVTableString(false, " ");
		
		ans.append(matrixName);
		ans.append(" = [");
		
		ans.append(CSV.replace("\n", ";"));
		
		ans.append("];");
		
		
		return ans.toString();
	}
	
	/**
	 * Returns the HTML table string representation of the current table. If {@code includeHeadings} is true the 
	 * headings row is included, otherwise it is excluded.
	 * @param includeHeadings Whether to include the headings row in the string or not.
	 * @return Returns the HTML table string representation of the current table.
	 */
	public String toHTMLTableString(boolean includeHeadings)
	{
		// This routines builds the HTML table string by generating the CSV string
		// with the appropriate separator "</td><td>". Then, the return characters "\n" are replaced
		// with the appropriate HTML delimiter "</td></tr><tr><td>".
		StringBuilder ans = new StringBuilder();
		String CSV = toCSVTableString(includeHeadings, "</td><td>");
		
		if (CSV.equals("")) return "";
		
		ans.append("<table>");
		
		ans.append("<tr><td>");
		ans.append(CSV.replace("\n", "</td></tr><tr><td>"));
		
		ans.append("</table>");
		
		
		return ans.toString();
	}
	
	/**
	 * Allows to convert a single row of the table in a CSV String.
	 * @param row The row to convert to CVS.
	 * @param separator The separator to use in the conversion.
	 * @return The array {@code row} as a CSV string.
	 */
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

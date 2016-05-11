package shutils.data.visualization;

import java.util.ArrayList;

/**
 * This class represents a data series for a plot.
 * @author Matteo Nardini
 * @param <T> The type of data contained in this series.
 */
public class PlotDataSeries <T> {

	DataTable<T> data;
	String seriesName;
	
	/**
	 * Creates a new two-dimensional data series without name.
	 */
	public PlotDataSeries()
	{
		this("");
	}
	
	/**
	 * Creates a new two-dimensional data series with a name.
	 * @param seriesName The name of the series.
	 */
	public PlotDataSeries(String seriesName)
	{
		this(seriesName, SeriesDimensions.TWO_DIMENSIONAL_SERIES);
	}
	
	/**
	 * Creates a new data series with the given name and number of dimensions.
	 * @param seriesName The name of the series.
	 * @param dim The number of dimensions of the series.
	 */
	public PlotDataSeries(String seriesName, SeriesDimensions dim)
	{
		this.seriesName = seriesName;
		
		data = new DataTable<T>(dim.getDimensionNumber());
	}
	
	/**
	 * Returns the number of row of the current series.
	 * @return The number of row of the current series.
	 */
	public Integer getRowCount()
	{
		return data.getRowCount(false);
	}
	
	/**
	 * Adds a new row to the current series.
	 * @param row The row to be added to the current series.
	 */
	public void addRow(T[] row)
	{
		data.addRow(row);
	}
	
	/**
	 * Removes a row from the current series.
	 * @param i The index of the row to be removed.
	 */
	public void removeRowAtIndex(int i)
	{
		data.removeRowAtIndex(i);
	}
	
	/**
	 * Returns the name of the current series.
	 * @return The name of the current series.
	 */
	public String getSeriesName() {
		return seriesName;
	}

	/**
	 * Sets the name of the current series.
	 * @param seriesName The new name of the current series.
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	
	/**
	 * Returns all the data contained in a dimension of the current series as a list.
	 * @param dimension The dimension which data have to be extracted.
	 * @return The list of all the data contained in the {@code dimension} dimension of the current series.
	 */
	public ArrayList<T> getAxisData(int dimension)
	{
		ArrayList<T> ans = new ArrayList<T>();
		
		for (int i = 0; i < data.getRowCount(false); i++)
		{
			ans.add(data.getRow(i)[dimension]);
		}
		
		return ans;
	}
	
	/**
	 * Allows to fill the entire graph on a "per-dimension" basis. Instead of adding the data point to point to the graph,
	 * this methods takes {@code n} arrays, each of which represents a dimension of the series and contains all the data for that dimension.
	 * Therefore, the {@code i}-th point of the plot will have its dimension one value in the first array, its dimension two value in the second array and so on.
	 * @param newData The list of all the {@code n} arrays.
	 */
	public void fillWithData(ArrayList<T[]> newData)
	{
		@SuppressWarnings("unchecked")
		T[] a = (T[]) new Object[data.getColumnNumber()];
		for (int i = 0; i < newData.size(); i++)
		{
			if (newData.get(i).length != data.getColumnNumber())
				throw new IllegalArgumentException("The number of elements in each row of the new data has to be equal to the number of dimensions of this series.");
			
			for (int j = 0; j < data.getColumnNumber(); j++)
			{
				a[j] = newData.get(i)[j];
			}
			addRow(a);
		}
	}
	
	
}

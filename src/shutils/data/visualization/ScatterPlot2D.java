package shutils.data.visualization;

import java.util.ArrayList;

public class ScatterPlot2D <T> {

	private String title;
	private String xAxisLabel;
	private String yAxisLabel;
	
	ArrayList<PlotDataSeries<T>> series;
	
	
	public ScatterPlot2D() {
		this("");
	}
	
	public ScatterPlot2D(String title) {
		this(title, "", "");
	}
	
	public ScatterPlot2D(String title, String xAxisLabel, String yAxisLabel) {
		this.title = title;
		this.xAxisLabel = xAxisLabel;
		this.yAxisLabel = yAxisLabel;
		
		series = new ArrayList<PlotDataSeries<T>>();
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getXAxisLabel() {
		return xAxisLabel;
	}
	public void setXAxisLabel(String xAxisLabel) {
		this.xAxisLabel = xAxisLabel;
	}
	public String getYAxisLabel() {
		return yAxisLabel;
	}
	public void setYAxisLabel(String yAxisLabel) {
		this.yAxisLabel = yAxisLabel;
	}
	
	
	public void addDataSeries(PlotDataSeries<T> newSeries) {
		series.add(newSeries);
	}
	
	public void removeDataSeriesAtIndex(int i) {
		series.remove(i);
	}
	
	public PlotDataSeries<T> getDataSeries(int i) {
		return series.get(i);
	}
	
	public int getDataSeriesCount() {
		return series.size();
	}
	
	
	public String plotToLatexPGFPlotString() {
		StringBuilder ans = new StringBuilder();
		
		ans.append("% Hey, remember to add these on top of the document:\n");
    	ans.append("%\t \\usepackage{pgfplots}\n");
    	ans.append("%\t \\pgfplotsset{compat=1.6}\n\n");
		
		ans.append("\\begin{tikzpicture}");
		
		
		
		ans.append("\\end{tikzpicture}");
		
		
		return ans.toString();
	}
	
	
}

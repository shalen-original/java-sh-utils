package shutils.tests.data.visualization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import shutils.data.visualization.PlotDataSeries;
import shutils.data.visualization.ScatterPlot2D;

public class ScatterPlot2DTest {

	@Test
	public void testScatterPlot2D() {
		@SuppressWarnings("unused")
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>();
	}

	@Test
	public void testScatterPlot2DString() {
		@SuppressWarnings("unused")
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test");
	}

	@Test
	public void testScatterPlot2DStringStringString() {
		@SuppressWarnings("unused")
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
	}

	@Test
	public void testGetTitle() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
	
		assertEquals("test", a.getTitle());
	}

	@Test
	public void testSetTitle() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		a.setTitle("test2");
		assertEquals("test2", a.getTitle());
	}

	@Test
	public void testGetxAxisLabel() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		
		assertEquals("testx", a.getXAxisLabel());
	}

	@Test
	public void testSetxAxisLabel() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		a.setXAxisLabel("test2");
		assertEquals("test2", a.getXAxisLabel());
	}

	@Test
	public void testGetyAxisLabel() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		
		assertEquals("testy", a.getYAxisLabel());
	}

	@Test
	public void testSetyAxisLabel() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		a.setYAxisLabel("test2");
		assertEquals("test2", a.getYAxisLabel());
	}

	@Test
	public void testAddDataSeries() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		PlotDataSeries<Integer> b = new PlotDataSeries<>();
		a.addDataSeries(b);
	}

	@Test
	public void testRemoveDataSeriesAtIndex() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		PlotDataSeries<Integer> b = new PlotDataSeries<>();
		a.addDataSeries(b);
		a.removeDataSeriesAtIndex(0);
	}

	@Test
	public void testGetDataSeries() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		PlotDataSeries<Integer> b = new PlotDataSeries<>();
		a.addDataSeries(b);

		assertEquals(a.getDataSeries(0).equals(b), true);
	}

	@Test
	public void testGetDataSeriesCount() {
		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "testx", "testy");
		PlotDataSeries<Integer> b = new PlotDataSeries<>();
		a.addDataSeries(b);
		
		assertEquals(1, a.getDataSeriesCount());
	}

	@Test
	public void testPlotToLatexPGFPlotString() {

		ScatterPlot2D<Integer> a = new ScatterPlot2D<Integer>("test", "$x$", "$x^2$");

		PlotDataSeries<Integer> b = new PlotDataSeries<>();
		Integer[] x = {1, 2, 3, 4};
		Integer[] y = {3, 2, 6, 1};
		
		
		
		a.addDataSeries(b);
		
		fail("Not implemented");
		
	}

}

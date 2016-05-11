package shutils.tests.data.visualization;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import shutils.data.visualization.PlotDataSeries;
import shutils.data.visualization.SeriesDimensions;

public class PlotDataSeriesTest {

	@Test
	public void testPlotDataSeries() {
		@SuppressWarnings("unused")
		PlotDataSeries<Integer> a = new PlotDataSeries<>();
	}

	@Test
	public void testPlotDataSeriesString() {
		@SuppressWarnings("unused")
		PlotDataSeries<Integer> a = new PlotDataSeries<>("test");
	}
	
	@Test
	public void testPlotDataSeriesStringSeriesDimensions() {
		@SuppressWarnings("unused")
		PlotDataSeries<Integer> a = new PlotDataSeries<>("test", SeriesDimensions.THREE_DIMENSIONAL_SERIES);
	}

	@Test
	public void testGetRowCount() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>();
		
		Integer[] b = {1, 2};
		a.addRow(b);
		a.addRow(b);
		
		assertEquals(true, a.getRowCount() == 2);
	}

	
	
	@Test
	public void testAddRow_00() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>();
		
		Integer[] b = {1, 2};
		a.addRow(b);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddRow_01() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>("test", SeriesDimensions.THREE_DIMENSIONAL_SERIES);
		
		Integer[] b = {1, 2, 3, 4};
		a.addRow(b);
	}

	
	
	@Test
	public void testRemoveRowAtIndex() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>();
		Integer[] b = {1, 2};
		a.addRow(b);
		a.removeRowAtIndex(0);
	}

	@Test
	public void testGetAxisData() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>();
		
		Integer[] b = {1, 2};
		a.addRow(b);
		
		Integer[] c = {3, 4};
		a.addRow(c);
		
		Integer[] ans = {1, 3};
		
		ArrayList<Integer> d = a.getAxisData(0);
		for(int i = 0; i < a.getRowCount(); i++)
		{
			if (d.get(i) != ans[i])
				fail("The wrong data has been returned");
		}
	}

	@Test
	public void testGetSeriesName() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>("test");
		
		assertEquals("test", a.getSeriesName());
	}

	@Test
	public void testSetSeriesName() {
		PlotDataSeries<Integer> a = new PlotDataSeries<>();
		
		a.setSeriesName("testw");
		
		assertEquals("testw", a.getSeriesName());
	}
	
	@Test
	public void testFillWithData() {
		fail("Not implemented yet");
	}

}

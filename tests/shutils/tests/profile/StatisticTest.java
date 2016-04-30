package shutils.tests.profile;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import shutils.profile.Statistic;

/**
 * Test cases for the shutils.profile.Statistic class
 * @author Matteo Nardini
 *
 */
public class StatisticTest {
	
	Statistic s;
	
	/*
	 *  TEST SETUP
	 */
	
	@Before
	public void beforeEach()
	{
		if (s == null)
		{
			s = new Statistic();
		}
		
		if (s.getNumberCount() == 0)
		{
			s.appendNumber((long)1234);
			s.appendNumber((long)4738);
			s.appendNumber((long)7942);
			s.appendNumber((long)6732);
			s.appendNumber((long)7963);
		}
	}
	
	
	/*
	 * 	getAverage
	 */
	@Test
	public void testGetAverage_00() {		
		assertEquals((long)5721, (long)s.getAverage());
	}
	@Test
	public void testGetAverage_01() {
		s.clearResults();
		assertEquals((long)0, (long)s.getAverage());
	}

	

	/*
	 *  getStDev
	 */
	@Test
	public void testGetStDev_00() {	
		assertEquals((long)2533, (long)s.getStDev());
		
	}
	@Test
	public void testGetStDev_01() {
		s.clearResults();
		assertEquals((long)0, (long)s.getStDev());
		
	}

	
	
	
	/*
	 *   getMedian
	 */
	@Test
	public void testGetMedian_00() {
		assertEquals((long)6732, (long)s.getMedian());
		
	}
	@Test
	public void testGetMedian_01() {
		s.clearResults();
		assertEquals((long)0, (long)s.getMedian());
		
	}

}

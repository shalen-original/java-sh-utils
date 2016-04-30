package shutils.profile;

import java.util.ArrayList;
import java.util.Collections;


/**
 * This class represents a set of number of type Long and allows to perform statistical operations on them.
 * @author Matteo Nardini
 *
 */
public class Statistic
{
	/**
	 * The list of number of the current set
	 */
	ArrayList<Long> results;
	
	/**
	 * Creates a new statistic for an empty set of numbers.
	 */
	public Statistic()
	{
		results = new ArrayList<Long>();
	}
	
	/**
	 * Adds a number to the current set of numbers.
	 * @param r The number to be added.
	 */
	public void appendNumber(Long r)
	{
		results.add(r);
	}
	
	/**
	 * Empties the result set.
	 */
	public void clearResults()
	{
		results.clear();
	}
	
	/**
	 * Calculates the average of the current set of numbers (floored to the closest Long).
	 * @return The average of the set of numbers (floored to the closest Long).
	 */
	public Long getAverage()
	{
		if (results.size() == 0) return (long)0;
		
		long avg = 0;
		
		for (long a : results)
		{
			avg += a;
		}
		
		return avg / results.size();
	}
	
	/**
	 * Calculates the standard deviation of the current set of numbers (floored to the closest Long).
	 * @return The standard deviation of the set of numbers (floored to the closest Long).
	 */
	public Long getStDev()
	{
		if (results.size() == 0) return (long)0;
		
		long StDev = 0;
		long avg = getAverage();
		
		for (Long a : results)
		{
			StDev += Math.pow(a - avg, 2);
		}
		
		StDev /= results.size();
		
		return (long) Math.sqrt(StDev);
	}
	
	/**
	 * Calculates the median of the current set of numbers (floored to the closest Long).
	 * @return The median of the set of numbers (floored to the closest Long).
	 */
	public Long getMedian()
	{
		
		if (results.size() == 0) return (long)0;
		
		Collections.sort(results);
		int s = results.size();
		
		if (s % 2 == 0)
		{
			return (results.get(s / 2) + results.get((s / 2) + 1)) / 2;
		}else{
			return results.get(s / 2);
		}
	}
	
	/**
	 * Returns the number at a certain index of the numbers list.
	 * @param index The index of the result to be obtained.
	 * @return The number at the position {@code i-th} in the numbers list.
	 */
	public Long getNumberAt(int index)
	{
		return results.get(index);
	}
	
	/**
	 * Returns the number of numbers in the current numbers list.
	 * @return The number of numbers in the current numbers list.
	 */
	public Integer getNumberCount()
	{
		return results.size();
	}
}

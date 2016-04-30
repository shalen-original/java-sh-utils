package shutils.profile;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Internal utility. Allows to represent a set of values and to perform statistical calculations on it. 
 * @author Matteo Nardini
 *
 */
public class Statistic
{
	ArrayList<Long> results;
	
	public Statistic()
	{
		results = new ArrayList<Long>();
	}
	
	public void appendResult(Long r)
	{
		results.add(r);
	}
	
	public void clearResults()
	{
		results.clear();
	}
	
	public Long getAverage()
	{
		long avg = 0;
		
		for (long a : results)
		{
			avg += a;
		}
		
		return avg / results.size();
	}
	
	public Long getStDev()
	{
		long StDev = 0;
		long avg = getAverage();
		
		for (Long a : results)
		{
			StDev += Math.pow(a - avg, 2);
		}
		
		StDev /= results.size();
		
		return (long) Math.sqrt(StDev);
	}
	
	public Long getMedian()
	{
		Collections.sort(results);
		int s = results.size();
		
		if (s % 2 == 0)
		{
			return (results.get(s / 2) + results.get((s / 2) + 1)) / 2;
		}else{
			return results.get(s / 2);
		}
	}
	
	public Long getResultAt(int index)
	{
		return results.get(index).longValue();
	}
}

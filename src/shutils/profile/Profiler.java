package shutils.profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * This class allows to profile a simple algorithm which requires as a parameter a single
 * parameter of type T. This class internally uses @code{System.nanoTime()} to compute the
 * running time of the algorithm. However, this class does not guarantee a nanosecond precision.
 * @author Matteo Nardini
 *
 * @param <T> The type of the parameter accepted by the algorithm to be profiled.
 */
public class Profiler<T> {
	
	/*
	 * -----------------------------
	 * 		INTERNAL FIELDS
	 * -----------------------------
	 * 
	 */
	
	/**
	 * The method/algorithm to be profiled.
	 */
	private Consumer<T> algorithm;
	
	/**
	 * The method that allows to generate on the fly a test input set.
	 */
	private Function<Integer, T> inputProducer;
	
	/**
	 * The method that copies one of the elements of the test list. This is needed to run
	 * multiple time the same test.
	 */
	private Function<T, T> copyProducer;
	
	/**
	 * The input set to use in order to profile the desired method.
	 */
	private List<T> inputSet;
	
	/**
	 * Reports if the current test set has already been profiled or not.
	 */
	private boolean profiledForCurrentSet;
	
	/**
	 * Contains the results of the profiling.
	 */
	private ArrayList<Statistic> results;
	
	/**
	 * Contains general statistics elaborated from the profiling of the method.
	 */
	private Statistic globalStatistics;
	
	/**
	 * Stores the number of time every entry of the inputSet has been tested
	 * during the last test
	 */
	private int lastTestRepetition;
	
	
	
	
	
	
	/*
	 * -----------------------------
	 * 		CONSTRUCTORS
	 * -----------------------------
	 * 
	 */
	
	/**
	 * Internal constructor, used to initialized most of the internal details of the class.
	 * @param algorithm The method/algorithm to be profiled.
	 * @param copyProducer The routine that copies a given element of the test set. This is required
	 * in order to repeat the test multiple times.
	 */
	private Profiler(Consumer<T> algorithm, Function<T, T> copyProducer)
	{
		this.algorithm = algorithm;
		this.copyProducer = copyProducer;
		
		profiledForCurrentSet = false;
		
		results = new ArrayList<Statistic>();
		globalStatistics = new Statistic();
	}
	
	/**
	 * Initializes this profiled with a certain algorithm to be profiled and a certain input
	 * test used to profile it.
	 * @param algorithm The algorithm to be profiled.
	 * @param inputSet The test input set to be used to profile the algorithm.
	 * @param copyProducer The routine that copies a given element of the test set. This is required
	 * in order to repeat the test multiple times.
	 */
	public Profiler(Consumer<T> algorithm, List<T> inputSet, Function<T, T> copyProducer)
	{
		this(algorithm, copyProducer);
		this.inputSet = inputSet;
		this.inputProducer = null;
		
	}
	
	/**
	 * Initializes this profiler with a certain algorithm to be profiled and a certain input
	 * generator which can be used to generate the test input set that allows to profile the algorithm.
	 * @param algorithm The algorithm to be profiled.
	 * @param inputSet The test input set generator to be used to create the test set
	 * required to profile the algorithm.
	 * @param copyProducer The routine that copies a given element of the test set. This is required
	 * in order to repeat the test multiple times.
	 */
	public Profiler(Consumer<T> algorithm, Function<Integer, T> inputProducer, Function<T, T> copyProducer)
	{
		this(algorithm, copyProducer);
		this.inputSet = null;
		this.inputProducer = inputProducer;
	}
	
	
	
	
	
	
	/*
	 * -----------------------------
	 * 		INPUT SET HANDLING
	 * -----------------------------
	 * 
	 */
	
	/**
	 * Allows to check if the current test input set has already been used to profile the algorithm
	 * or not. This method also allows to know if the result of the profiling are already available or not.
	 * @return This method returns @code{true} if the current test input set has already been profiled and
	 * the results are ready. This method returns @code{false} if the current test input set has <b>NOT</b>
	 * already been profiled. In this second case, the results and the statistics for this set are not
	 * available.
	 */
	public boolean isCurrentSetAlreadyProfiled()
	{
		return profiledForCurrentSet;
	}
	
	/**
	 * This method allows to update the test input set to be used to profile the algorithm.
	 * It also resets any previously computed result and/or statistic.
	 * @param newInputSet The new input set that will be used to profile the algorithm
	 */
	public void updateInputSet(List<T> newInputSet)
	{
		profiledForCurrentSet = false;
		inputSet = newInputSet;
		
		cleanPreviousResults();
	}	
 	
	/**
	 * This method allows to update the test input set to be used to profile the algorithm by
	 * using the @code{inputProducer} function provided. This method will call the @code{inputProducer}
	 * function @code{max-min} times. At each call, an increasing counter will be passed to the function.
	 * For example, the first call will receive as a parameter @{min}, the second @{min + 1} and so on
	 * until @code{max} is reached.
	 * @param min The lower bound of the interval to be used to generate the input set.
	 * @param max The upper bound of the interval to be used to generate the input set.
	 * @throws NullPointerException When the @code{inputProducer} function is not defined.
	 * @throws IllegalArgumentException When the @code{min} is greater then @code{max}.
	 */
	public void updateInputSet(int min, int max)
	{
		if (inputProducer == null) throw new NullPointerException("Input generator not defined");
		if (min > max) throw new IllegalArgumentException("Min should be lower or equal than max");
		
		List<T> tmp = new ArrayList<T>();
		
		for (int i = min; i <= max; i++)
		{
			inputSet.add(inputProducer.apply(i));
		}
		
		updateInputSet(tmp);
	}
	
	/**
	 * Internal routine that cleans the previous results
	 */
	private void cleanPreviousResults()
	{
		results.clear();	
		globalStatistics.clearResults();
	}
	
	
	
	
	
	
	
	/*
	 * -----------------------------
	 * 		PROFILING
	 * -----------------------------
	 * 
	 */
	
	/**
	 * Profiles the algorithm with the given test input set.
	 * @param numberOfTimeToTestEachInput Is the number of time each element of the input set will be tested.
	 * @throws NullPointerException If the test input set is not defined.
	 */
	public void performTest(int numberOfTimeToTestEachInput)
	{
		if (inputSet == null) throw new NullPointerException("Test set is not defined");
		
		lastTestRepetition = numberOfTimeToTestEachInput;
		cleanPreviousResults();
		
		T tmpCopy;
		Statistic tmpStat;
		long tmp;
		
		for (int i = 0; i < inputSet.size(); i++)
		{
			tmpStat = new Statistic();
			
			for (int k = 0; k < numberOfTimeToTestEachInput; k++)
			{
				tmpCopy = copyProducer.apply(inputSet.get(i));
				
				tmp = System.nanoTime();
				algorithm.accept(tmpCopy);
				tmp = System.nanoTime() - tmp;
				
				tmpStat.appendResult(tmp);	
				globalStatistics.appendResult(tmp);
			}
						
			results.add(tmpStat);
		}
		
		profiledForCurrentSet = true;
	}
	
	
	
	
	
	
	
	/*
	 * -----------------------------
	 * 		GETTERS
	 * -----------------------------
	 * 
	 */
	
	/**
	 * Method that returns the average between all the time spend for every attempt of every element
	 * of the input set.
	 */
	public long getGlobalAverage()
	{
		return globalStatistics.getAverage();
	}
	
	/**
	 * Method that returns the standard deviation between all the time spend for every attempt of every element
	 * of the input set.
	 */
	public long getGlobalStDev()
	{
		return globalStatistics.getStDev();
	}
	
	/**
	 * Method that returns the median between all the time spend for every attempt of every element
	 * of the input set.
	 */
	public long getGlobalMedian()
	{
		return globalStatistics.getMedian();
	}
	
	
	/**
	 * Method that returns the average of the time spend to test a particular element
	 * of the input set.
	 * @param i The index of the element in the input set
	 * @return The average of the time spend to test the @code{i-th} element of the input set.
	 */
	public long getResultAverage(int i)
	{
		return results.get(i).getAverage();
	}
	
	/**
	 * Method that returns the standard deviation of the time spend to test a particular element
	 * of the input set.
	 * @param i The index of the element in the input set
	 * @return The standard deviation of the time spend to test the @code{i-th} element of the input set.
	 */
	public long getResultStDev(int i)
	{
		return results.get(i).getStDev();
	}
	
	/**
	 * Method that returns the median of the time spend to test a particular element
	 * of the input set.
	 * @param i The index of the element in the input set
	 * @return The median of the time spend to test the @code{i-th} element of the input set.
	 */
	public long getResultMedian(int i)
	{
		return results.get(i).getMedian();
	}
	
	
	
	/*
	 * -----------------------------
	 * 		LATEX GETTERS
	 * -----------------------------
	 * 
	 */
	
	
	/**
	 * Returns a valid Latex Table as a string.
	 * @return The Latex Table string containing the global results of the last test.
	 */
	public String globalResultsToLatexString()
	{
		StringBuilder ans = new StringBuilder();
			
		ans.append("\\begin{center}");
		ans.append("{");
		
			ans.append("\\renewcommand{\\arraystretch}{1.5}");
			ans.append("\\renewcommand{\\tabcolsep}{0.2cm}");
			
			ans.append("\\begin{tabular}{|c|c|c|c|}");
				ans.append("\\hline ");
				ans.append("Number of tests & Global average [ns] & Global st. dev. [ns] & Global median [ns] \\\\");
				
					ans.append("\\hline ");
					ans.append(results.size() + " & ");
					ans.append(globalStatistics.getAverage() + " & ");
					ans.append(globalStatistics.getStDev() + " & ");
					ans.append(globalStatistics.getMedian() + " \\\\ ");
				
				ans.append("\\hline ");
			ans.append("\\end{tabular}");
		
		ans.append("}");
		ans.append("\\end{center}");
		
		
		return ans.toString();
	}	
	
	/**
	 * Returns a valid Latex Table as a string.
	 * @return The Latex Table string containing the results summary of the last test.
	 */
	public String resultSummaryToLatexString()
	{
		StringBuilder ans = new StringBuilder();
		
		ans.append("\\begin{center}");
		ans.append("{");
		
			ans.append("\\renewcommand{\\arraystretch}{1.5}");
			ans.append("\\renewcommand{\\tabcolsep}{0.2cm}");
			
			ans.append("\\begin{tabular}{|c|c|c|c|}");
				ans.append("\\hline ");
				ans.append("Test number & Average (" + lastTestRepetition + " attempts) [ns] & St. dev. (" + lastTestRepetition + " attempts) [ns] & Median (" + lastTestRepetition + " attempts) [ns]\\\\");
				
				for (int i = 0; i < results.size(); i++)
				{
					ans.append("\\hline ");
					ans.append(i + 1 + " & ");
					ans.append(results.get(i).getAverage() + " & ");
					ans.append(results.get(i).getStDev() + " & ");
					ans.append(results.get(i).getMedian() + " \\\\ ");
				}
				
				ans.append("\\hline ");
			ans.append("\\end{tabular}");
		
		ans.append("}");
		ans.append("\\end{center}");
		
		return ans.toString();
	}

	/**
	 * Returns a valid Latex Table as a string.
	 * @return The Latex Table string containing the results details of the last test.
	 */
	public String resultDetailsToLatexString()
	{
		
		StringBuilder tabDeclaration = new StringBuilder();
		tabDeclaration.append("|");
		// +2 allows to add the "Test number" column and the "Average" column
		for (int i = 0; i < lastTestRepetition + 2; i++)
		{
			tabDeclaration.append("c|");
		}
		
		StringBuilder header = new StringBuilder();
		header.append("N & ");
		for (int i = 0; i < lastTestRepetition; i++)
		{
			header.append("T ");
			header.append(i + 1);
			header.append(" & ");
		}
		header.append("Average [ns] \\\\");
		
		
		StringBuilder ans = new StringBuilder();
		
		ans.append("\\begin{center}");
		ans.append("{");
		
			ans.append("\\renewcommand{\\arraystretch}{1.5}");
			ans.append("\\renewcommand{\\tabcolsep}{0.2cm}");
			
			ans.append("\\begin{tabular}{" + tabDeclaration.toString() + "}");
				ans.append("\\hline ");
				ans.append(header.toString());
				
				for (int i = 0; i < results.size(); i++)
				{
					ans.append("\\hline ");
					ans.append(i + 1 + " & ");
					for (int k = 0; k < lastTestRepetition; k++)
					{
						ans.append(results.get(i).getResultAt(k) + " & ");
					}
					ans.append(results.get(i).getAverage() + "\\\\");
				}
				
				ans.append("\\hline ");
			ans.append("\\end{tabular}");
		
		ans.append("}");
		ans.append("\\end{center}");
		
		return ans.toString();
	}
	
	

	
	/**
	 * Internal utility. Allows to represent a set of values and to perform statistical calculations on it. 
	 * @author Matteo Nardini
	 *
	 */
	private class Statistic
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
	
	
}

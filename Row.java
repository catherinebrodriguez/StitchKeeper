package stitchCounter;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Row
{
	private static int numRows = 0; 	// total number of rows in pattern
	
	private int currRowNum;     		// the row number in pattern
	private int numInPrevRow;   		// num sts from the prev row
	
	private int numIntoCurrRow;			// num sts into current row
	private int numIntoPrevRow;			// num sts into previous row
	
	private List<Stitch> stsArr; 	// list of stitches in row
	
	public Row()
	{
		numRows++; 
		
		currRowNum = numRows;
		numInPrevRow = 0;
		
		numIntoCurrRow = 0;
		numIntoCurrRow = 0;
		
		stsArr = new ArrayList<Stitch>();
		
	} // end default constructor

	public Row(int numCastOn)
	{
		numRows++; 
		
		currRowNum = numRows;
		numInPrevRow = numCastOn;
		
		numIntoCurrRow = 0;
		numIntoCurrRow = 0;
		
		stsArr = new ArrayList<Stitch>();
		
		
	} // end non-default constructor

	public static int getNumRows()
	{
		return numRows;
	}

	public static void setNumRows(int numRows)
	{
		Row.numRows = numRows;
	}

	public int getCurrRowNum()
	{
		return currRowNum;
	}

	public void setCurrRowNum(int currRowNum)
	{
		this.currRowNum = currRowNum;
	}

	public int getNumInPrevRow()
	{
		return numInPrevRow;
	}

	public void setNumInPrevRow(int numInPrevRow)
	{
		this.numInPrevRow = numInPrevRow;
	}

	public int getNumIntoCurrRow()
	{
		return numIntoCurrRow;
	}

	public void setNumIntoCurrRow(int numIntoCurrRow)
	{
		this.numIntoCurrRow = numIntoCurrRow;
	}

	public int getNumIntoPrevRow()
	{
		return numIntoPrevRow;
	}

	public void setNumIntoPrevRow(int numIntoPrevRow)
	{
		this.numIntoPrevRow = numIntoPrevRow;
	}

	public List<Stitch> getStsArr()
	{
		return stsArr;
	}

	public void setStsArr(List<Stitch> stsArr)
	{
		this.stsArr = stsArr;
	}

	public List<Stitch> copyStsArr(List<Stitch> arr)
	{
		List<Stitch> copyArr = new ArrayList<Stitch>(arr);
		
		return copyArr;
	}

	public void processRow(Row row, String passedRow)
	{	
		String[] splitRow = passedRow.split("\\s*,\\s*");
		List<String> strRowArr = new ArrayList<String>(Arrays.asList(splitRow));
		
		boolean isSer = false;	// if within a [] series
		boolean isAst = false;  // if within a * series
		boolean isAdd = false;
		boolean astComplete = false;
		
		int counter= 0;
		int indSerStart = 0;	// index of the first stitch in [] series
		int indAstStart = 0;	// index of the first stitch in * series
		
		int repeats = 1; 		// number of repeats in a series
		int astRepeats = 0;     // number of repeats in an ast
		int numStAst = 0;
		
		int numStRemaining;
		int digit = 1;
		
		String letters = "";
		String repStr = "";     // the repeating pattern
		String stAfterAst = ""; // first stitch after an asterisk 
		  
		// FOR TEST print the split ArrayList
		//for(String strSt : strRowArr)
		//	System.out.println(strSt);
		
		// list iterator to add stitches to list as they are processed
		ListIterator<String> litr = strRowArr.listIterator();
		 
		// FOR TEST print num stitches in previous row
		System.out.println("\nnum in prev: " + getNumInPrevRow());
		
		while(litr.hasNext())
		{
			repeats = 1; // default number of times a stitch is performed
			astComplete = false;
			
			Stitch newStitch = new Stitch(); // new stitch object
			
			newStitch.setRowNum(currRowNum); // set row number of stitch
			
			String st = litr.next(); // get the next stitch in list
			 	
			// if row has ast series
			if(st.indexOf('*') != -1)
			{ 
				isAdd = true;
				
				stAfterAst = st.substring(st.indexOf('*')+1).trim();
				st = st.substring(0, st.indexOf('*'));
				 
				 
			} // end if '*' found
			
			newStitch.setAst(isAst);
			newStitch.setIndexOfAstStart(indAstStart);
			
			if(st.indexOf(';') != -1)
			{ 
				astComplete = true;
				
				repStr = st.substring(st.indexOf(';')+1).trim();
				st = st.substring(0, st.indexOf(';'));
				isAst = false;
				 
				try
				{ 
					Pattern pAstRepeats = Pattern.compile("(\\*+|rep|;|across)");
					Matcher matchAstRepeats = pAstRepeats.matcher(repStr);

					// check for a series
					if (matchAstRepeats.find())
					{
						 
						
					} // end if matchRepeats pattern found
					
					//chris@rajapet.net 
				} // end try check pattern num repeats
				catch(Exception e)
				{
					
				}
			
			} // end if ';' found
			
			if(st.indexOf('[') != -1) // check if '['
			{
				isSer = true;
				indSerStart = stsArr.size();
				st = st.replace("[","");
				
			} // end if ']' found
			
			newStitch.setSeries(isSer);
			newStitch.setIndexOfSeriesStart(indSerStart);
			
			if(st.indexOf(']') != -1) // check if ']'
			{
				// get the instruction for number of repeats 
				repStr = st.substring(st.indexOf(']')+1).trim();
				
				st = st.replace(st.substring(st.indexOf(']')), "");
								
				isSer = false;
				
				try
				{ 					
					Pattern pLetter = Pattern.compile("([a-zA-Z]+)");
					Matcher matchLetter = pLetter.matcher(repStr);

					Pattern pDigit = Pattern.compile("(\\d+)");
					Matcher matchDigit = pDigit.matcher(repStr);

					Pattern pRepeats = Pattern.compile("\\s*(\\w*)\\s*(times|x)");
					Matcher matchRepeats = pRepeats.matcher(repStr);
 
					// check for a series
					if (matchRepeats.find())
					{
						matchDigit = pDigit.matcher(matchRepeats.group(1));
						matchLetter = pLetter.matcher(matchRepeats.group(1));

						if (matchDigit.find())
							repeats = Integer.valueOf(matchDigit.group());
							 
						else if (matchLetter.find())
						{
							// System.out.println("is word");
							letters = String.valueOf(matchLetter.group());

							// initialize stType with some value (possibly ERROR)
							StitchLibrary stType = StitchLibrary.getStitchType(letters.toUpperCase());

							// check if valid stitch
							if (StitchLibrary.isValidStitch(letters.toUpperCase()))
								stType = StitchLibrary.valueOf(letters.toUpperCase());

							// check for alias
							else if (StitchLibrary.getStitchType(letters.toUpperCase()) != StitchLibrary.ERROR)
								stType = StitchLibrary.getStitchType(letters.toUpperCase());
							
							repeats = stType.getValue();
							 
						} // end else match letter
						
					} // end if matchRepeats pattern found
					
					
					
					//chris@rajapet.net 
				} // end try check pattern num repeats
				catch(Exception e)
				{
					
				}
				
			} // end if ']' found
			
			try
			{
				Pattern pLetterDigit = Pattern.compile("([a-zA-Z]+)\\s*(\\d+)");
				Matcher matchLetterDigit = pLetterDigit.matcher(st);

				Pattern pLetter = Pattern.compile("([a-zA-Z]+)");
				Matcher matchLetter = pLetter.matcher(st);

				Pattern pDigit = Pattern.compile("(\\d+)");
				Matcher matchDigit = pDigit.matcher(st);
   
				// check if a letter+digit or letter pattern is found
				if (matchLetterDigit.find() || matchLetter.find())
				{
					// reset the matchers
					matchLetterDigit.reset();
					matchLetter.reset();
					matchDigit.reset();
					
					// get the letter and digit of stitch
					if (matchLetterDigit.find())
					{
						letters = String.valueOf(matchLetterDigit.group(1));
						digit = Integer.valueOf(matchLetterDigit.group(2));
					}
					else if (matchLetter.find())
					{
						letters = String.valueOf(matchLetter.group());
						digit = 1; // curr stitch is performed once
					}

					// initialize stType with some value (possibly ERROR)
					StitchLibrary stType = StitchLibrary.getStitchType(letters.toUpperCase());
					
					// check if valid stitch
					if (StitchLibrary.isValidStitch(letters.toUpperCase()))
						stType = StitchLibrary.valueOf(letters.toUpperCase());

					// check for alias
					else if (StitchLibrary.getStitchType(letters.toUpperCase()) != StitchLibrary.ERROR)
						stType = StitchLibrary.getStitchType(letters.toUpperCase());

					// check which row to update counters
					if (StitchLibrary.isValidStitch(letters.toUpperCase())
							|| StitchLibrary.getStitchType(letters.toUpperCase()) != StitchLibrary.ERROR)
					{
						numIntoCurrRow = numIntoCurrRow + (stType.getValue() * digit);
						numIntoPrevRow = numIntoPrevRow + (stType.getNumStIntoPrevRow() * digit);
					
						newStitch.setNumIntoCurrRow(numIntoCurrRow);
						newStitch.setNumIntoPrevRow(numIntoPrevRow);
						newStitch.setNumTimesCurr((stType.getValue() * digit));
						newStitch.setNumTimesPrev((stType.getNumStIntoPrevRow() * digit));
						newStitch.setDescription(stType.getName());
						
						if(isAst)
						{
							
							//numStAst = numStAst +  (stType.getNumStIntoPrevRow() * digit);
							//System.out.println("numStAst: " +numStAst);
						}
						 
					}
					
				} // end else if find letter/digit pattern
			}
			catch(Exception e)
			{
				
			}
			
			litr.set(st);
			 
			newStitch.setStrStitch(st.trim());
			
			newStitch.setNumReps(counter++);/////////////////////////
			stsArr.add(newStitch);
			
			int len = stsArr.size();
			
			for(int i = 1; i < repeats; i++)		
			{
				for(int j = indSerStart; j < len; j++)
				{
					//numIntoCurrRow = numIntoCurrRow + stsArr.get(j).;
					//numIntoPrevRow = numIntoPrevRow + (stType.getNumStIntoPrevRow() * digit);
				
					stsArr.add(new Stitch(stsArr.get(j), numIntoCurrRow, numIntoPrevRow));
					
					numIntoCurrRow = numIntoCurrRow + stsArr.get(j).getNumTimesCurr();
					numIntoPrevRow = numIntoPrevRow + stsArr.get(j).getNumTimesPrev();
				}
			}
			
			if(astComplete)
			{
				// get number of stitches in * repeat
				for(int j = indAstStart; j < len; j++)
					numStAst = numStAst + stsArr.get(j).getNumTimesPrev();
					 
				// check how many stitches are left from prev row
				numStRemaining = numInPrevRow - numIntoPrevRow;

				// check how many times to repeat
				 astRepeats = numStRemaining / numStAst;
				
				 // add * repeat to list by req number of times
				for(int i = 0; i < astRepeats; i++)
				{
					for(int j = indAstStart; j < len; j++)
					{
						stsArr.add(new Stitch(stsArr.get(j), numIntoCurrRow, numIntoPrevRow));
						numIntoCurrRow = numIntoCurrRow + stsArr.get(j).getNumTimesCurr();
						numIntoPrevRow = numIntoPrevRow + stsArr.get(j).getNumTimesPrev();				
					}
				 
				}
				
				astComplete = false;
			}
			 
			if(isAdd)
			{
				litr.add(stAfterAst);
				litr.previous();
				isAst = true;
				isAdd = false;
				indAstStart = stsArr.size();
			}
						
		} // end while listiterator
			
		for (Stitch st : stsArr)
		{
			System.out.println(st.getStrStitch() + " " + st.getNumIntoCurrRow());
			/*System.out.println("stitch: " + st.getStrStitch() + " " + st.getStitchID() 
			+ " "   + st.getNumIntoCurrRow() + " " 
					+ st.getNumIntoPrevRow() + " " + st.isAst() + " ser: " + st.isSeries());
			*/
		} // end for stitches in strRowArr	
		
		/*
		
		for (String stitch : strRowArr)
		{
			Stitch newStitch = new Stitch(); // new stitch object
			
			if(stitch.indexOf('[') != -1)
			{
				isSer = true;
				indSerStart = stsArr.size(); // set start of series 
				//System.out.println("IsSeries");
			
			} // end if '['
			else if(stitch.indexOf(']') != -1)
			{
				// process item before ']' first
				isSer = false;
				
				
				//strRowArr.add(strRowArr.indexOf(stitch)+1,
					//	stitch.substring(stitch.indexOf(']')+1));
				
				//stitch = stitch.replace(stitch.substring(stitch.indexOf(']')), "");
				
				
			} // end else if ']'
			
			if(isSer)
			{
				newStitch.setSeries(isSer);
				newStitch.setIndexOfSeriesStart(indSerStart);

			}
			
			newStitch.setStrStitch(stitch);
			
			stsArr.add(newStitch);
			
		} // end for stitches in strRowArr
*/			
		
		
	} // end processRow
	
	public void processStitch(Stitch newStitch)
	{
		
	}
	
}

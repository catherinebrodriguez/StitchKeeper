package stitchCounter;

public class Stitch
{
	private static int numStitches = 0;
	private int stitchID;
	private String strStitch;		// text of stitch
	private String description;		// description of what st term means
	private int numTimes;			// number of times to perform stitch
	
	private int rowNum;				// row number where stitch is located
	private int numIntoCurrRow;		// stitch number on current row
	private int numIntoPrevRow;		// stitch number on previous row
	
	private int numTimesCurr;		//
	private int numTimesPrev;
	
	private boolean isSeries;		// if stitch is within a series
	private int indexOfSeriesStart; 
	private int numReps;			// number of reps for the series (if in one)
	private int numRepsRem;			// number of reps left in series (if in one)
	
	private boolean isAst;			// if within a * repeat
	private int numStAst;			// number of stitches in * repeat
	private int indexOfAstStart;    // loc of first stitch in repeat
	private int numRepsAst;         // number of repeats 
	private int numRepsRemAst;		// number of repeats remaining 
	
	public Stitch()
	{
		stitchID = numStitches++;
		strStitch = "";
		description = "";
		
		numTimes = 0;
		rowNum = 0;
		numIntoCurrRow = 0;
		numIntoPrevRow = 0;
		
		numTimesCurr = 0;
		numTimesPrev = 0;
		
		isSeries = false;
		indexOfSeriesStart = 0;
		numReps = 0;
		numRepsRem = 0;
		
		isAst = false;
		indexOfAstStart = 0;
		numRepsAst = 0;
		numRepsRemAst = 0;
		numStAst = 0;
				
	} // end default constructor
	
	public Stitch(Stitch st)
	{
		this.stitchID = numStitches++;
		this.strStitch = st.strStitch;
		this.description = st.description;
		
		this.numTimes = st.numTimes;
		this.rowNum = st.rowNum;
		this.numIntoCurrRow = st.numIntoCurrRow;
		this.numIntoPrevRow = st.numIntoPrevRow;
		
		this.numTimesCurr = st.numTimesCurr;
		this.numTimesPrev = st.numTimesPrev;
		
		this.isSeries = st.isSeries;
		this.indexOfSeriesStart = st.indexOfSeriesStart;
		this.numReps = st.numReps;
		this.numRepsRem = st.numRepsRem;
		
		this.isAst = st.isAst;
		this.indexOfAstStart = st.indexOfAstStart;
		this.numRepsAst = st.numRepsAst;
		this.numRepsRemAst = st.numRepsRem;
		this.numStAst = st.numStAst;
	} // end non-default constructor
	
	public Stitch(Stitch st, int numCurr, int numPrev)
	{
		this.stitchID = numStitches++;
		this.strStitch = st.strStitch;
		this.description = st.description;
		
		this.numTimes = st.numTimes;
		this.rowNum = st.rowNum;
		this.numIntoCurrRow = numCurr + st.numTimesCurr;
		this.numIntoPrevRow = numPrev + st.numTimesPrev;
		
		this.numTimesCurr = st.numTimesCurr;
		this.numTimesPrev = st.numTimesPrev;
		
		this.isSeries = st.isSeries;
		this.indexOfSeriesStart = st.indexOfSeriesStart;
		this.numReps = st.numReps;
		this.numRepsRem = st.numRepsRem;
		
		this.isAst = st.isAst;
		this.indexOfAstStart = st.indexOfAstStart;
		this.numRepsAst = st.numRepsAst;
		this.numRepsRemAst = st.numRepsRem;
				
	} // end non-default constructor
	
	public int getStitchID()
	{
		return stitchID;
		
	} // end getStitchID
	
	public void setStitchID(int stitchID)
	{
		this.stitchID = stitchID;
		
	} // end setStitchID
	
	public String getStrStitch()
	{
		return strStitch;
		
	} // end getstrStitch

	public void setStrStitch(String strStitch)
	{
		this.strStitch = strStitch;
		
	} // end setStitch

	public String getDescription()
	{
		return description;
		
	} // end getDescription

	public void setDescription(String description)
	{
		this.description = description;
		
	} // end setDescription
	
	public int getNumTimes()
	{
		return numTimes;
		
	} // end getNumTimes
	
	public void setNumTimes(int numTimes)
	{
		this.numTimes = numTimes;
		
	} // end setNumTimes
	
	public int getRowNum()
	{
		return rowNum;
		
	} // end getRowNum

	public void setRowNum(int rowNum)
	{
		this.rowNum = rowNum;
		
	} // end setRowNum

	public int getNumIntoCurrRow()
	{
		return numIntoCurrRow;
		
	} // end getNumIntoCurrRow

	public void setNumIntoCurrRow(int numIntoCurrRow)
	{
		this.numIntoCurrRow = numIntoCurrRow;
		
	} // end setNumIntoCurrRow

	public int getNumIntoPrevRow()
	{
		return numIntoPrevRow;
		
	} // end getNumIntoPrevRow

	public void setNumIntoPrevRow(int numIntoPrevRow)
	{
		this.numIntoPrevRow = numIntoPrevRow;
	
	} // end setNumIntoPrevRow

	public int getNumTimesCurr()
	{
		return numTimesCurr;
	}

	public void setNumTimesCurr(int numTimesCurr)
	{
		this.numTimesCurr = numTimesCurr;
	}

	public int getNumTimesPrev()
	{
		return numTimesPrev;
	}

	public void setNumTimesPrev(int numTimesPrev)
	{
		this.numTimesPrev = numTimesPrev;
	}

	public boolean isSeries()
	{
		return isSeries;
		
	} // end isSeries

	public void setSeries(boolean isSeries)
	{
		this.isSeries = isSeries;
		
	} // end setSeries

	public int getIndexOfSeriesStart()
	{
		return indexOfSeriesStart;
		
	} // end getIndexOfSeriesStart

	public void setIndexOfSeriesStart(int indexOfSeriesStart)
	{
		this.indexOfSeriesStart = indexOfSeriesStart;
		
	} // end setIndexOfSeriesStart
 
	public int getNumReps()
	{
		return numReps;
		
	} // end getNumReps

	public void setNumReps(int numReps)
	{
		this.numReps = numReps;
		
	} // end setNumReps

	public int getNumRepsRem()
	{
		return numRepsRem;
		
	} // end getNumRepsRem

	public void setNumRepsRem(int numRepsRem)
	{
		this.numRepsRem = numRepsRem;
		
	} // end setNumRepsRem

	public boolean isAst()
	{
		return isAst;
	
	} // end isAst

	public void setAst(boolean isAst)
	{
		this.isAst = isAst;
		
	} // end setAst

	public int getIndexOfAstStart()
	{
		return indexOfAstStart;
		
	} // end getIndexOfAstStart

	public void setIndexOfAstStart(int indexOfAstStart)
	{
		this.indexOfAstStart = indexOfAstStart;
		
	} // end setIndexOfAstStart
	
	public int getNumRepsAst()
	{
		return numRepsAst;
		
	} // end getNumRepsAst

	public void setNumRepsAst(int numRepsAst)
	{
		this.numRepsAst = numRepsAst;
	
	} // end setNumRepsAst

	public int getNumRepsRemAst()
	{
		return numRepsRemAst;
		
	} // end getNumRepsRemAst

	public void setNumRepsRemAst(int numRepsRemAst)
	{
		this.numRepsRemAst = numRepsRemAst;
		
	} // end setNumRepsRemAst

} // end class Stitch

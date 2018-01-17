package stitchCounter;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class RowReader
{

	 
	
	private List<Row> rowsArr; // list of rows in pattern
	
	public RowReader()
	{
		rowsArr = new ArrayList<Row>();
		
	} // end non-default constructor

	
	public List<Row> getRowsArr()
	{
		return rowsArr;
	}

	public void setRowsArr(List<Row> rowsArr)
	{
		this.rowsArr = rowsArr;
	}
	
	
	
	public void readFile()
	{
		// file name to open
		String fileName = "row.txt"; // name of file
		String line;				 // line to be read from file
	 
		int num;
		 
		try
		{
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			line = bufferedReader.readLine();
  
			// get the first line to get numCastOn 
			num = Integer.valueOf(line);
			//Row newRow = new Row(num);
			
			// read first work line of pattern
			line = bufferedReader.readLine();
			//num = newRow.getNumIntoCurrRow();
			Row newRow = new Row(num);
			
			while(line != null)
			{
			//	System.out.println(line);
				newRow.processRow(newRow, line);
				
				rowsArr.add(newRow);
				//incRowNum();
				//passedRow[ct] = line;
				//ct++;
				num = newRow.getNumIntoCurrRow();
				
				newRow = new Row(num);
				
				line = bufferedReader.readLine();
			}
			
			// close file
			bufferedReader.close();
			
		} // end try
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file '" + fileName + "'");   
			
		} // end catch file not found
		catch(IOException ex) 
		{
            System.out.println("Error reading file '" + fileName + "'");                  
        } // end catch io exception
		
	} // end readRow
	
}

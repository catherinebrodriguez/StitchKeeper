package stitchCounter;
 
public class StitchDriver
{
	public static void main(String [ ] args)
	{
		// prints values of the stitch library
		//for(StitchLibrary st : StitchLibrary.values())
		//	System.out.println(st.getName());
		
		//ArrayList<String> rowsArr = new ArrayList<String>();
		
		/*RowReader rows = new RowReader(14);
		
		//StitchReader rows = new StitchReader(14);
		
		ArrayList<Stitch> stitchArr = new ArrayList<Stitch>();
		//ArrayList<String> stsArr = new ArrayList<String>();

		ArrayList<ArrayList<String>> rowsArr = new ArrayList<ArrayList<String>>();
		 
		
		// file name to open
		String fileName = "row.txt";
		String[] passedRow = new String[10];
		
		String line = "";
		int ct = 0;
		
		try
		{
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null)
			{
				System.out.println(line);
				rows.readRow(line);
				rows.incRowNum();
				//passedRow[ct] = line;
				ct++;
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
		
		
		
		//	String pRow = "k2, [k1, p1] 2x, * k1, p1, inc 1, YO, [k1, p0] 2x, k1; rep from * to end";
		
		//String passedRow = "k1, yo, k1, inc 1, p2";
		
		String finalRow;
		
		//System.out.println(passedRow[0] + "\n");
		
		//for(int i = 0; i < ct; i++)
		//	row.readRow(passedRow[i]);
*/		
		
		RowReader pattern = new RowReader();
	
		pattern.readFile();
		
	} // end main

} // end StitchDriver

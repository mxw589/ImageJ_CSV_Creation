package processing;

import java.io.FileWriter;
import java.io.IOException;

import datatypes.PixelsValues;

public class Writer {
	
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
	public static void write(Caller caller){
		String title = caller.getChosenImg().getTitle();
		String ext = ".csv";
		int index = title.lastIndexOf( "." );
		if( index != -1 )
		{
			title = title.substring(0, index);				
		}
		
		final String FILE_HEADER = title + "-excel" + ext;
		
		final String FILE_LOCATION = "/Users/Mark/Documents/Project/Test_Images/csv/" + FILE_HEADER;
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(FILE_LOCATION);
			fileWriter.append("L.Neigh,Centre,R.Neigh,Label");
			fileWriter.append(NEW_LINE_SEPARATOR);

			PixelsValues[] horiLine = new PixelsValues[caller.getReadImage().length];
			
			for(int widthP = 0; widthP < caller.getReadImage().length; widthP++){
				horiLine[widthP] = caller.getReadImage()[widthP][caller.getLine()];
			}
			
			PixelsValues lNeigh = null;
			PixelsValues centre = null;
			PixelsValues rNeigh = null;
			
			for(int widthP = 1; widthP < caller.getChosenImg().getWidth() - 1; widthP++){
				lNeigh = horiLine[widthP - 1];
				centre = horiLine[widthP];
				rNeigh = horiLine[widthP + 1];
				fileWriter.append("" + lNeigh.getValue() + COMMA_DELIMITER);
				fileWriter.append("" + centre.getValue() + COMMA_DELIMITER);
				fileWriter.append("" + rNeigh.getValue() + COMMA_DELIMITER);
				fileWriter.append("" + centre.getMaskVal());
				fileWriter.append(NEW_LINE_SEPARATOR);	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		
		
		
	}
	
}

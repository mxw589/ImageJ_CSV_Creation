package processing;

import java.io.FileWriter;
import java.io.IOException;

import datatypes.ImageLine;
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
			
			ImageLine[] imageLines = caller.getImageLine();
			ImageLine chosenLine = imageLines[caller.getLine()];
			PixelsValues[] chosenLinePixels = chosenLine.getPixelLine();
			PixelsValues lNeigh = null;
			PixelsValues centre = null;
			PixelsValues rNeigh = null;
			int label = 0;
			
			for(int widthP = 1; widthP < caller.getChosenImg().getWidth() - 1; widthP++){
				lNeigh = chosenLinePixels[widthP - 1];
				centre = chosenLinePixels[widthP];
				rNeigh = chosenLinePixels[widthP + 1];
				fileWriter.append("" + lNeigh.getValue() + COMMA_DELIMITER);
				fileWriter.append("" + centre.getValue() + COMMA_DELIMITER);
				fileWriter.append("" + rNeigh.getValue() + COMMA_DELIMITER);
				fileWriter.append("" + centre.getMaskVal());
				fileWriter.append(NEW_LINE_SEPARATOR);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
	}
	
}

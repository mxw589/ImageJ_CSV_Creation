package csv_creator;

import java.awt.Scrollbar;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.gui.GenericDialog;
import processing.Caller;

public class CSV_creator{

	public void run(String arg) {

		/*
		 * count images to be processed
		 */
		int imgCount = WindowManager.getImageCount();

		/*
		 * error if there are no images to be used
		 */
		if( imgCount == 0 ){
			IJ.error( "CSV creation", 
					"ERROR: At least one image needs to create a CSV.");
			return;
		}

		/*
		 * save image names to an array 
		 */
		String[] imgNames = new String[imgCount];

		for(int i = 0; i < imgCount; i++){
			imgNames[i] = WindowManager.getImage(i + 1).getShortTitle();
		}

		/*
		 * create a dialog box for initiating the watershed operation
		 */
		GenericDialog gd = new GenericDialog("CSV Creation");

		gd.addChoice("Input", imgNames, imgNames[0]);
		gd.showDialog();

		/*
		 * retrieves the values selected in the dialog and passes them to the
		 * process method for use
		 */
		if(gd.wasOKed()){
			ImagePlus chosenImg = WindowManager.getImage(gd.getNextChoiceIndex()+1);

			ImagePlus result = process(chosenImg);

			result.show();
		}

	}

	private ImagePlus process(ImagePlus chosenImg){
		final long start = System.currentTimeMillis();

		ImagePlus resultImg = 
		final long end = System.currentTimeMillis();
		IJ.log("File creation took " + (end-start) + " ms.");

		return resultImg;
	}

	public static void main(String[] args){
		new ImageJ();
		ImagePlus image7 = IJ.openImage();
		image7.show();
		IJ.runPlugIn("CSV_creator", "");
	}
}

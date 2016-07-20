import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.gui.GenericDialog;
import ij.plugin.PlugIn;
import processing.Caller;

public class CSV_creator implements PlugIn{

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

		gd.addChoice("Image", imgNames, imgNames[0]);
		gd.addChoice("Mask", imgNames, imgNames[1]);
		gd.addStringField("Line", "0");
		gd.showDialog();

		/*
		 * retrieves the values selected in the dialog and passes them to the
		 * process method for use
		 */
		if(gd.wasOKed()){
			ImagePlus chosenImg = WindowManager.getImage(gd.getNextChoiceIndex()+1);
			ImagePlus chosenMask = WindowManager.getImage(gd.getNextChoiceIndex()+1);
			int line = Integer.parseInt(gd.getNextString());

			process(chosenImg, chosenMask, line);
		}

	}

	private void process(ImagePlus chosenImg, ImagePlus chosenMask, int lineChoice){
		final long start = System.currentTimeMillis();
		
		Caller caller = new Caller(chosenImg, chosenMask, lineChoice);
		
		caller.call();
		
		final long end = System.currentTimeMillis();
		IJ.log("File creation took " + (end-start) + " ms.");
	}

	public static void main(String[] args){
		new ImageJ();
		ImagePlus image0 = IJ.openImage("/Users/Mark/Documents/Project/Test_Images/BMP/6_FITC-sample.tif");
		image0.show();
		ImagePlus image1 = IJ.openImage("/Users/Mark/Documents/Project/Test_Images/BMP/6_FITC-sample-mask.tif");
		image1.show();
		IJ.runPlugIn("CSV_creator", "");
	}
}

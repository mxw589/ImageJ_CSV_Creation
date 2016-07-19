package processing;

import datatypes.ImageLine;
import datatypes.PixelPos;
import datatypes.PixelsValues;
import ij.process.ImageProcessor;

public class Reader {

	/**
	 * uses the input images in the Caller object in order to create
	 * the ImageLine objects in the Caller object
	 * @param caller
	 * @return
	 */
	public static void read(Caller caller){
		ImageProcessor chosenImg = caller.getChosenImg().getProcessor();
		ImageProcessor chosenMask = caller.getChosenMask().getProcessor();

		int width = chosenImg.getWidth();
		int height = chosenImg.getHeight();

		if(width != chosenMask.getWidth() || height != chosenMask.getHeight()){
			throw new IllegalArgumentException("Image and mask don't have the same"
					+ "dimensions");
		}

		PixelsValues[][] pixelsValues = new PixelsValues[width][height];
		PixelPos pixelPos;
		double h;
		double maskH;
		int number = 0;


		for(int widthP = 0; widthP < width; widthP++){
			for(int heightP = 0; heightP < width; heightP++){
				h = chosenImg.getf(widthP, heightP);
				maskH = chosenMask.getf(widthP, heightP);

				pixelPos = new PixelPos(widthP, heightP);

				if(maskH > 0){
					pixelsValues[widthP][heightP] = new PixelsValues(pixelPos, h, number, 1);
				} else {
					pixelsValues[widthP][heightP] = new PixelsValues(pixelPos, h, number, 0);
				}

				number++;
			}
		}

		ImageLine[] imageLines = new ImageLine[height];

		PixelsValues[] horiLine = new PixelsValues[width];

		for(int heightP = 0; heightP < width; heightP++){
			for(int widthP = 0; widthP < width; widthP++){
				horiLine[widthP] = pixelsValues[widthP][heightP];
			}
			imageLines[heightP] = new ImageLine(horiLine);
		}
		caller.setImageLine(imageLines);	
	}

}

package processing;

import datatypes.PixelsValues;
import ij.ImagePlus;

public class Caller {
	
	private ImagePlus chosenImg;
	private ImagePlus chosenMask;
	private int line;
	private PixelsValues[][] readImage;
	
	public Caller(ImagePlus chosenImg, ImagePlus chosenMask, int line){
		this.chosenImg = chosenImg;
		this.chosenMask = chosenMask;
		this.line = line;
	}

	public ImagePlus getChosenImg() {
		return chosenImg;
	}

	public ImagePlus getChosenMask() {
		return chosenMask;
	}
	
	public PixelsValues[][] getReadImage() {
		return readImage;
	}

	public int getLine() {
		return line;
	}

	public void setImageLine(PixelsValues[][] readImage) {
		this.readImage = readImage;
	}

	public void call(){
		Reader.read(this);
		Writer.write(this);
	}
	
}

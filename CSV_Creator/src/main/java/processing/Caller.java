package processing;

import datatypes.ImageLine;
import datatypes.PixelsValues;
import ij.ImagePlus;

public class Caller {
	
	private ImagePlus chosenImg;
	private ImagePlus chosenMask;
	private int line;
	private ImageLine[] imageLine;
	
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
	
	public ImageLine[] getImageLine() {
		return imageLine;
	}

	public int getLine() {
		return line;
	}

	public void setImageLine(ImageLine[] imageLine) {
		this.imageLine = imageLine;
	}

	public void call(){
		Reader.read(this);
		
	}
	
	
	
}

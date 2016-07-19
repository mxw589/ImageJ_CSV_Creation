package datatypes;
/**
 * data type for a pixels position and its value
 * @author Mark
 *
 */
public class PixelsValues implements Comparable<PixelsValues>{

	private double value;
	private PixelPos pixelPos;
	private int number;
	private int maskVal;

	public PixelsValues(PixelPos pixelPos, double value, int number, int maskVal){
		this.value = value;
		this.pixelPos = pixelPos;
		this.number = number;
		this.maskVal = maskVal;
	}

	public double getValue() {
		return value;
	}

	public PixelPos getPixelPos() {
		return pixelPos;
	}

	public int getNumber() {
		return number;
	}

	public int getMaskVal() {
		return maskVal;
	}

	public void setMaskVal(int maskVal) {
		this.maskVal = maskVal;
	}

	/**
	 * @param o the PixelsValues object to for comparison
	 * @return an integer value that indicates whether a pixel is lighter or darker
	 * than another
	 */
	public int compareTo(PixelsValues o) {
		int returnVal = Double.compare(getValue(), o.getValue());
		if( returnVal == 0 ){
			if(getNumber() < o.getNumber()){
				return 1;
			} else {
				return -1;
			}
		}
		return returnVal;
	}

}

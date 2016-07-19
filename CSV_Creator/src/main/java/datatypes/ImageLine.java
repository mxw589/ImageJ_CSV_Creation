package datatypes;

public class ImageLine {
	
	private PixelsValues[] pixelLine;
	
	public ImageLine(PixelsValues[] pixelLine){
		this.pixelLine = pixelLine;
	}

	public PixelsValues[] getPixelLine() {
		return pixelLine;
	}

	public void setPixelLine(PixelsValues[] pixelLine) {
		this.pixelLine = pixelLine;
	}

}

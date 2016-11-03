package utilities;



import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	public static BufferedImage loadImage(String path) {
		try {
			//return ImageIO.read(BufferedImageLoader.class.getResource(path));
			return ImageIO.read(BufferedImageLoader.class.getClassLoader().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}

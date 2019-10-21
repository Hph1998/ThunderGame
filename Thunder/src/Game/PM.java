package Game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PM {
	public static BufferedImage icon;
	public static BufferedImage myplanepng;
	public static BufferedImage mybulletpng;
	public static BufferedImage enemy1png;
	public static BufferedImage enemy2png;
	public static BufferedImage enemy3png;
	public static BufferedImage enemy4png;
	public static BufferedImage enemy5png;
	public static BufferedImage enemybulletpng;
	public static BufferedImage gameoverjpg;
	static {
		try {
			icon = ImageIO.read(PM.class.getResourceAsStream("/icon.png"));
			myplanepng = ImageIO.read(PM.class.getResourceAsStream("/myplane.png"));
			mybulletpng = ImageIO.read(PM.class.getResourceAsStream("/mybullet.png"));
			enemy1png = ImageIO.read(PM.class.getResourceAsStream("/enemy1.png"));
			enemy2png = ImageIO.read(PM.class.getResourceAsStream("/enemy2.png"));
			enemy3png = ImageIO.read(PM.class.getResourceAsStream("/enemy3.png"));
			enemy4png = ImageIO.read(PM.class.getResourceAsStream("/enemy4.png"));
			enemy5png = ImageIO.read(PM.class.getResourceAsStream("/enemy5.png"));
			enemybulletpng = ImageIO.read(PM.class.getResourceAsStream("/enemybullet.png"));
			gameoverjpg = ImageIO.read(PM.class.getResourceAsStream("/gameover.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

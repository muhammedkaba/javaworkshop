import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cloud {
    
    private BufferedImage image;
    private double posX;
    private double posY;

    public Cloud(int x, int y) {
        loadImage();

        posX = x;
        posY = y;
        
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/cloud.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
            image, 
            (int)(posX * Board.TILE_SIZE), 
            (int)(posY * Board.TILE_SIZE), 
            observer
        );
    }

    
    public int getX() {
    	return (int)posX;
    }
    
    public int getY() {
    	return (int)posY;
    }
    
    public void goUp(double amount) {
    	posY = posY - amount;
    }

}

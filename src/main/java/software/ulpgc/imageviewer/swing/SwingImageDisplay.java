package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.ImageDisplay;
import software.ulpgc.imageviewer.model.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image image;
    private BufferedImage bitmap;

    @Override
    public void show(Image image) {
        this.image = image;
        this.bitmap = load(image.id());
        this.repaint();
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        if (bitmap != null) {
            Dimension panelSize = getSize();

            int maxWidth = 1000;
            int maxHeight = 800;

            double widthRatio = (double) maxWidth / bitmap.getWidth();
            double heightRatio = (double) maxHeight / bitmap.getHeight();

            double scaleFactor = Math.min(widthRatio, heightRatio);

            int newWidth = (int) (bitmap.getWidth() * scaleFactor);
            int newHeight = (int) (bitmap.getHeight() * scaleFactor);

            int x = (panelSize.width - newWidth) / 2;
            int y = (panelSize.height - newHeight) / 2;

            g.drawImage(bitmap, x, y, newWidth, newHeight, null);
        }
    }

    private BufferedImage load(String name) {
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

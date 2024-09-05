import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageProcessor {

    public static void main(String[] args) {
        try {
            // Load the image
            File input = new File("input.jpg");
            BufferedImage image = ImageIO.read(input);

            // Get image dimensions
            int width = image.getWidth();
            int height = image.getHeight();

            // Process each pixel to convert to grayscale
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    // Get pixel color
                    Color color = new Color(image.getRGB(i, j));

                    // Convert to grayscale
                    int red = (int) (color.getRed() * 0.299);
                    int green = (int) (color.getGreen() * 0.587);
                    int blue = (int) (color.getBlue() * 0.114);
                    int gray = red + green + blue;

                    // Set new pixel color
                    Color newColor = new Color(gray, gray, gray);
                    image.setRGB(i, j, newColor.getRGB());
                }
            }

            // Save the processed image
            File output = new File("output.jpg");
            ImageIO.write(image, "jpg", output);

            System.out.println("Image processing completed!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

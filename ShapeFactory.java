import java.awt.Color;
import java.util.Random;

public class ShapeFactory {
	// fields
	private static final Random random = new Random();
	/**
	 * Helper function to randomly generates a color to be used for the shape
	 * @return Color 
	 */
	private Color randomColor() {
		// local variables
		int numColors = 6;
		int randomColor = random.nextInt(numColors);
		// assigning the color
		if (randomColor == 1)
			return new Color(231, 151, 44); // gold
		else if (randomColor == 2)
			return new Color(131, 151, 44); // green
		else if (randomColor == 3)
			return new Color(51, 204, 255); // light blue
		else if (randomColor == 4)
			return new Color(255, 51, 51); // red
		else if (randomColor == 5)
			return new Color(102, 0, 153); // purple
		else
			return new Color(102, 255, 102); // light green
	}
	
	/**
	 * Helper function to randomly generates a length to be used for the shape
	 * @return int 
	 */
	private int randomWidth() {
		// min and max widths
		int maxWidth = 50;
		int minWidth = 30;
		return minWidth + random.nextInt(maxWidth);
	}
	
	/**
	 * Method to generate the shape with a random width, height and color
	 * @return Shape 
	 */
	public Shape getShape(String shapeType) {
		// check for null case
		if (shapeType == null) {
			return null;
		}
		// return the corresponding type of shape
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			int width = randomWidth();
			return new Circle(0, 0, width, width, randomColor());
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle(0, 0, randomWidth(), randomWidth(), randomColor());
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			int width = randomWidth();
			return new Square(0, 0, width, width, randomColor());
		}
		return null;
	}

}

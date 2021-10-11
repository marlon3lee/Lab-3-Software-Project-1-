import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract Shape class which is the parent class for the shapes
 */
public abstract class Shape implements Comparable<Shape>{
	/**
	 * This method compares a shape's area with another shape's area
	 * @return int (either a negative value, 0 or a positive value)
	 */
	@Override
	public int compareTo(Shape s) {
		return calculateArea() - s.calculateArea();
	}
	
	/**
	 * This method calculate the shape's area
	 * @return int 
	 */
	public abstract int calculateArea();
	
	/**
	 * This method draws the shape
	 */	
	public abstract void drawShape(Graphics form);
	
	/**
	 * Getters and Setters
	 */
	public abstract Color getColor();
	
	public abstract int getWidth();
	
	public abstract int getHeight();
	
	public abstract int getUpperX();
	
	public abstract int getUpperY();
	
	public abstract void setColor(Color aShapeColor);
	
	public abstract void setWidth(int width);
	
	public abstract void setHeight(int height);

	public abstract void setUpperX(int upperX);

	public abstract void setUpperY(int upperY);

}
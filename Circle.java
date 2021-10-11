import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	// fields
	protected int upperX; 
	protected int upperY;
	protected int width;
	protected int height;
	protected Color shapeColor;
	
	/**
	 * Class's constructor
	 * @param upperX
	 * @param upperY
	 * @param width
	 * @param height
	 * @param shapeColor
	 */
	public Circle (int upperX, int upperY, int width, int height, Color shapeColor) {
		this.upperX = upperX;
		this.upperY = upperY;
		this.width = width;
		this.height = height;
		this.shapeColor = shapeColor;
	}
	
	/**
	 * Method to draw a rectangle
	 * @param form
	 */
	@Override
	public void drawShape(Graphics	form) {
		form.fillOval(upperX, upperY, width, height);
	}
	
	/**
	 * Method to calculate a shape's area
	 * @param 
	 */
	public int calculateArea() {
		int radius = width / 2;
		return (int) (Math.PI * radius * radius);
	}
	
	/**
	 * Getters and Setters
	 */
    public Color getColor() {
		return shapeColor;
	}
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
	public int getUpperX() {
		return upperX;
	}
	
	public int getUpperY() {
		return upperY;
	}
	
	 public void setColor(Color aShapeColor) {
		 this.shapeColor = aShapeColor;
	 }
	 
	 public void setWidth(int width) {
		 this.width = width;
	 }
	    
	 public void setHeight(int height) {
		 this.height = height;
	 }
	 
	 public void setUpperX(int upperX) {
		 this.upperX = upperX;
	 }
		
	 public void setUpperY(int upperY) {
		 this.upperY = upperY;
	 }

}

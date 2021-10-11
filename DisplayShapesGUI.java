import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Marlon Lee, 217 129 230, EECS 3311, Section A, TA: Karim Mridul
 * This is Lab 3 for EECS 3311
 * Used the professor's posted sample code as a reference for the Rectangle, Square, Circle classes
 * as well for the DisplayShapesGUI class, in particular for paintComponent and for creating a JFrame and JPanel
 */
@SuppressWarnings("serial")
public class DisplayShapesGUI extends JPanel {
	// fields
	private static JFrame frame;
	public List<Shape> shapeList;
	public static boolean loadButtonPressed;
	
	/**
	 * helper function to return a random type of shape (circle, square or rectangle)
	 */
	private String randomTypeOfShape() {
		// local variables
		Random random = new Random();
		int typesOfShapes = 3;
		int type = random.nextInt(typesOfShapes);
		// return a random type of shape
		if (type == 1) {
			return "RECTANGLE";
		} else if (type == 2) {
			return "SQUARE";
		} else
			return "CIRCLE";
	}

	/**
	 * This method creates the shapes
	 */
	private void createShapes() {

		// instantiating shape factory
		ShapeFactory shapeFactory = new ShapeFactory();

		// initialize shapes using shape factory getShape method
		Shape shape1 = shapeFactory.getShape(randomTypeOfShape());
		Shape shape2 = shapeFactory.getShape(randomTypeOfShape());
		Shape shape3 = shapeFactory.getShape(randomTypeOfShape());
		Shape shape4 = shapeFactory.getShape(randomTypeOfShape());
		Shape shape5 = shapeFactory.getShape(randomTypeOfShape());
		Shape shape6 = shapeFactory.getShape(randomTypeOfShape());
		
		// set the coordinates (positions) for the shapes
		shape1.setUpperX(25);
		shape1.setUpperY(35);
		shape2.setUpperX(115);
		shape2.setUpperY(105);
		shape3.setUpperX(205);
		shape3.setUpperY(205);
		shape4.setUpperX(300);
		shape4.setUpperY(300);
		shape5.setUpperX(395);
		shape5.setUpperY(395);
		shape6.setUpperX(475);
		shape6.setUpperY(475);

		// add the shapes to the array list
		shapeList = new ArrayList<Shape>();
		shapeList.add(shape1);
		shapeList.add(shape2);
		shapeList.add(shape3);
		shapeList.add(shape4);
		shapeList.add(shape5);
		shapeList.add(shape6);

	}

	/**
	 * This method displays the created shapes.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// if load button is selected, call the method that creates the shapes
		if (loadButtonPressed) {
			createShapes();
		}
		
		// iterate through the list to set its color and draw each shape
		for (Shape shape : shapeList) {
			g2d.setColor(shape.getColor());
			shape.drawShape(g2d);
		}
	}

	/**
	 * When the load button is pressed
	 */
	public static void loadButtonPressed() {
		loadButtonPressed = true;
		// instantiate this panel class
		DisplayShapesGUI s = new DisplayShapesGUI();
		// clear the frame
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
		// create and add the buttons to the panel again 
		JButton loadButton = new JButton();
		JButton sortButton = new JButton();
		loadButton.setText("Load Shapes");
		sortButton.setText("Sort Shapes");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadButtonPressed();
			}
		});
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortButtonPressed(s);
			}
		});
		s.add(loadButton);
		s.add(sortButton);
		// add the panel to the frame
		frame.getContentPane().add(s);
		frame.validate();
		frame.setVisible(true);
	}

	/**
	 * When the sort button is pressed
	 */
	public static void sortButtonPressed(DisplayShapesGUI s) {
		loadButtonPressed = false;
		// instantiate the sorting class
		ShapeSorting sort = new ShapeSorting(s.shapeList);
		// call its sorting method
		sort.selectionSort();
		// reset the coordinates (positions) to its new sorted order
		s.shapeList.get(0).setUpperX(25);
		s.shapeList.get(0).setUpperY(35);
		s.shapeList.get(1).setUpperX(115);
		s.shapeList.get(1).setUpperY(105);
		s.shapeList.get(2).setUpperX(205);
		s.shapeList.get(2).setUpperY(205);
		s.shapeList.get(3).setUpperX(300);
		s.shapeList.get(3).setUpperY(300);
		s.shapeList.get(4).setUpperX(395);
		s.shapeList.get(4).setUpperY(395);
		s.shapeList.get(5).setUpperX(475);
		s.shapeList.get(5).setUpperY(475);
		// repaint the panel
		s.revalidate();
		s.repaint();
	}

	/**
	 * This is the main method of the class.
	 * @param args
	 */
	public static void main(String[] args) {
		// instantiate a panel
		JPanel panel = new JPanel();
		// create and add the buttons to the panel
		JButton loadButton = new JButton();
		JButton sortButton = new JButton();
		loadButton.setText("Load Shapes");
		sortButton.setText("Sort Shapes");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadButtonPressed();
			}
		});
		panel.add(loadButton);
		panel.add(sortButton);
		// initialize the frame
		frame = new JFrame("Display Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

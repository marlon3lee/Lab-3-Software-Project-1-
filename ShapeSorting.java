import java.util.List;

public class ShapeSorting {
	private List<Shape> shapeList;
	/**
	 * Class's constructor
	 * @param List<Shape>
	 */
	public ShapeSorting(List<Shape> shapeList) {
		this.shapeList = shapeList;
	}
	/**
	 * sorting method to sort the shapes' area using selection sort algorithm 
	 * @return Color 
	 */
	public void selectionSort() {
		// iterate through the shape list
		for (int i = 0; i < shapeList.size(); i++) {
			// current index 
			int currentIndex = i;
			// iterate through the rest of the list to find the shape with the least area
			for (int j = i + 1; j < shapeList.size(); j++) {
				// use shape's compareTo method to compare areas
				if (shapeList.get(j).compareTo(shapeList.get(currentIndex)) < 0)
					// update the current index
                    currentIndex = j;
            }
            // Swap minimum element with the i position in the list
            Shape min = shapeList.get(currentIndex);
            shapeList.set(currentIndex, shapeList.get(i));
            shapeList.set(i, min);
		}
	}
	
}

public class GroceryBoxService implements BoxService {
    Item item;

    public GroceryBoxService(Item item) {
        this.item = item;
    }

    @Override
    String determineBoxSize() {
		double length = item.getLength();
		double width = item.getWidth();
		double height = item.getHeight();
		double max = length;
		if(max < width)
			max = width;
		if(max < height)
			max = height;
		if(max < 10)
			return "small";
		else if(max < 20)
			return "medium";
		else if(max < 30)
			return "large";
		else
			return "x-large";
	}
}
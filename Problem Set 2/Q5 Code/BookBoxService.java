public class BookBoxService implements BoxService {
    Item item;

    public BookBoxService(Item book) {
        this.item = book;
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
		if(max < 5)
			return "small";
		else if(max < 15)
			return "medium";
		else
			return "large";
	}
}
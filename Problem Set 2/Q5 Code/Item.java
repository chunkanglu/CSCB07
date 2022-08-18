public abstract class Item {
    double length;
    double width;
    double height;

    // public Item(double length, double width, double height) {
    //     this.length = length;
    //     this.width = width;
    //     this.height = height;
    // }

    public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
interface StoreFront<T> {
	
	public void addItem(<T> item);
	
	public void removeItem(<T> item);
	
	public boolean itemExists(<T> item);
}
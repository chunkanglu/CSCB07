public class BookDeliveryService implements DeliveryService {
    Item item;
    Customer customer;
    StoreFront storeFront;
    BoxService boxService;

    public GroceryDeliveryService(Item item, Customer customer, StoreFront library, BoxService bookBoxService) {
        this.item = item;
        this.customer = customer;
        this.storeFront = library;
        this.boxService = bookBoxService;
    }

    @Override
    public void deliver() {
		if(storeFront.itemExists(item)){
			System.out.println("Delivering " + item);
			System.out.println("Delivery service: Books Express");
			System.out.println("Box size: " + boxService.determineBoxSize());
			System.out.println("Address: " + customer.getPostalCode());
			storeFront.removeItem(item);
		}
	}
}
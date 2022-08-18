public class GroceryDeliveryService implements DeliveryService {
    Item item;
    Customer customer;
    StoreFront storeFront;
    BoxService boxService;

    public GroceryDeliveryService(Item item, Customer customer, StoreFront groceryStore, BoxService groceryBoxService) {
        this.item = item;
        this.customer = customer;
        this.storeFront = groceryStore;
        this.boxService = groceryBoxService;
    }

    @Override
    public void deliver() {
        if(storeFront.itemExists(item)){
			System.out.println("Delivering " + item);
			System.out.println("Delivery service: Groceries Express");
			System.out.println("Box size: " + boxService.determineBoxSize());
			System.out.println("Address: " + customer.getPostalCode());
			storeFront.removeItem(item);
		}
    }
}
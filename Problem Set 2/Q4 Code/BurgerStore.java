public class BurgerStore extends newFastFoodStore{ // Added extends
	// Added create
	@Override
	FastFood create() {
		return new Pizza();
	}

	Burger order() {
		Burger burger = new Burger();
		burger.customize();
		burger.prepare();
		burger.box();
		return burger;
	}
}

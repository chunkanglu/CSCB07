package q4;

public class newFastFoodStore {

    abstract FastFood create();

    FastFood order() {
        FastFood f = create();
        f.customize();
        f.prepare();
        f.box();
        return f;
    }
}
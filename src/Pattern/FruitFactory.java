package Pattern;

public class FruitFactory {
    public Fruit getFruit(String fruitType) {
        if (fruitType == null)
            return null;
        if (fruitType.equals("Apple")) {
            return new Apple();
        } else if (fruitType.equals("Banana")) {
            return new Banana();
        }
        return null;
    }

    public static void main(String[] args) {
        FruitFactory f = new FruitFactory();
        Fruit apple = f.getFruit("Apple");
        apple.showColor();
    }
}

interface Fruit {
    void showColor();
}

class Apple implements Fruit {
    @Override
    public void showColor() {
        System.out.println("Apple:showColor() red");
    }
}

class Banana implements Fruit {
    @Override
    public void showColor() {
        System.out.println("Banana:showColor() yellow");
    }
}
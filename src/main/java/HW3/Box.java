package HW3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> arrayList = new ArrayList<>();

    public Box() {

    }

    public void addFruit(T fruit) {
        arrayList.add(fruit);
    }

    public float getWeight() {
        float sum = 0.0f;
        for (T num : arrayList) {
            sum = sum + num.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> boxToCompare) {
        return Math.abs(getWeight() - boxToCompare.getWeight()) < 0.001;
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Box{" +
                "arrayList=" + arrayList +
                '}';
    }

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        appleBox.addFruit(apple3);

        System.out.println(appleBox);
        System.out.println(appleBox.getWeight());

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);

        System.out.println(orangeBox.compare(appleBox));

    }
}
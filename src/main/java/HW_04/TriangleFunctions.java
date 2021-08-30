package HW_04;

public class TriangleFunctions {
    public double areaOfATriangleOnThreeSides(Integer a, Integer b, Integer c) {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

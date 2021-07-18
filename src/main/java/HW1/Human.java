package HW1;

public class Human extends Creature {
    private static final int maxRunHumDis = 3000;
    private static final int maxJumpHumHei = 2;

    public Human(String name) {
        super(name);
    }

    public static int getMaxRunHumDis() {
        return maxRunHumDis;
    }

    public static int getMaxJumpHumHei() {
        return maxJumpHumHei;
    }

    @Override
    public int run(Track track) {
        if (track.getDistance() > maxRunHumDis) {
            System.out.println(this.name + " не может пробежать такую дистанцию.");
        } else System.out.println(this.name + " пробежал " + track.getDistance() + " м.");
        return 0;
    }

    @Override
    public int jump(Wall wall) {
        if (wall.getHeight() > maxJumpHumHei) {
            System.out.println(this.name + " не может прыгнуть так высоко.");
        } else System.out.println(this.name + " прыгнул на " + wall.getHeight() + " м.");
        return 0;
    }
}

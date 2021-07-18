package HW1;

public class Robot extends Creature {
    private static final int maxRunRobDis = 10000;
    private static final int maxJumpRobHei = 100;

    public Robot(String name) {
        super(name);
    }

    public static int getMaxRunRobDis() {
        return maxRunRobDis;
    }

    public static int getMaxJumpRobHei() {
        return maxJumpRobHei;
    }

    @Override
    public int run(Track track) {
        if (track.getDistance() > maxRunRobDis) {
            System.out.println(this.name + " не может пробежать такую дистанцию.");
        } else System.out.println(this.name + " пробежал " + track.getDistance() + " м.");
        return 0;
    }

    @Override
    public int jump(Wall wall) {
        if (wall.getHeight() > maxJumpRobHei) {
            System.out.println(this.name + " не может прыгнуть так высоко.");
        } else System.out.println(this.name + " прыгнул на " + wall.getHeight() + " м.");
        return 0;
    }
}

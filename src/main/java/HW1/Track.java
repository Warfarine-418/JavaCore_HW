package HW1;

public class Track {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getInfoAboutRun(Creature creature) {
        return creature.run(this);
    }
}

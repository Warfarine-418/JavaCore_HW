package HW1;

public class Main {
    public static void main(String[] args) {

        Creature[] team = {new Cat("Кот"), new Human("Иван"), new Robot("Раздражатор3000")};
        Wall[] walls = {new Wall(1), new Wall(2), new Wall(10), new Wall(20)};
        Track[] tracks = {new Track(100), new Track(200), new Track(500), new Track(1000)};
        for (Creature creature : team) {
            for (Wall wall : walls) {
                wall.getInfoAboutJump(creature);
            }
        }
        for (Creature creature : team) {
            for (Track track : tracks) {
                track.getInfoAboutRun(creature);
            }
        }
    }
}

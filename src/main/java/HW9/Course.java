package HW9;

import java.util.Objects;

public class Course {
    private String course;

    public Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course1 = (Course) o;
        return course.equals(course1.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}

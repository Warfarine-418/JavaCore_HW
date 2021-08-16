package HW9;

import java.util.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Иван", Arrays.asList(new Course("Testing"), new Course("Java"),
                new Course("Linux"))));
        studentList.add(new Student("Олег", Arrays.asList(new Course("Testing"), new Course("HTML"),
                new Course("CSS"), new Course("Linux"))));
        studentList.add(new Student("Сергей", Arrays.asList(new Course("Java"), new Course("HTML"),
                new Course("CSS"), new Course("Testing"))));
        studentList.add(new Student("Мария", Arrays.asList(new Course("Linux"), new Course("WebTesting"),
                new Course("Java"), new Course("HTML"), new Course("CSS"))));
        uniqueCourse(studentList);
        curiousStudent(studentList);
        studentsOnCourse(studentList, new Course("WebTesting"));

    }

    public static void uniqueCourse(List<Student> students) {
        Set<Course> uniqueCourses = students.stream()
                .map(Student::getCourse)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        System.out.println(uniqueCourses);
    }

    public static void curiousStudent(List<Student> students) {
        List<Student> curiousStud = students.stream()
                .sorted((s1, s2) -> s2.getCourse().size() - s1.getCourse().size())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(curiousStud);
    }

    public static void studentsOnCourse(List<Student> students, Course course) {
        List<Student> studentsOnCourse = students.stream()
                .filter(s -> s.getCourse().contains(course))
                .collect(Collectors.toList());
        System.out.println(studentsOnCourse);
    }
}


//    Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
//    на которые подписаны студенты.
//
//    Написать функцию, принимающую на вход список Student и
//    возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
//
//    Написать функцию, принимающую на вход список Student и экземпляр Course,
//    возвращающую список студентов, которые посещают этот курс.

package au.bystritskaia;

import au.bystritskaia.groups.StudentGroup;
import au.bystritskaia.groups.StudentGroupController;
import au.bystritskaia.groups.StudentGroupService;
import au.bystritskaia.streams.GroupStream;
import au.bystritskaia.streams.GroupStreamController;
import au.bystritskaia.streams.GroupStreamService;
import au.bystritskaia.streams.StudentGroupIDComparator;
import au.bystritskaia.students.Student;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static List<Student> g1Students = List.of(
            new Student(3L, "Иванова Аня", 23),
            new Student(1L, "Петров Вася", 22)
    );

    private static List<Student> g2Students = List.of(
            new Student(3L, "Иванова Тася", 25),
            new Student(1L, "Петров Сережа", 24),
            new Student(1L, "Степанова Василиса", 24)
    );

    private static List<StudentGroup> groups = List.of(
            new StudentGroup(1L, "Рукоделие", g1Students),
            new StudentGroup(2L, "Технология", g2Students)
    );

    public static void main(String[] args) {
        GroupStream stream = new GroupStream(groups, 1);
        GroupStreamController controller = new GroupStreamController(new GroupStreamService(stream));
        controller.printGroups();
        controller.printSortedGroups();


    }
}

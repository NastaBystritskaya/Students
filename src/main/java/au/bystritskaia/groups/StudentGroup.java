package au.bystritskaia.groups;

import au.bystritskaia.users.models.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGroup implements Iterable<Student>{

    private Long id;

    private String name;

    List<Student> students = new LinkedList<>();

    public StudentGroup(Long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }

    @Override
    public String toString() {
        return """
                Группа: %s.%s
                Количество студентов: %d
                Список студентов: %s
                """.formatted(
                        this.id,
                this.name,
                this.students.size(),
                this.students.stream().map(Student::getFIO).collect(Collectors.joining(",\n")));
    }
}

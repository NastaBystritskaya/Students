package au.bystritskaia.models.groups;

import au.bystritskaia.models.actors.Student;
import au.bystritskaia.models.actors.Teacher;
import au.bystritskaia.models.groups.utils.StudentGroupIterator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Группа студентов
 */
public class StudentGroup implements Iterable<Student>{
    /**
     * ИД группы
     */
    private Long id;
    /**
     * Имя группы
     */
    private String name;
    /**
     * Список студентов
     */
    List<Student> students;

    /**
     * Преподаватель группы
     */
    Teacher teacher;

    /**
     * Консьтруктор группы
     * @param id ИД группы
     * @param name Имя группы
     * @param students Список студентов
     * @param teacher Учитель группы
     */
    public StudentGroup(Long id, String name, List<Student> students, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.teacher = teacher;
    }

    /**
     * Получает ИД шруппы
     * @return ИД группы
     */
    public Long getId() {
        return id;
    }

    /**
     * Изменяет ИД группы
     * @param id новый ИД
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Получает имя группы
     * @return Имя группы
     */
    public String getName() {
        return name;
    }

    /**
     * Изменяет имя группы
     * @param name Новое имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает список студентов
     * @return Список студентов
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Изменяет список студентов
     * @param students Новый список студентов
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Получает учителя
     * @return Учитель группы
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Итератор студентов
     *
     * @return Итератор
     */
    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }

    /**
     * В строку
     * @return Строчное представление группы студетов
     */
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

package au.bystritskaia.services.actors;

import au.bystritskaia.models.actors.Student;
import au.bystritskaia.models.actors.utils.UserComparator;
import au.bystritskaia.services.other.AgeAverageService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис студентов
 */
public class StudentService implements IUserService<Student> {
    /**
     * Список студентов
     */
    private static final List<Student> students = new LinkedList<>();

    /**
     * Создает нового студента
     *
     * @param id  ID
     * @param FIO ФИО
     * @param age Возраст
     * @return Созданный студент
     */
    @Override
    public Student create(Long id, String FIO, int age) {
        Student student = new Student(id, FIO, age);
        students.add(student);
        System.out.println("Создан:\n" + student);
        return student;
    }

    /**
     * Сортировка студентов
     *
     * @return Отсортированный список
     */
    @Override
    public List<Student> sort() {
        return students.stream().sorted(new UserComparator<>()).collect(Collectors.toList());
    }

    /**
     * Получает всех студентов
     */
    @Override
    public List<Student> getAll() {
        return students;
    }

    /**
     * Получает средний возраст студентов
     *
     * @return Средний возраст
     */
    @Override
    public double getAverage() {
        return new AgeAverageService<Student>().calculateAverage(students);
    }
}

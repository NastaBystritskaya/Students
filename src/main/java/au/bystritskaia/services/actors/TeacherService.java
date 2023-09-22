package au.bystritskaia.services.actors;

import au.bystritskaia.models.actors.Teacher;
import au.bystritskaia.models.actors.utils.UserComparator;
import au.bystritskaia.services.other.AgeAverageService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис учителей
 */
public class TeacherService implements IUserService<Teacher> {
    /**
     * Учителя.
     */
    private static final List<Teacher> teachers = new LinkedList<>();

    /**
     * Создает нового пользователя
     *
     * @param id  ID
     * @param FIO ФИО
     * @param age Возраст
     * @return Созданный пользователь
     */
    @Override
    public Teacher create(Long id, String FIO, int age) {
        Teacher created = new Teacher(id, FIO, age);
        teachers.add(created);
        System.out.println("Создан:\n" + created);
        return created;
    }

    /**
     * Сортировка учителей
     *
     * @return Отсортированный список
     */
    @Override
    public List<Teacher> sort() {
        return teachers.stream().sorted(new UserComparator<>()).collect(Collectors.toList());
    }

    /**
     * Получает всех учителей
     */
    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    /**
     * Получает средний возраст пользователей
     *
     * @return Средний возраст
     */
    @Override
    public double getAverage() {
        return new AgeAverageService<Teacher>().calculateAverage(teachers);
    }
}

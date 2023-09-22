package au.bystritskaia.controllers.actors;

import au.bystritskaia.models.actors.Teacher;
import au.bystritskaia.services.actors.IUserService;
import au.bystritskaia.services.actors.TeacherService;

import java.util.stream.Collectors;

/**
 * Контролер учителей
 */
public class TeacherController implements IUserController<Teacher> {
    /**
     * Сервис учителей
     */
    private final IUserService<Teacher> service = new TeacherService();

    /**
     * Создать учителя
     *
     * @param id ИД учителя
     * @param FIO ФИО
     * @param age Возраст
     *
     * @return Новый учитель
     */
    @Override
    public Teacher create(Long id, String FIO, int age) {
        return this.service.create(id, FIO, age);
    }

    /**
     * Сортировка пользователей
     */
    @Override
    public void printSorted() {
        System.out.println(
                this.service
                        .sort()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    /**
     * Выводит список учителей
     */
    @Override
    public void print() {
        System.out.println(
                this.service.getAll()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    /**
     * Выводит средний возраст учителей
     */
    @Override
    public void printAverage() {
        System.out.println("Средний возраст учителей: " + this.service.getAverage());
    }
}

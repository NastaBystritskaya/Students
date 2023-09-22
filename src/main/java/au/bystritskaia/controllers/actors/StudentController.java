package au.bystritskaia.controllers.actors;

import au.bystritskaia.models.actors.Student;
import au.bystritskaia.services.actors.IUserService;
import au.bystritskaia.services.actors.StudentService;

import java.util.stream.Collectors;

/**
 * Контроллер студентов
 */
public class StudentController implements IUserController<Student> {
    /**
     * Сервис студентов
     */
    private final IUserService<Student> service = new StudentService();

    /**
     * Создать студента
     *
     * @param id  ИД студента
     * @param FIO ФИО студента
     * @param age Возраст студента
     * @return Новый студент
     */
    @Override
    public Student create(Long id, String FIO, int age) {
        return this.service.create(id, FIO, age);
    }

    /**
     * Сортировка студентов и вывод
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
     * Выводит список пользовтелей
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
     * Выводит средний возраст студетов
     */
    @Override
    public void printAverage() {
        System.out.println("Средний возраст студентов: " + this.service.getAverage());
    }
}
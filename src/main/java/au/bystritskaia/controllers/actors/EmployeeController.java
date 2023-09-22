package au.bystritskaia.controllers.actors;

import au.bystritskaia.models.actors.Employee;
import au.bystritskaia.services.actors.EmployeeService;
import au.bystritskaia.services.actors.IUserService;

import java.util.stream.Collectors;

/**
 * Контролер сотрудников
 */
public class EmployeeController implements IUserController<Employee> {
    /**
     * Сервис сотрудников
     */
    private final IUserService<Employee> service = new EmployeeService();

    /**
     * Создать учителя
     *
     * @param id ИД учителя
     * @param FIO ФИО
     * @param age Возраст
     *
     * @return Новый сотрудник
     */
    @Override
    public Employee create(Long id, String FIO, int age) {
        return this.service.create(id, FIO, age);
    }

    /**
     * Сортировка сотрудников
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
     * Выводит список сотрудников
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
     * Выводит средний возраст сотрудников
     */
    @Override
    public void printAverage() {
        System.out.println("Средний возраст сотрудников: " + this.service.getAverage());
    }
}

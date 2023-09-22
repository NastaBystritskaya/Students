package au.bystritskaia.services.actors;

import au.bystritskaia.models.actors.Employee;
import au.bystritskaia.models.actors.utils.UserComparator;
import au.bystritskaia.services.other.AgeAverageService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис сотрудников
 */
public class EmployeeService implements IUserService<Employee> {
    /**
     * Сотрудники.
     */
    private static final List<Employee> staff = new LinkedList<>();

    /**
     * Создает нового сотрудника
     *
     * @param id  ID
     * @param FIO ФИО
     * @param age Возраст
     * @return Созданный сотрудник
     */
    @Override
    public Employee create(Long id, String FIO, int age) {
        Employee created = new Employee(id, FIO, age);
        staff.add(created);
        System.out.println("Создан:\n" + created);
        return created;
    }

    /**
     * Сортировка учителей
     *
     * @return Отсортированный список
     */
    @Override
    public List<Employee> sort() {
        return staff.stream().sorted(new UserComparator<>()).collect(Collectors.toList());
    }

    /**
     * Получает всех учителей
     */
    @Override
    public List<Employee> getAll() {
        return staff;
    }

    /**
     * Получает средний возраст сотрудников
     *
     * @return Средний возраст
     */
    @Override
    public double getAverage() {
        return new AgeAverageService<Employee>().calculateAverage(staff);
    }
}

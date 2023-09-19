package au.bystritskaia.users.views;

import au.bystritskaia.users.controllers.EmployeeController;
import au.bystritskaia.users.controllers.IUserController;
import au.bystritskaia.users.models.Employee;

/**
 * Вью сотрудников
 */
public class EmployeeView implements IUserView<Employee> {
    /**
     * Контроллер сотрудников
     */
    IUserController<Employee> controller = new EmployeeController();

    /**
     * Вывести сотрудников
     */
    @Override
    public void view() {
        this.controller.print();
    }

    /**
     * Выводит отсортированный список сотрудников
     */
    @Override
    public void viewSorted() {
        this.controller.printSorted();
    }

    /**
     * Выводит средний возраст сотрудников
     */
    @Override
    public void viewAverage() {
        this.controller.printAverage();
    }
}

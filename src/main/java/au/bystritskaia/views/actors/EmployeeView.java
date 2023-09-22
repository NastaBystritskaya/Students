package au.bystritskaia.views.actors;

import au.bystritskaia.controllers.actors.EmployeeController;
import au.bystritskaia.controllers.actors.IUserController;
import au.bystritskaia.models.actors.Employee;

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

package au.bystritskaia.users.views;

import au.bystritskaia.users.controllers.IUserController;
import au.bystritskaia.users.controllers.StudentController;
import au.bystritskaia.users.models.Student;

/**
 * Вью студентов
 */
public class StudentView implements IUserView<Student> {
    /**
     * Контроллер студентов
     */
    IUserController<Student> controller = new StudentController();

    /**
     * Вывести студентов
     */
    @Override
    public void view() {
        this.controller.print();
    }

    /**
     * Выводит отсортированный список студентов
     */
    @Override
    public void viewSorted() {
        this.controller.printSorted();
    }

    /**
     * Выводит средний возраст студентов
     */
    @Override
    public void viewAverage() {
        this.controller.printAverage();
    }
}

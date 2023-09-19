package au.bystritskaia.users.views;

import au.bystritskaia.users.controllers.IUserController;
import au.bystritskaia.users.controllers.TeacherController;
import au.bystritskaia.users.models.Teacher;

public class TeacherView implements IUserView<Teacher> {
    /**
     * Контроллер учителей
     */
    IUserController<Teacher> controller = new TeacherController();

    /**
     * Вывести учителей
     */
    @Override
    public void view() {
        this.controller.print();
    }

    /**
     * Выводит отсортированный список учителей
     */
    @Override
    public void viewSorted() {
        this.controller.printSorted();
    }

    /**
     * Выводит средний возраст учителей
     */
    @Override
    public void viewAverage() {
        this.controller.printAverage();
    }
}

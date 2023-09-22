package au.bystritskaia.views.actors;

import au.bystritskaia.controllers.actors.IUserController;
import au.bystritskaia.controllers.actors.TeacherController;
import au.bystritskaia.models.actors.Teacher;

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

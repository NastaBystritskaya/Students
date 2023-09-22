package au.bystritskaia.views.actors;

import au.bystritskaia.models.actors.User;

/**
 * Вью пользователя
 * @param <T> Конкретный пользователь
 */
public interface IUserView <T extends User> {
    /**
     * Вывести пользователей
     */
    void view();

    /**
     * Выводит отсортированный список пользователей
     */
    void viewSorted();

    /**
     * Выводит средний возраст пользователей
     */
    void viewAverage();
}

package au.bystritskaia.users.views;

import au.bystritskaia.users.models.User;

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

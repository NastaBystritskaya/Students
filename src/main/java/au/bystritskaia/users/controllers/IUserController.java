package au.bystritskaia.users.controllers;

import java.util.List;

/**
 * Контроллер пользователей
 * @param <U> Конкретный пользоваетль
 */
public interface IUserController<U> {
    /**
     * Создать пользователя
     *
     * @param id ИД пользователя
     * @param FIO ФИО пользователя
     * @param age Возраст пользователя
     *
     * @return Новый пользователь
     */
    U create(Long id, String FIO, int age);

    /**
     * Сортировка пользователей и вывод
     */
    void printSorted();

    /**
     * Выводит список пользовтелей
     */
    void print();

    /**
     * Выводит средний возраст пользователей
     */
    void printAverage();
}

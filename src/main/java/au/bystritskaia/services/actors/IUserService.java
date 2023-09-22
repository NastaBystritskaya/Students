package au.bystritskaia.services.actors;

import au.bystritskaia.models.actors.User;

import java.util.List;

/**
 * Интерфейс сервисов пользователей
 * @param <U> Конкретный вид пользователя
 */
public interface IUserService<U extends User> {

    /**
     * Создает нового пользователя
     * @param id ID
     * @param FIO ФИО
     * @param age Возраст
     * @return Созданный пользователь
     */
    U create(Long id, String FIO, int age);

    /**
     * Сортировка пользователей
     * @return Отсортированный список
     */
    List<U> sort();

    /**
     * Получает всех пользовтелей
     */
    List<U> getAll();

    /**
     * Получает средний возраст пользователей
     * @return Средний возраст
     */
    double getAverage();
}

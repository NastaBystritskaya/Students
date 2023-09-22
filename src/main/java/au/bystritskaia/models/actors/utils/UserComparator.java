package au.bystritskaia.models.actors.utils;

import au.bystritskaia.models.actors.User;

import java.util.Comparator;

/**
 * Компаратор пользователей
 * @param <T> Конкретный пользователь
 */
public class UserComparator<T extends User> implements Comparator<T> {
    /**
     * Компарация
     * @param o1 1 объект.
     * @param o2 2 объект.
     * @return Результат сравнения
     */
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

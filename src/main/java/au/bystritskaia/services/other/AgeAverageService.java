package au.bystritskaia.services.other;

import au.bystritskaia.models.actors.User;

import java.util.List;

/**
 * Подсчет среднего возраста пользователя.
 * @param <T> Конкретный пользователь
 */
public class AgeAverageService <T extends User> {
    /**
     * Средний возраст
     * @param users пользователи
     * @return Средний возраст
     */
    public double calculateAverage(List<T> users) {
        return Math.round(users.stream().mapToInt(User::getAge).average().orElseThrow());
    }

}

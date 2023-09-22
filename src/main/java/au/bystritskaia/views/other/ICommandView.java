package au.bystritskaia.views.other;

import au.bystritskaia.enums.Commands;

public interface ICommandView {

    /**
     * Выбор вью по языку
     * @param lang Язык вью
     */
    boolean match(String lang);

    /**
     * Ввод команды
     * @param message Сообщение
     * @return Команда
     */
    Commands prompt(String message);

    /**
     * Вывод пользователю сообщение о след команде
     */
    void printCommandInputMessage();
}

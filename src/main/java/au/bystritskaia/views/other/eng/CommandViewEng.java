package au.bystritskaia.views.other.eng;

import au.bystritskaia.enums.Commands;
import au.bystritskaia.views.other.ICommandView;

public class CommandViewEng implements ICommandView {
    /**
     * Выбор вью по языку
     *
     * @param lang Язык вью
     */
    @Override
    public boolean match(String lang) {
        return lang.equalsIgnoreCase("eng");
    }

    /**
     * Ввод команды
     *
     * @param message Сообщение
     * @return Команда
     */
    @Override
    public Commands prompt(String message) {
        return Commands.valueOf(message.toUpperCase());
    }

    /**
     * Вывод пользователю сообщение о след команде
     */
    @Override
    public void printCommandInputMessage() {
        System.out.println("Enter a command");
    }
}

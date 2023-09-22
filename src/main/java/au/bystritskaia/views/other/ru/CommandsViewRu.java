package au.bystritskaia.views.other.ru;

import au.bystritskaia.enums.Commands;
import au.bystritskaia.views.other.ICommandView;

public class CommandsViewRu implements ICommandView {
    /**
     * Выбор вью по языку
     *
     * @param lang Язык вью
     */
    @Override
    public boolean match(String lang) {
        return lang.equalsIgnoreCase("ru") || lang.equalsIgnoreCase("рус");
    }

    public Commands prompt(String message) {
        return Commands.valueOf(message.toUpperCase());
    }

    public void printCommandInputMessage() {
        System.out.println("Введите комаду");
    }
}

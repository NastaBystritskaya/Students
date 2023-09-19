package au.bystritskaia.users.models;

/**
 * Учителя.
 */
public class Teacher extends User {
    /**
     * Конструктор учителя
     * @param id ИД
     * @param FIO ФИО
     * @param age Возраст
     */
    public Teacher(Long id, String FIO, int age) {
        super(id, FIO, age);
    }

    /**
     * В строку
     * @return Строчное значение преподавателя
     */
    @Override
    public String toString() {
        return """
                Преподаватель:
                id: %s
                ФИО: %s
                возраст: %d
                """.formatted(this.getId(), this.getFIO(), this.getAge());
    }
}

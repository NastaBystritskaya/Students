package au.bystritskaia.models.actors;

/**
 * Сотрудники
 */
public class Employee extends User {
    /**
     * Кончтруктор сотрудников
     * @param id Ид сотрудника
     * @param FIO ФИО ъъсотрудника
     * @param age Возраст сотрудника
     */
    public Employee(Long id, String FIO, int age) {
        super(id, FIO, age);
    }

    /**
     * В строку
     * @return Строчное значение сотрудника
     */
    @Override
    public String toString() {
        return """
                Сотрудник:
                id: %s
                ФИО: %s
                возраст: %d
                """.formatted(this.getId(), this.getFIO(), this.getAge());
    }
}

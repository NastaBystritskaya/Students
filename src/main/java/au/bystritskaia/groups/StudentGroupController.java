package au.bystritskaia.groups;

import au.bystritskaia.users.models.Student;

import java.util.List;

/**
 * Контроллер группы студентов.
 */
public class StudentGroupController {
    /**
     * Сервис группы студентов
     */
    private final StudentGroupService service;

    public StudentGroupController(StudentGroupService service) {
        this.service = service;
    }

    /**
     * Удаляет студента из группы по ФИО
     * @param FIO ФИО студента
     */
    public void removeStudent(String FIO) {
        this.removeStudent(FIO);
    }

    /**
     * Отсортировать студентов
     * @return Отсортированный список студентов
     */
    public List<Student> sortStudents() {
        return this.service.sortStudent();
    }


}

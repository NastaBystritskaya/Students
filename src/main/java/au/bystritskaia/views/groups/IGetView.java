package au.bystritskaia.views.groups;

import au.bystritskaia.models.groups.StudentGroup;

public interface IGetView {
    /**
     * Выбор вью по языку
     * @param lang Яцзык вью
     */
    boolean match(String lang);

    /**
     * Вывести инфо группы
     * @param group Группа
     */
    void printAllStudents(StudentGroup group);

    /**
     * Вывести сообщение создания студента
     */
    void printStudentCreateMessage();

    /**
     * Вывести сообщение создания учителя
     */
    void printTeacherCreateMessage();

    /**
     * Вывести сообщение создания группы
     */
    void printGroupCreateMessage();

    /**
     * Вывести сообщение воода ИД и имени группы
     */
    void printGroupIdAndName();

    /**
     * Вывести сообщение об успешном создании группы
     */
    void printGroupSuccessCreation();

    /**
     * Вывести сообщение об удалении студента
     */
    void printStudentRemove();

    /**
     * Вывести сообщение о успешном удалении студента
     */
    void removeStudentSuccess();

    /**
     * Вывести сообщение о неудачном удалении студента
     */
    void removeStudentError();

}

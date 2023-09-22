package au.bystritskaia.views.groups.ru;

import au.bystritskaia.enums.Commands;
import au.bystritskaia.models.groups.StudentGroup;
import au.bystritskaia.views.groups.IGetView;

public class GroupViewRu implements IGetView {

    /**
     * Выбор вью по языку
     *
     * @param lang Яцзык вью
     */
    @Override
    public boolean match(String lang) {
        return lang.equalsIgnoreCase("ru");
    }

    public void printAllStudents(StudentGroup group) {
        System.out.println("Группа: " + group.getId() + "." + group.getName());
        System.out.println("Преподаватель: " + group.getTeacher().getFIO());
        System.out.format("|%10s|%35s|%15s|%n", "ID", "ФИО", "Возраст");
        group.getStudents().forEach(student -> {
            System.out.format("|%10d|%35s|%15d|%n", student.getId(), student.getFIO(), student.getAge());
        });

    }

    public void printStudentCreateMessage() {
        System.out.println("Введите через запятую ИД, ФИО, Возраст студента(чтобы закончите введите '.')");
    }

    public void printTeacherCreateMessage() {
        System.out.println("Введите через запятую ИД, ФИО, Возраст учителя");
    }

    public void printGroupCreateMessage() {
        System.out.println("Создание группы");
    }

    public void printGroupIdAndName() {
        System.out.println("Введите ИД и имя группы через запятую");
    }

    public void printGroupSuccessCreation() {
        System.out.println("Группа успешно создана");
    }

    public void printStudentRemove() {
        System.out.println("Введите ИД удаления");
    }

    public void removeStudentSuccess() {
        System.out.println("Студент удален");
    }

    public void removeStudentError() {
        System.out.println("Студент не удален");
    }

}

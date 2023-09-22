package au.bystritskaia.services.groups;

import au.bystritskaia.models.actors.Student;
import au.bystritskaia.models.actors.Teacher;
import au.bystritskaia.models.groups.StudentGroup;

import java.util.List;
import java.util.Optional;

/**
 * Скрвис группы студетов
 */
public class StudentGroupService {
    /**
     * Создание группы
     * @param id ИД группы
     * @param name Имя группы
     * @param students Студенты
     * @param teacher Учитель
     * @return Новая группа
     */
    public StudentGroup createGroup(Long id, String name, List<Student> students, Teacher teacher) {
        System.out.printf("Зоздается группа %s.%s%n", id, name);
        return new StudentGroup(id, name, students, teacher);
    }

    /**
     * Удалить студента из группы по ИД
     * @param id ИД студента
     */
    public Student removeStudent(Long id, StudentGroup group) {
        System.out.println("Удаление студента с ID - " + id + " из группы " + group.getName());
        System.out.println("Поиск студента с ID - " + id);
        Optional<Student> result = group.getStudents().stream().filter(student -> student.getId().equals(id)).findFirst();
        if(result.isPresent()) {
            System.out.println("Студент найден: " + result.get().getFIO());
            group.getStudents().remove(result.get());
            System.out.println("Студент удален: " + result.get().getFIO());
            return result.get();
        } else {
            System.out.println("Студент не найден: ");
            return null;
        }
    }

    /**
     * Добавление студент
     * @param id ИД студента
     * @param FIO ФИО студента
     * @param age Возраст студента
     * @param group Группа, в которую нужно добавить
     * @return Добавленый студент
     */
    public Student addStudent(Long id, String FIO, int age, StudentGroup group) {
        System.out.println("Добавление студента " + FIO + " в группу " + group.getName());
        Student student = new Student(id, FIO, age);
        group.getStudents().add(student);
        System.out.println("Студент успешно добавлен");
        return student;
    }
}

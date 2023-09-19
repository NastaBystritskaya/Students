package au.bystritskaia.groups;

import au.bystritskaia.users.models.Student;
import au.bystritskaia.users.models.UserComparator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Скрвис группы студетов
 */
public class StudentGroupService {
    /**
     * Группа студентов
     */
    private final StudentGroup group;

    /**
     * Конструктор группы студентов
     * @param group Группа
     */
    public StudentGroupService(StudentGroup group) {
        this.group = group;
    }

    /**
     * Удалить студента из группы по ФИО
     * @param FIO ФИО
     */
    public void removeStudent(String FIO) {
        Iterator<Student> iter = this.group.iterator();
        while (iter.hasNext()) {
            if(iter.next().getFIO().equalsIgnoreCase(FIO))
                iter.remove();
        }
    }

    /**
     * Отсортировать студентов в группе
     * @return Отсортированный список студентов
     */
    public List<Student> sortStudent() {
        return this.group.students.stream().sorted(new UserComparator<>()).collect(Collectors.toList());
    }
}

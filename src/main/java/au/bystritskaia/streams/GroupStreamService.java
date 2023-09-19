package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис потока
 */
public class GroupStreamService {
    /**
     * Поток
     */
    private final GroupStream stream;

    /**
     * Конструктор сервиса потока
     * @param stream Поток
     */
    public GroupStreamService(GroupStream stream) {
        this.stream = stream;
    }

    /**
     * Вывести группы в потоке
     */
    public void printGroups() {
        for (StudentGroup students : stream) {
            System.out.println(students.toString());
        }
    }

    /**
     * Сортировка групп
     * @return Отсортированный список групп в потоке
     */
    public List<StudentGroup> sortGroups() {
        StudentGroupCountComparator countComparator = new StudentGroupCountComparator();
        StudentGroupIDComparator idComparator = new StudentGroupIDComparator();
        return this.stream.getGroups().stream().sorted(countComparator.thenComparing(idComparator)).collect(Collectors.toList());
    }
}

package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroup;

import java.util.Comparator;

/**
 * Компаратор групп по количеству
 */
public class StudentGroupCountComparator implements Comparator<StudentGroup> {

    /**
     * Сопоставляет группы в потоке по количеству
     * @param o1 1 группа
     * @param o2 2 группа
     * @return Результат сравнивания
     */
    @Override
    public int compare(StudentGroup o1, StudentGroup o2) {
        return Integer.compare(o2.getStudents().size(), o1.getStudents().size());
    }
}

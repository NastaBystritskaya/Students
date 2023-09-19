package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroup;

import java.util.Comparator;

/**
 * Компаратор групп в потоке по ID.
 */
public class StudentGroupIDComparator implements Comparator<StudentGroup> {
    /**
     * Сопоставляет группы в потоке по ID
     * @param o1 1 группа
     * @param o2 2 группа
     * @return Результат
     */
    @Override
    public int compare(StudentGroup o1, StudentGroup o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

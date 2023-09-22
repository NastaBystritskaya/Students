package au.bystritskaia.models.streams;

import au.bystritskaia.models.groups.StudentGroup;
import au.bystritskaia.models.streams.utils.GroupStreamIterator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Поток студентов
 */
public class GroupStream implements Iterable<StudentGroup>{
    /**
     * Группы потока
     */
    private List<StudentGroup> groups;
    /**
     * Номер потока
     */
    private int streamNum;

    /**
     * Конструктор потока
     * @param groups Группы
     * @param streamNum Номер
     */
    public GroupStream(List<StudentGroup> groups, int streamNum) {
        this.groups = groups;
        this.streamNum = streamNum;
    }

    /**
     * Получить список групп
     * @return Список групп
     */
    public List<StudentGroup> getGroups() {
        return groups;
    }
    /**
     * Изменить список групп
     */
    public void setGroups(List<StudentGroup> groups) {
        this.groups = groups;
    }

    /**
     * Получить номер потока
     * @return Номер потока
     */
    public int getStreamNum() {
        return streamNum;
    }

    /**
     * Изменить номер потока
     * @param streamNum Новый номер потока
     */
    public void setStreamNum(int streamNum) {
        this.streamNum = streamNum;
    }

    /**
     * В строку
     * @return Строчное представление потока
     */
    @Override
    public String toString() {
        return """
                Номер потока: %d
                Количество групп: %d
                Студенты: %s
                """.formatted(
                        this.streamNum,
                this.groups.size(),
                this.groups.stream()
                        .map(g ->
                                g.getStudents()
                                        .stream()
                                        .map(
                                                s -> g.getId() + "." + s.getFIO())
                                        .collect(Collectors.joining(",\n")))
                        .collect(Collectors.joining("\n")));
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<StudentGroup> iterator() {
        return new GroupStreamIterator(this);
    }
}

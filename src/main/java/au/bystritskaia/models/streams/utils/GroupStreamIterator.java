package au.bystritskaia.models.streams.utils;

import au.bystritskaia.models.groups.StudentGroup;
import au.bystritskaia.models.streams.GroupStream;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор групп в потоке
 */
public class GroupStreamIterator implements Iterator<StudentGroup> {
    /**
     * Поток
     */
    private final GroupStream stream;
    /**
     * Текущий индекс группы
     */
    private int currentIndex;
    /**
     * Текущая группа
     */
    private StudentGroup current;

    /**
     * Конструктор итератора
     * @param stream Поток
     */
    public GroupStreamIterator(GroupStream stream) {
        this.stream = stream;
    }

    /**
     * Проверяет есть ли следующая группа в потоке
     *
     * @return Результат проверки
     */
    @Override
    public boolean hasNext() {
        return (this.stream.getGroups().size() > 0 && this.currentIndex < this.stream.getGroups().size());
    }

    /**
     * Получает следующую группу в потоке
     *
     * @return Следующая группа в потоке
     * @throws NoSuchElementException Если нет групп больше
     */
    @Override
    public StudentGroup next() throws NoSuchElementException {
        if(!this.hasNext())
            throw new NoSuchElementException("Групп студентов больше нет");
        this.current = this.stream.getGroups().get(this.currentIndex);
        this.currentIndex++;
        return this.current;
    }

    /**
     * Удалить группу из потока
     */
    @Override
    public void remove() {
        if(this.current != null)
            this.stream.getGroups().remove(this.current);
    }
}

package au.bystritskaia.models.groups.utils;

import au.bystritskaia.models.actors.Student;
import au.bystritskaia.models.groups.StudentGroup;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Итератор группы студентов
 */
public class StudentGroupIterator implements Iterator<Student>{

    /**
     * Группа студентов
     */
    private final StudentGroup group;

    /**
     * Количество студентов в группе
     */
    private final int size;
    /**
     * Индекс следующего студента
     */
    private int nextIndex = 0;
    /**
     * Текущий студент
     */
    private Student current;

    /**
     * Конструктор итератора
     * @param group Группа студентовв
     */
    public StudentGroupIterator(StudentGroup group) {
        this.group = group;
        this.size = this.group.getStudents().size();
    }

    /**
     * Проверяет есть ли в группе следующитй студент.
     * @return Результат проверки
     */
    @Override
    public boolean hasNext() {
        return this.size > 0;
    }

    /**
     * Получет следующего студента из итератора
     *
     * @return Следующий студент
     * @throws NoSuchElementException если больше нет студентов в итераторе
     */
    @Override
    public Student next() throws NoSuchElementException {
        if(this.size == 0 || this.nextIndex >= this.size)
            throw new NoSuchElementException("Больше нет студентов");

        this.current = this.group.getStudents().get(this.nextIndex);
        this.nextIndex++;
        return this.current;
    }

    /**
     * Удаляет текущего студента
     */
    @Override
    public void remove() {
        if(this.current != null)
           this.group.getStudents().remove(this.current);
    }

    /**
     * Переччисление каждого студента
     * @param action Действие над студентом
     */
    @Override
    public void forEachRemaining(Consumer<? super Student> action) {
        Iterator.super.forEachRemaining(action);
    }


}

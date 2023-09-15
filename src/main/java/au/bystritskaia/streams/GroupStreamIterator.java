package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroup;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GroupStreamIterator implements Iterator<StudentGroup> {

    private GroupStream stream;
    private int currentIndex;

    private StudentGroup current;

    public GroupStreamIterator(GroupStream stream) {
        this.stream = stream;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return (this.stream.getGroups().size() > 0 && this.currentIndex < this.stream.getGroups().size());
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
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
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.
     * <p>
     * The behavior of an iterator is unspecified if the underlying collection
     * is modified while the iteration is in progress in any way other than by
     * calling this method, unless an overriding class has specified a
     * concurrent modification policy.
     * <p>
     * The behavior of an iterator is unspecified if this method is called
     * after a call to the {@link #forEachRemaining forEachRemaining} method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code next} method has not
     *                                       yet been called, or the {@code remove} method has already
     *                                       been called after the last call to the {@code next}
     *                                       method
     * @implSpec The default implementation throws an instance of
     * {@link UnsupportedOperationException} and performs no other action.
     */
    @Override
    public void remove() {
        if(this.current != null)
            this.stream.getGroups().remove(this.current);
    }
}

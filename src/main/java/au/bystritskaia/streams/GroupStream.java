package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroup;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupStream implements Iterable<StudentGroup>{

    private List<StudentGroup> groups = new LinkedList<>();

    private int streamNum;

    public GroupStream(List<StudentGroup> groups, int streamNum) {
        this.groups = groups;
        this.streamNum = streamNum;
    }

    public List<StudentGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<StudentGroup> groups) {
        this.groups = groups;
    }

    public int getStreamNum() {
        return streamNum;
    }

    public void setStreamNum(int streamNum) {
        this.streamNum = streamNum;
    }

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

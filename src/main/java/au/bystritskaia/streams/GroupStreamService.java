package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroup;

import java.util.List;
import java.util.stream.Collectors;

public class GroupStreamService {

    private GroupStream stream;

    public GroupStreamService(GroupStream stream) {
        this.stream = stream;
    }

    public void printGroups() {
        for (StudentGroup students : stream) {
            System.out.println(students.toString());
        }
    }

    public List<StudentGroup> sortGroups() {
        StudentGroupCountComparator countComparator = new StudentGroupCountComparator();
        StudentGroupIDComparator idComparator = new StudentGroupIDComparator();
        return this.stream.getGroups().stream().sorted(countComparator.thenComparing(idComparator)).collect(Collectors.toList());
    }
}

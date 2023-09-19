package au.bystritskaia.groups;

import au.bystritskaia.users.models.Student;
import au.bystritskaia.users.models.UserComparator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentGroupService {

    private StudentGroup group;

    public StudentGroupService(StudentGroup group) {
        this.group = group;
    }

    public void removeStudent(String FIO) {
        Iterator<Student> iter = this.group.iterator();
        while (iter.hasNext()) {
            if(iter.next().getFIO().equalsIgnoreCase(FIO))
                iter.remove();
        }
    }

    public List<Student> sortStudent() {
        return this.group.students.stream().sorted(new UserComparator<>()).collect(Collectors.toList());
    }
}

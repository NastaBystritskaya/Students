package au.bystritskaia.views.groups.eng;

import au.bystritskaia.models.groups.StudentGroup;
import au.bystritskaia.views.groups.IGetView;

public class GroupViewEng implements IGetView {
    @Override
    public boolean match(String lang) {
        return lang.equalsIgnoreCase("eng");
    }

    @Override
    public void printAllStudents(StudentGroup group) {
        System.out.println("Group: " + group.getId() + "." + group.getName());
        System.out.println("Teacher: " + group.getTeacher().getFIO());
        System.out.format("|%10s|%35s|%15s|%n", "ID", "Name", "Age");
        group.getStudents().forEach(student -> {
            System.out.format("|%10d|%35s|%15d|%n", student.getId(), student.getFIO(), student.getAge());
        });
    }

    @Override
    public void printStudentCreateMessage() {
        System.out.println("Enter student info with ',' separator ID, Name, Age of student(for quit enter '.')");
    }

    @Override
    public void printTeacherCreateMessage() {
        System.out.println("Enter teacher info with ',' separator ID, Name, Age");
    }

    @Override
    public void printGroupCreateMessage() {
        System.out.println("Group creation");
    }

    @Override
    public void printGroupIdAndName() {
        System.out.println("Enter ID and name of group with ',' separator");
    }

    @Override
    public void printGroupSuccessCreation() {
        System.out.println("Group was created");
    }

    @Override
    public void printStudentRemove() {
        System.out.println("Enter an ID of student for delete");
    }

    @Override
    public void removeStudentSuccess() {
        System.out.println("Student was deleted");
    }

    @Override
    public void removeStudentError() {
        System.out.println("Student was not deleted");
    }
}

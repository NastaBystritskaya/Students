package au.bystritskaia.groups;

import au.bystritskaia.users.models.Student;

import java.util.List;

public class StudentGroupController {

    private StudentGroupService service;

    public StudentGroupController(StudentGroupService service) {
        this.service = service;
    }

    public void removeStudent(String FIO) {
        this.removeStudent(FIO);
    }

    public List<Student> sortStudents() {
        return this.service.sortStudent();
    }


}

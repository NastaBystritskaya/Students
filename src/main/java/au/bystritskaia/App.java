package au.bystritskaia;

import au.bystritskaia.groups.StudentGroup;
import au.bystritskaia.streams.GroupStream;
import au.bystritskaia.streams.GroupStreamController;
import au.bystritskaia.streams.GroupStreamService;
import au.bystritskaia.users.controllers.EmployeeController;
import au.bystritskaia.users.controllers.IUserController;
import au.bystritskaia.users.controllers.StudentController;
import au.bystritskaia.users.controllers.TeacherController;
import au.bystritskaia.users.models.Employee;
import au.bystritskaia.users.models.Student;
import au.bystritskaia.users.models.Teacher;
import au.bystritskaia.users.views.EmployeeView;
import au.bystritskaia.users.views.IUserView;
import au.bystritskaia.users.views.StudentView;
import au.bystritskaia.users.views.TeacherView;

import java.util.List;

/**
 * Hello world!
 */
public class App {

    private static IUserController<Student> studentsController = new StudentController();
    private static IUserView<Student> studentView = new StudentView();

    private static IUserController<Teacher> teacherController = new TeacherController();
    private static IUserView<Teacher> teacherView = new TeacherView();

    private static IUserController<Employee> employeeController = new EmployeeController();
    private static IUserView<Employee> employeeView = new EmployeeView();

    public static void main(String[] args) {

        studentsController.create(1L, "Машина Маша", 23);
        studentsController.create(2L, "Пашин Паша", 24);
        studentsController.create(3L, "Мишин Миша", 20);

        teacherController.create(1L, "Иванова Мария Михайловна", 49);
        teacherController.create(2L, "Степашин Петр Сергеевич", 53);
        teacherController.create(3L, "Соловьев Игорь Петрович", 38);

        employeeController.create(1L, "Сидорова Антонина Юрьевна", 54);
        employeeController.create(2L, "Викторов Григортий Валентинович", 20);
        employeeController.create(3L, "Березовская Алефтина Афанасьевна", 64);

        System.out.println("Список студентов ====================================");
        studentView.view();
        System.out.println("=====================================================");

        System.out.println("Список студентов отсортированных=====================");
        studentView.viewSorted();
        System.out.println("=====================================================");

        System.out.println("Средний возраст студентов ===========================");
        studentView.viewAverage();
        System.out.println("=====================================================");

        System.out.println("Список преподавателей ================================");
        teacherView.view();
        System.out.println("=====================================================");

        System.out.println("Список преподавателей отсортированных ===============");
        teacherView.viewSorted();
        System.out.println("=====================================================");

        System.out.println("Средний возраст преподавателей ======================");
        teacherView.viewAverage();
        System.out.println("=====================================================");

        System.out.println("Список сотрудников ==================================");
        employeeView.view();
        System.out.println("=====================================================");

        System.out.println("Список сотрудников отсортированных ==================");
        employeeView.viewSorted();
        System.out.println("=====================================================");

        System.out.println("Средний возраст сотрудников =========================");
        employeeView.viewAverage();
        System.out.println("=====================================================");


    }
}

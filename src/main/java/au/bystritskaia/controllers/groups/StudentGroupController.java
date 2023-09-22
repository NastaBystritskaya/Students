package au.bystritskaia.controllers.groups;

import au.bystritskaia.enums.Commands;
import au.bystritskaia.models.actors.Student;
import au.bystritskaia.models.actors.Teacher;
import au.bystritskaia.models.groups.StudentGroup;
import au.bystritskaia.services.groups.StudentGroupService;
import au.bystritskaia.views.groups.eng.GroupViewEng;
import au.bystritskaia.views.groups.ru.GroupViewRu;
import au.bystritskaia.views.groups.IGetView;
import au.bystritskaia.views.other.eng.CommandViewEng;
import au.bystritskaia.views.other.ru.CommandsViewRu;
import au.bystritskaia.views.other.ICommandView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер группы студентов.
 */
public class StudentGroupController implements Runnable {

    /**
     * Созданные группы
     */
    private final List<StudentGroup> groups = new LinkedList<>();
    /**
     * Студенты
      */
    private List<Student> students = new LinkedList<>();

    /**
     * Сервис группы студентов
     */
    private final StudentGroupService service = new StudentGroupService();
    /**
     * Команды
     */
    private final List<ICommandView> commands = List.of(
            new CommandsViewRu(),
            new CommandViewEng()
    );
    /**
     * Вью
     */
    private final List<IGetView> views = List.of(
            new GroupViewRu(),
            new GroupViewEng()
    );
    /**
     * Текущее вью
     */
    private IGetView currentView;
    /**
     * Текущие команды
     */
    private ICommandView currentCommands;

    /**
     * Получить текущие команды по яхыку
     * @param lang Язык
     * @return Команды
     */
    private ICommandView getCurrentCommands(String lang) {
        return this.commands.stream().filter(c -> c.match(lang)).findFirst().orElseThrow();
    }

    /**
     * получить текущее аью по языку
     * @param lang Язык
     * @return Вью
     */
    private IGetView getCurrentView(String lang) {
        return this.views.stream().filter(c -> c.match(lang)).findFirst().orElseThrow();
    }


    /**
     * Удаляет студента из группы по ФИО
     */
    public void removeStudent() {
        this.currentView.printStudentRemove();
        this.groups.stream().filter(group ->
                this.service.removeStudent(
                    Long.parseLong(this.getCommand().trim()),
                    group) != null)
                .findFirst()
                .ifPresentOrElse(
                    student -> this.currentView.removeStudentSuccess(),
                    () -> this.currentView.removeStudentError()
        );

    }

    public void createGroup() {
        this.students = new LinkedList<>();
        this.currentView.printGroupCreateMessage();
        do {
            this.currentView.printStudentCreateMessage();
            String command = this.getCommand();
            if(command.equalsIgnoreCase("."))
                break;
            this.createStudent(command);
        } while (true);
        Teacher teacher = this.createTeacher();
        this.createGroup(teacher);
        this.currentView.printGroupSuccessCreation();
    }

    /**
     * Созадание группы по учителю
     * @param teacher Учитель
     */
    private void createGroup(Teacher teacher) {
        this.currentView.printGroupIdAndName();
        String[] parts = this.getCommand().split(",");
        StudentGroup group = new StudentGroup(
                Long.parseLong(parts[0].trim()),
                parts[1].trim(),
                this.students,
                teacher);
        this.groups.add(group);
    }

    /**
     * Создагние учителя
     * @return Учитель
     */
    private Teacher createTeacher() {
        this.currentView.printTeacherCreateMessage();
        String[] parts = this.getCommand().split(",");
        return new Teacher(
                Long.parseLong(parts[0].trim()),
                parts[1].trim(),
                Integer.parseInt(parts[2].trim())
        );
    }

    /**
     * Создагние студента
     * @param command Воод пользователя
     */
    private void createStudent(String command) {
        String[] parts = command.split(",");
        Student student = new Student(
                Long.parseLong(parts[0].trim()),
                parts[1].trim(),
                Integer.parseInt(parts[2].trim())
        );
        this.students.add(student);
    }

    /**
     * Выполнение команд
     * @param commands Команда
     */

    public void doCommand(Commands commands) {
        switch (commands) {
            case CREATE -> this.createGroup();
            case DELETE_STUDENT -> this.removeStudent();
            case PRINT -> this.groups.forEach(g -> this.currentView.printAllStudents(g));
        }
    }

    /**
     * Запуск
     */
    @Override
    public void run() {
        Commands current;
        do {
            if(this.currentCommands == null) {
                System.out.println("Введите язык программы:");
                String lang = getCommand();
                this.currentCommands = this.getCurrentCommands(lang);
                this.currentView = this.getCurrentView(lang);
            }

            this.currentCommands.printCommandInputMessage();
            current = this.currentCommands.prompt(this.getCommand());
            this.doCommand(current);
        } while (!current.equals(Commands.EXIT));
    }

    /**
     * Получить команду из консоли
     * @return Команда
     */
    private String getCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

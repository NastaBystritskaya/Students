package au.bystritskaia.models.actors;

import au.bystritskaia.models.actors.utils.UserComparator;

public class Student extends User implements Comparable<Student>{


    public Student(Long id, String FIO, int age) {
        super(id, FIO, age);
    }

    @Override
    public int compareTo(Student o) {
        return  new UserComparator<Student>().compare(this, o);
    }

    @Override
    public String toString() {
        return """
                Студент:
                id: %s
                ФИО: %s
                возраст: %d
                """.formatted(this.getId(), this.getFIO(), this.getAge());
    }
}

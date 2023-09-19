package au.bystritskaia.users.models;

public class User {
    private Long id;

    private String FIO;
    private int age;

    public User(Long id, String FIO, int age) {
        this.id = id;
        this.FIO = FIO;
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

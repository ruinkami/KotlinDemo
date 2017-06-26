package app.ruinkami.kotlindemo.java;

/**
 * Created by ruinkami on 2017/6/25.
 */

public class JStudent {

    private int id;
    private String name;
    private int age;
    private String hobby;
    private String university;

    public JStudent(int id, String name, int age, String hobby, String university) {
        setId(id);
        setName(name);
        setAge(age);
        setHobby(hobby);
        setUniversity(university);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    public String getUniversity() {
        return university;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}

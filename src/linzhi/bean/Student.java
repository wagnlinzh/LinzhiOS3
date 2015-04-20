package linzhi.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanglinzhizhi on 15-4-8.
 */
public class Student {

    private String id;
    private String name;
    private String email;
    private String password;
    private Set<Course> courses = new HashSet<Course>();
    private Set<Score> scores=new HashSet<Score>();



    public Student() {
    }

    public Student(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!email.equals(student.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}

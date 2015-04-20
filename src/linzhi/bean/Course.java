package linzhi.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanglinzhizhi on 15-4-8.
 */
public class Course {
    private String id;
    private String name;
    private Set<Student> students=new HashSet<Student>();
    private Set<Score> scores=new HashSet<Score>();


    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

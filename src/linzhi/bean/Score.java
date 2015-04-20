package linzhi.bean;

/**
 * Created by wanglinzhizhi on 15-4-8.
 */
public class Score {

    private String id;
    private int score;
    private int classTimeNum;
    private int classType;//classType=1 必修，classType =0 选修
    private Student student;
    private Course course;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getClassTimeNum() {
        return classTimeNum;
    }

    public void setClassTimeNum(int classTimeNum) {
        this.classTimeNum = classTimeNum;
    }
}

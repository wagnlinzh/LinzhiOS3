package linzhi.bean;

/**
 * Created by wanglinzhizhi on 15-4-20.
 */
public class ClassDetail {
    private String className;
    private int classTimeNum;
    private int classType;//选修：0 必修：1

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassTimeNum() {
        return classTimeNum;
    }

    public void setClassTimeNum(int classTimeNum) {
        this.classTimeNum = classTimeNum;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }
}

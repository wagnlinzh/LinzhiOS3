package linzhi.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wanglinzhizhi on 15-4-15.
 */
public class CourseTips extends ActionSupport {
    private String classTime;

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @Override
    public String execute() throws Exception {

        System.out.println("classTime_CourseTips : "+classTime);

        String realclassTime=null;


            switch (classTime) {
                case "9":realclassTime="Monday Morning #1";break;
                case "10":realclassTime="Thesday Morning #1";break;
                case "11":realclassTime="Wenday Morning #1";break;
                case "12":realclassTime="Thursday Morning #1";break;
                case "13":realclassTime="Friday Morning #1";break;
                case "14":realclassTime="Saturday Morning #1";break;
                case "15":realclassTime="Sunday Morning #1";break;
//                case "16":realclassTime="Monday Morning #1";break;
                case "17":realclassTime="Monday Morning #2";break;
                case "18":realclassTime="Thesday Morning #2";break;
                case "19":realclassTime="Wenday Morning #2";break;
                case "20":realclassTime="Thursday Morning #2";break;
                case "21":realclassTime="Friday Morning #2";break;
                case "22":realclassTime="Saturday Morning #2";break;
                case "23":realclassTime="Sunday Morning #2";break;
//                case "24":realclassTime="Monday Morning #1";break;
                case "25":realclassTime="Monday Afternoon #1";break;
                case "26":realclassTime="Thesday Afternoon #1";break;
                case "27":realclassTime="Wenday Afternoon #1";break;
                case "28":realclassTime="Thursday Afternoon #1";break;
                case "29":realclassTime="Friday Afternoon #1";break;
                case "30":realclassTime="Saturday Afternoon #1";break;
                case "31":realclassTime="Sunday Afternoon #1";break;
//                case "32":realclassTime="Monday Morning #1";break;
                case "33":realclassTime="Monday Afternoon #2";break;
                case "34":realclassTime="Thesday Afternoon #2";break;
                case "35":realclassTime="Wenday Afternoon #2";break;
                case "36":realclassTime="Thursday Afternoon #2";break;
                case "37":realclassTime="Friday Afternoon #2";break;
                case "38":realclassTime="Saturday Afternoon #2";break;
                case "39":realclassTime="Sunday Afternoon #2";break;
//                case "40":realclassTime="Monday Morning #1";break;
                case "41":realclassTime="Monday Evening #1";break;
                case "42":realclassTime="Thesday Evening #1";break;
                case "43":realclassTime="Wenday Evening #1";break;
                case "44":realclassTime="Thursday Evening #1";break;
                case "45":realclassTime="Friday Evening #1";break;
                case "46":realclassTime="Saturday Evening #1";break;
                case "47":realclassTime="Sunday Evening #1";break;
//                case "48":realclassTime="Monday Morning #1";break;
                case "49":realclassTime="Monday Evening #2";break;
                case "50":realclassTime="Thesday Evening #2";break;
                case "51":realclassTime="Wenday Evening #2";break;
                case "52":realclassTime="Thursday Evening #2";break;
                case "53":realclassTime="Friday Evening #2";break;
                case "54":realclassTime="Saturday Evening #2";break;
                case "55":realclassTime="Sunday Evening #2";break;
                default:break;
            }

        int a=Integer.parseInt(classTime);

        ActionContext.getContext().getSession().put("classTimeReal",realclassTime);
        ActionContext.getContext().getSession().put("classTimeNum",classTime);



        return SUCCESS;
    }
}

package linzhi.service.impl;

import linzhi.DAO.ScoreManagerDAO;
import linzhi.DAO.impl.ScoreManagerDAOImpl;
import linzhi.service.UpdateSCInfo;

/**
 * Created by wanglinzhizhi on 15-4-20.
 */
public class UpdateSCInfoImpl implements UpdateSCInfo {
    @Override
    public void updateSCInfo(String email,String className, int classTimeNum, int classType) {
        ScoreManagerDAO scoreManagerDAO=new ScoreManagerDAOImpl();

        scoreManagerDAO.updateSCInfo(email,className, classTimeNum, classType);
    }
}

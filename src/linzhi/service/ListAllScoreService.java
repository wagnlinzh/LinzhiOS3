package linzhi.service;

import linzhi.bean.Score;

import java.util.List;

/**
 * Created by wanglinzhizhi on 15-4-8.
 */
public interface ListAllScoreService {
    public List<Score> listAllScore(String email);
}

package com.lihuanyu.informationquerysystem.service;

import com.lihuanyu.informationquerysystem.GsonTemplate.ScoreJsonInfo;
import com.lihuanyu.informationquerysystem.InformationquerysystemApplication;
import com.lihuanyu.informationquerysystem.model.ClassroomMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InformationquerysystemApplication.class)
@WebAppConfiguration
public class GetScoreTest {

    public String testMessage1 = "{\"Table\":[{\"XQM\":\"2015-2016-1\",\"KCCJ\":65,\"KCMC\":\"通信电子线路\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":76,\"KCMC\":\"通信原理\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":91,\"KCMC\":\"微机原理\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":78,\"KCMC\":\"通信原理课程设计\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":85,\"KCMC\":\"计算机网络原理\"},{\"XQM\":\"2014-2015-3\",\"KCCJ\":100,\"KCMC\":\"通信软件综合实践\"},{\"XQM\":\"2014-2015-3\",\"KCCJ\":82,\"KCMC\":\"通信电子实习\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":87,\"KCMC\":\"体育(4-4)\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":76,\"KCMC\":\"网络营销学\"}]}";

    public String testMessage2 = "{\"Table\":[]}";

    @Autowired
    private GetScore getScore;

    @Test
    public void testGetScoreNull(){
        ArrayList<ScoreJsonInfo.ScoreInfo> scoreInfos =  getScore.getScoreList(testMessage2);
        if (scoreInfos.isEmpty()){
            System.out.println("yes");
        }
    }

    @Test
    public void testGetScore(){
        ArrayList<ScoreJsonInfo.ScoreInfo> scoreInfos =  getScore.getScoreList(testMessage1);
        ScoreJsonInfo.ScoreInfo scoreInfo = scoreInfos.get(0);
        System.out.println(scoreInfo.KCMC);
    }
}

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
import java.util.Arrays;

/**
 * Created by skyADMIN on 16/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InformationquerysystemApplication.class)
@WebAppConfiguration
public class GetScoreTest {

    public String testMessage1 = "{\"Table\":[{\"XQM\":\"2015-2016-1\",\"KCCJ\":65,\"KCMC\":\"通信电子线路\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":76,\"KCMC\":\"通信原理\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":91,\"KCMC\":\"微机原理\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":78,\"KCMC\":\"通信原理课程设计\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":85,\"KCMC\":\"计算机网络原理\"},{\"XQM\":\"2014-2015-3\",\"KCCJ\":100,\"KCMC\":\"通信软件综合实践\"},{\"XQM\":\"2014-2015-3\",\"KCCJ\":82,\"KCMC\":\"通信电子实习\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":87,\"KCMC\":\"体育(4-4)\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":76,\"KCMC\":\"网络营销学\"}]}";

    public String testMessage2 = "{\"Table\":[]}";

    public String testMessage3 = "{\"Table\":[{\"XQM\":\"2015-2016-1\",\"KCCJ\":65,\"KCMC\":\"通信电子线路\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":76,\"KCMC\":\"通信原理\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":91,\"KCMC\":\"微机原理\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":78,\"KCMC\":\"通信原理课程设计\"},{\"XQM\":\"2015-2016-1\",\"KCCJ\":85,\"KCMC\":\"计算机网络原理\"},{\"XQM\":\"2014-2015-3\",\"KCCJ\":100,\"KCMC\":\"通信软件综合实践\"},{\"XQM\":\"2014-2015-3\",\"KCCJ\":82,\"KCMC\":\"通信电子实习\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":87,\"KCMC\":\"体育(4-4)\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":76,\"KCMC\":\"网络营销学\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":70,\"KCMC\":\"模拟电子技术\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":46,\"KCMC\":\"信号与系统\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":79,\"KCMC\":\"数据库技术与应用\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":80,\"KCMC\":\"数字电路与EDA设计\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":92,\"KCMC\":\"西方文明通论\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":75,\"KCMC\":\"计算机技术综合实验\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":88,\"KCMC\":\"大学物理实验(2-2)\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":85,\"KCMC\":\"中国化马克思主义\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":54,\"KCMC\":\"大学英语(提高)(2-2)\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":61,\"KCMC\":\"数字逻辑与数字系统\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":75,\"KCMC\":\"大学英语视听说(4-4)\"},{\"XQM\":\"2014-2015-2\",\"KCCJ\":61,\"KCMC\":\"大学英语(提高)(2-2)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":63,\"KCMC\":\"电路分析\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":81,\"KCMC\":\"大学英语视听说(4-3)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":69,\"KCMC\":\"大学英语(提高)(2-1)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":86,\"KCMC\":\"大学物理实验(2-1)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":60,\"KCMC\":\"大学物理(2-2)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":42,\"KCMC\":\"大学物理(2-2)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":84,\"KCMC\":\"程序设计(JAVA)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":96,\"KCMC\":\"经济学百年\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":95,\"KCMC\":\"创业基础\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":63,\"KCMC\":\"复变函数与积分变换\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":80,\"KCMC\":\"体育(4-3)\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":62,\"KCMC\":\"概率论与数理统计\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":87,\"KCMC\":\"电路分析实验\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":76,\"KCMC\":\"马克思主义基本原理\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":71,\"KCMC\":\"哲学导论\"},{\"XQM\":\"2014-2015-1\",\"KCCJ\":82,\"KCMC\":\"数据结构与算法\"},{\"XQM\":\"2013-2014-3\",\"KCCJ\":91,\"KCMC\":\"专业认识实习\"},{\"XQM\":\"2013-2014-3\",\"KCCJ\":85,\"KCMC\":\"电信业务程序设计实习\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":71,\"KCMC\":\"高等数学(2-2)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":50,\"KCMC\":\"高等数学(2-2)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":68,\"KCMC\":\"形势与政策\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":80,\"KCMC\":\"大学英语视听说(4-2)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":70,\"KCMC\":\"大学英语(基础)(2-2)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":87,\"KCMC\":\"程序设计(C++)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":77,\"KCMC\":\"道德与法律\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":64,\"KCMC\":\"军事理论\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":81,\"KCMC\":\"体育(4-2)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":63,\"KCMC\":\"线性代数\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":90,\"KCMC\":\"Matlab与通信仿真\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":91,\"KCMC\":\"通信概论\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":94,\"KCMC\":\"数学实验\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":48,\"KCMC\":\"大学物理(2-1)\"},{\"XQM\":\"2013-2014-2\",\"KCCJ\":60,\"KCMC\":\"大学物理(2-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":88,\"KCMC\":\"体育(4-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":93,\"KCMC\":\"军训\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":74,\"KCMC\":\"中国近现代史纲要\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":82,\"KCMC\":\"大学英语视听说(4-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":88,\"KCMC\":\"体育(4-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":63,\"KCMC\":\"高等数学(2-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":88,\"KCMC\":\"体育(4-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":88,\"KCMC\":\"体育(4-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":70,\"KCMC\":\"大学英语(基础)(2-1)\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":86,\"KCMC\":\"新生研讨课\"},{\"XQM\":\"2013-2014-1\",\"KCCJ\":98,\"KCMC\":\"程序设计(C)\"}]}";

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

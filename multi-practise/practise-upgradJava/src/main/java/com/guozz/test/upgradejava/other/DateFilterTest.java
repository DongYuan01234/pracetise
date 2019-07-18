package com.guozz.test.upgradejava.other;

import java.text.ParseException;

/**
 * @author guozhizhong
 * @Title: DateFilterTest
 * @ProjectName practise-upgradJava
 * @Description: TODO
 * @date 2019/6/42:42 PM
 **/
public class DateFilterTest {

    public static void main(String[] args) throws ParseException {
        TimeBucket[] buckets = {
                new TimeBucket("2018-05-02", "2018-06-10"),
                //new TimeBucket("2018-06-02", "2018-10-29"),
                new TimeBucket("2018-07-03", "2018-07-31")
        };
        TimeBucket union = TimeBucket.union(buckets);
        if (null != union) {
            System.out.println("存在重叠区域,重叠时间段:" + union.toString());
        }else{
            System.out.println("不存在重叠时间段");
        }
    }
}

package org.practise.upgrade.bloomFilter;



import java.util.HashSet;
import java.util.Set;

/**
 * @author guozhizhong
 * @Title: HashMapTest
 * @ProjectName practise-upgrade
 * @Description: TODO
 * @date 2018/12/710:10 AM
 **/
public class HashMapTest {

    public static void main(String[] args) {
        long star = System.currentTimeMillis();

        Set<Integer> hashset = new HashSet<>(100000000) ;
        for (int i = 0; i < 100000000; i++) {
            System.out.println(i);
            hashset.add(i) ;
        }
        System.out.println(hashset.contains(1));
        System.out.println(hashset.contains(2));
        System.out.println(hashset.contains(3));

        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}

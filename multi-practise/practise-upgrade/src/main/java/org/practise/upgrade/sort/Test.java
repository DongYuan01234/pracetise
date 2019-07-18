package org.practise.upgrade.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();


        Student songchao = new Student();
        songchao.setGender("man");
        songchao.setId(100001);
        songchao.setAge(40);
        songchao.setName("songchao");
        students.add(songchao);

        Student wuxing = new Student();
        wuxing.setGender("man");
        wuxing.setId(100002);
        wuxing.setAge(30);
        wuxing.setName("wuxing");
        students.add(wuxing);

        Student zhagnsan = new Student();
        zhagnsan.setGender("women");
        zhagnsan.setId(100003);
        zhagnsan.setAge(20);
        zhagnsan.setName("zhagnsan");
        students.add(zhagnsan);

        Student lisi = new Student();
        lisi.setGender("women");
        lisi.setId(100004);
        lisi.setAge(10);
        lisi.setName("lisi");
        students.add(lisi);


        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if(student1.getGender().equals(student2.getGender())){
                    return Integer.valueOf(student2.getAge()).compareTo(Integer.valueOf(student1.getAge()));
                }else{
                    return student1.getGender().compareTo(student2.getGender());
                }
            }
        });

        for(Student student : students){
            System.out.println(student.toString());
        }

    }
}

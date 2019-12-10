package com.yf.java.study.classcopy.class_assignment_copy;

import com.yf.java.study.classcopy.class_assignment_copy.People;

/**
 * @Author: YangFei
 * @Description:
 * @create: 2019-12-10 22:15
 */
public class PeopleMain {

    public static void main(String[] args) {
        People people1 = new People("yang", 28);
        People people3 = new People("飞", 0);
        People people2;
        People people = people1;
        people.setName("xin");
        people1.setAge(30);
        people2 = people1;
        people1.setName("匿名");
        people3 = people2;
    }
}

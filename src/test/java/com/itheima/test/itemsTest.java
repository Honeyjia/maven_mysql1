package com.itheima.test;

import com.itheima.dao.impl.itemsImpl;
import com.itheima.dao.itemsDao;
import com.itheima.domain.items;
import org.junit.Test;

import java.util.List;

public class itemsTest {
    @Test
    public void findAll() throws Exception {
        itemsDao dao = new itemsImpl();
        List<items> list = dao.findAll();
        System.out.println(list+" ---");
//        遍历 list
        for (items is : list){
            Integer id = is.getId();
            String name = is.getName();
            System.out.println(id+":"+name);
        }
    }
}

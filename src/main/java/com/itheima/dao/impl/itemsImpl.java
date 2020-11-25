package com.itheima.dao.impl;

import com.itheima.dao.itemsDao;
import com.itheima.domain.items;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class itemsImpl implements itemsDao {
    public List<items> findAll() throws Exception{
        List<items> list=new ArrayList<items>();
        Connection con = null;
        CallableStatement pst = null;
        ResultSet rs =null;
        try{
            //        1.加载驱动力类
            Class.forName("com.mysql.jdbc.Driver");
//        2.获取connection对象
            con = DriverManager.getConnection("jdbc:mysql:///maven", "root", "031362");
//        3.获取真正操作的数据库对象
             pst = con.prepareCall("SELECT * FROM items");//sql语句 查询所有
//        4.执行数据库查询操作
            rs = pst.executeQuery();
//        5.把数据库结果集转成java的list集合
            while(rs.next()){
                items is = new items();
                is.setId(rs.getInt("id"));
                is.setName(rs.getString("name"));
                list.add(is);//把对象添加到集合中
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rs.close();
            pst.close();
            con.close();
        }

        return list;
    }
}

package com.terabits.utils;

/**
 * Created by Administrator on 2017/4/25.
 */
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTools {
    public static SqlSessionFactory sessionFactory;

    static{
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-conf.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //创建能执行映射文件中sql的sqlSession
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}
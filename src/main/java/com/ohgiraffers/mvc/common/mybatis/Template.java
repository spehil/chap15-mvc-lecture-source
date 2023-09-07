package com.ohgiraffers.mvc.common.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;//어플리케이션당 하나만 생성될수있도록 static으로 작성

    public  static SqlSession getSqlSession() {

        if (sqlSessionFactory == null) {//sqlSession이 null일때만 생성할수 있도록 if문 작성


            //필요한 라이브러리 추가(ojdbc8 , mybatis)해줘야 SqlSession이 import가 가능하다.

            String resource = "mybatis/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);//try-catch
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            SqlSession sqlSession = sqlSessionFactory.openSession(false);
            return sqlSession;
        }


    }



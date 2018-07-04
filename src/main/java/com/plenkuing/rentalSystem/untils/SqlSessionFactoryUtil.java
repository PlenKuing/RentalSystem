package com.plenkuing.rentalSystem.untils;

import java.io.IOException;
import java.io.Reader;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//用于获取session的工具类

public class SqlSessionFactoryUtil {
	
	
	//mybatis的主配置文件路径  
    private static String path="mybatis-config.xml";  
    private static Reader read;  
    private static SqlSessionFactory  factory=null;  
      
    static {  
        try {  
        
             read= Resources.getResourceAsReader(path);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
      
    //获取工厂
    private static SqlSessionFactory getFactory(){  
        if(factory==null){  
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  
            factory= builder.build(read);  
            
            
        }  
        
        return factory;  
    }  
      
//  通过SqlSessionFactory工厂对象取得SqlSession对象  
    public static SqlSession  getSession(){  
        SqlSession s=getFactory().openSession(true);  
        return s;  
    }  
}

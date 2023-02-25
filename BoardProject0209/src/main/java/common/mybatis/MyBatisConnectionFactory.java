package common.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		// 공장을 만들때 필요한 XML 설정파일
		String resource = "./SqlMapConfig.xml"; 
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			
			if( sqlSessionFactory == null ) {
				// XML설정을 이용해서 공장객체를 만들어요!
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}

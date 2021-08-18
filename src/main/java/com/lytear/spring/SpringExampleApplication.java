package com.lytear.spring;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}): 최초  DB 설정 안 해서 임시로 한 거라 날려 줌
//@MapperScan(basePackages = "com.lytear.spring.*")// DAO의 위치를 잡아 줌
// 기본 패키지 안 모든 것을 스캔해서 가져다 써 => DAO와 xml 연동됨

public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
		
		
	}
	/*데이터베이스 연동하면서 아래 메소드 추가. 사용법이라 그 다음부터는 복붙 사용하면 됨
	 * */
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);//파라미터로 받은 결과(dataSource) 그대로 씀
//		// 
//		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
//		// classpath: 다음은 xml 을 저장했던 경로를 적어 줌. mappers 아래 있는 Mapper.xml로 끝나는 파일 내가 가져다가 쓰겠다
//		// 제일 밑의 org.springframwork.core.io.Resource를 import
//		// sessionFactory에 위 내용을 set 해 주기
//		/*
//		 * SqlSessionFactoryBean 이라는 걸 만들어서 리턴해줘야 하는데,
//		 * 거기에 들어가야 할 첫번째가 DataSource라는 건데 이건 application.properties에서 세팅해 놓은 것으로 그 값들이
//		 * 전달이 되어 세팅됨
//		 * Resource를 get 하는 것은 프로그램의 main/resources 밑에 Mapper.xml 내용 긁어다가
//		 * 배열에 저장
//		 * 배열 내용을 sessionFactory에 집어 넣어서 아래 줄을 위해 필요한 정보들을 set 시킴
//		 * sessionFactory가 DB와 연결을 해서 우리가 원하는 쿼리 수행
//		 * 
//		 * 
//		 * */
//		sessionFactory.setMapperLocations(res);
//		
//		return sessionFactory.getObject();
//	}
	
}

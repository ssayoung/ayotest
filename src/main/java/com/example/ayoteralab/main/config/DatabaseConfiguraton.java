package com.example.ayoteralab.main.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.ayoteralab.main"
            , sqlSessionFactoryRef = "mainSqlSessionFactory"
            , sqlSessionTemplateRef = "mainSqlSessionTemplate")
public class DatabaseConfiguraton {
	
	@Primary
	@Bean(name = "main")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.main")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean(name = "mainSqlSessionFactory")
	public SqlSessionFactory mainSqlSessionFactory(@Qualifier("main") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.example.ayoteralab.main.dto");
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:main_mapper/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "mainSqlSessionTemplate")
	public SqlSessionTemplate mainSqlSessionTemplate(SqlSessionFactory mainSqlSessionFactory) {
		return new SqlSessionTemplate(mainSqlSessionFactory);
	}

}

package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import member.MemberDao;
import member.MemberLookupService;
import memberChangeInfo.ChangeInfoService;
import memberChangeInfo.ChangePasswordService;
import memberLogin.AuthService;
import memberRegister.MemberRegisterService;
import notice.NoticeDao;
import notice.NoticeLookupService;
import notice.NoticeRegisterService;
import notice.NoticeUpdateService;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	// DB연결 설정
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		ds.setUsername("C##taewoo");
		ds.setPassword("0000");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public NoticeDao noticeDao() {
		return new NoticeDao(dataSource());
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService(memberDao());
	}
	
	@Bean
	public AuthService authService() {
		return new AuthService(memberDao());
	}
	
	@Bean
	public ChangeInfoService changeInfoService() {
		return new ChangeInfoService(memberDao());
	}
	
	@Bean
	public MemberLookupService memberLookupService() {
		return new MemberLookupService(memberDao());
	}
	
	@Bean
	public NoticeLookupService noticeLookupService() {
		return new NoticeLookupService(noticeDao());
	}
	
	@Bean
	public NoticeRegisterService noticeRegisterService() {
		return new NoticeRegisterService(noticeDao());
	}
	
	@Bean
	public NoticeUpdateService noticeUpdateService() {
		return new NoticeUpdateService(noticeDao());
	}
}

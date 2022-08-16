package com.spring.study.config;

import com.spring.study.repository.BoardRepository;
import com.spring.study.repository.JdbcTemplateBoardRepository;
import com.spring.study.repository.JdbcTemplateMemberRepository;
import com.spring.study.repository.MemberRepository;
import com.spring.study.service.BoardService;
import com.spring.study.service.BoardServiceImpl;
import com.spring.study.service.MemberRegisterService;
import com.spring.study.service.MemberRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"com.spring.study"})
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}

package com.company.main;

import com.company.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.company.dao.UserRepositoryCustom;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

    @Autowired
    @Qualifier("userDao")
    private UserRepositoryCustom userDao;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<User> list = userDao.getAll();
                System.out.println(list);
            }
        };
        return clr;

    }
}

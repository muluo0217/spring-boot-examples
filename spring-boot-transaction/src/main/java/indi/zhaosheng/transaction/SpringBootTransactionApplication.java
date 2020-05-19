package indi.zhaosheng.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "indi.zhaosheng.transaction.dao")
public class SpringBootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTransactionApplication.class, args);
    }

}

package com.github.agem20.creditanalysissystemtqi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.CreditAnalysisSystemTqiApplication"})
@EntityScan(basePackages={"com.card.entity"})
@EnableJpaRepositories(basePackages={"com.card.repository"})
public class CardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardApplication.class, args);
    }

}

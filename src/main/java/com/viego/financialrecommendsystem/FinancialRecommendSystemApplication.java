package com.viego.financialrecommendsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FinancialRecommendSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialRecommendSystemApplication.class, args);
        System.out.println(" ____ _________  \n" +
                "/ ___|__  /  _ \\ \n" +
                "\\___ \\ / /| |_) |\n" +
                " ___) / /_|  _ < \n" +
                "|____/____|_| \\_\\\n" +
                "                 ");
    }

}

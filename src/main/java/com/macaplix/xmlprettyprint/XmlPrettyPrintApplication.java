package com.macaplix.xmlprettyprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlPrettyPrintApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmlPrettyPrintApplication.class, args);
        PrettyPrintController printController = new PrettyPrintController();
        System.out.println(printController.run());
    }

}

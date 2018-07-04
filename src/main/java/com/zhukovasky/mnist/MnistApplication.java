package com.zhukovasky.mnist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MnistApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(MnistApplication.class);
    public static void main( String[] args )
    {
    	LOGGER.info("============================启动开始==============================");
        SpringApplication.run(MnistApplication.class, args);
        LOGGER.info("============================启动完成===============================");
    }
}

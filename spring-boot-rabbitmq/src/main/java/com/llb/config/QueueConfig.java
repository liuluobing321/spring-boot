package com.llb.config;



import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/10/7 18:51
 */
@Configuration
public class QueueConfig {
	@Bean
	public Queue createQueue(){
		return new Queue("hello-queue");

	}
}

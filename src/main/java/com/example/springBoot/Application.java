package com.example.springBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.springBoot.mapper")
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("The service to start.---------------");
		SpringApplication.run(Application.class, args);
		System.out.println("The service has started.-----------------");
	}

	/**为了打包springboot项目*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	/**
	 * SpringBoot 2.0.0 新版
	 * tomcatEmbedded 这段代码是为了解决，上传文件大于10M出现连接重置的问题。此异常内容 GlobalException 也捕获不到。
	 * @return
	 */
//	@Bean
//	public TomcatServletWebServerFactory tomcatEmbedded() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//				//-1 means unlimited
//				((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//			}
//		});
//		return tomcat;
//	}
}

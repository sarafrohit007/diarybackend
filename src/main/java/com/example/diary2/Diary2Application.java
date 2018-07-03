package com.example.diary2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/*import com.example.diary2.service.WebHookService;*/

//import com.example.demo.com.example.demo.service.WebHookService;


@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class Diary2Application {
	
	/*static {
		ApiContextInitializer.init();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(Diary2Application.class, args);
		/*WebHookService webHookService = new WebHookService();
		webHookService.setWebHookForApp();*/
	}


	/*private static boolean isTelegramBotRunning() {
		// TODO Auto-generated method stub
		return false;
	}*/
}

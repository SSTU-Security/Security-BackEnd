package ru.bebriki.sstusecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SstuSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SstuSecurityApplication.class, args);
	}

}

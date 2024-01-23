package com.dre.Server;

import com.dre.Server.bot.Startup;
import com.dre.Server.sql.PostgresJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		PostgresJDBC.startConnection();
		Startup.getInstance().test();
	}

}

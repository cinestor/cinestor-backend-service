package fr.gaelcarre.cinestor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fr.gaelcarre.cinestor.rest.controller.InitController;

@SpringBootApplication
@ComponentScan("fr.gaelcarre.cinestor.*")
public class Application {

	@Autowired
	private static InitController initController;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

package fr.gaelcarre.cinestor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import fr.gaelcarre.cinestor.rest.controller.InitController;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private InitController initcontroller;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		this.initcontroller.init();

	}

}

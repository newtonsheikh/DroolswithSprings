package com.example.demo;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceREController {
	
	@Autowired
	private KieSession session;
	
	@GetMapping("/welcome")
	public String welcom() {
		return "Welcome to Drools Rule Engine";
	}
	
	@PostMapping("/temperature")
	public Device deviceAlert(@RequestBody Device dev) {
		session.insert(dev);
		session.fireAllRules();
		return dev;
	}

}

package com.test.application.deployment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeploymentController {

	@GetMapping("/getData")
	
	public String getData() {
		// TODO Auto-generated method stub
return "Welcome!! Deployment phase completed..";
	}
}

package com.nothing.controllers;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nothing.IllegalDeploymentException;
import com.nothing.responses.RootResponse;


@RestController
@RequestMapping("/api")
public class DemoController {
	
	//jonas -- intern -- big corporations
	//task -- end users,clients,customers,target group.
	//ba, pm, manager ... stakeholders.
	// WAITING... 2 weeks. 1 weeks..
	// increment, smaller releases.
	// BOMB!!!
	// effort.
	// operational overheads.
	// efficiency.
	// productivity.
	// ripple effect --> void.
	// great... ask more requirement or refinements.
	// 2 weeks.
	// CI / CD -- seamleass...
	// Release... deployed Automatically.
	@GetMapping("/jonas/ping") // payment service : bank to wallet transfers
	public ResponseEntity<RootResponse<List<String>>> doPing() {
		
		
	    //stacy will have to improve the response.
		
		// bobby... get a key..
		// fetch some records.
		
		RootResponse<List<String>> rootResponse = new RootResponse<>();
		rootResponse.setCode(200);
		rootResponse.setMessage("Deployed with Jenkins :) | ping routing payment confirmation from jonas api was" + "successful".toUpperCase());
		rootResponse.setResponse(Arrays.asList(UUID.randomUUID().toString(),
				UUID.randomUUID().toString(),
				UUID.randomUUID().toString(), UUID.randomUUID().toString()));
		rootResponse.setStatus("success");
		rootResponse.setTimeStamp(LocalDateTime.now());
		
		
		
		return new ResponseEntity<>(rootResponse,HttpStatus.OK);
	//	return "~jonas~ | ping response @@@@ .".concat(LocalDateTime.now().toString()).concat("]");
		
		
	}

	// digital transformation 
	//efficieny and productivty
	
	// define our simple endpoint
	@GetMapping("/greetings")
	public ResponseEntity<RootResponse<String>> sayHello() {
				
		
		String message;
		RootResponse<String> rootResponse;
		// we will say a different message if the deployment was successfully on that vm.
		if(System.getProperty("os.name").contains("Linux"))
		{
			 message ="application was successfully deployed on the vm.";
			 rootResponse =	 new RootResponse<>(200,message,"success","Hello, Welcome Here!",LocalDateTime.now());
		}
		
		else {
			
			message = "deployment was not done on the expected vm.";
			throw new IllegalDeploymentException(message);
		}
		
		
		return new ResponseEntity<RootResponse<String>>(rootResponse ,HttpStatus.OK);
	}
	
	@PostMapping("/processing/payment")
	public ResponseEntity<RootResponse<String>> sayHelloOne() {
				
		
		String message;
		RootResponse<String> rootResponse;
		// we will say a different message if the deployment was successfully on that vm.
		if(System.getProperty("os.name").contains("Linux"))
		{
			 message ="application was successfully deployed on the vm.";
			 rootResponse =	 new RootResponse<>(200,message,"success","Hello, Welcome Here!",LocalDateTime.now());
		}
		
		else {
			
			message = "deployment was not done on the expected vm.";
			throw new IllegalDeploymentException(message);
		}
		
		
		return new ResponseEntity<RootResponse<String>>(rootResponse ,HttpStatus.OK);
	}
	
	
	
	

}

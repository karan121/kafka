package com.example.workflow;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class WeatherCheck implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		boolean isResponseAvailable = true;
		
		System.out.println(execution.getVariables());
		
		System.out.println("weather is ok");
		
		System.out.println("going to call an API");
		
		try {
		RestTemplate restTemplate = new RestTemplate();
		String url
		  = "http://localhost:9091/getUser";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url , String.class);
		
		
		System.out.println("response is => "+response);
		}catch(Exception e) {
			e.printStackTrace();
			execution.setVariable("response", false);
			isResponseAvailable = false;
		}
		if(isResponseAvailable)
		execution.setVariable("response", true);
		
		
	}
}

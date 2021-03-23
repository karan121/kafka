package com.example.workflow;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class WeatherOk implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println(execution.getVariables());
		
		System.out.println("weather is ok");
		
		System.out.println("going to call an API");
		
		/*RestTemplate restTemplate = new RestTemplate();
		String url
		  = "http://localhost:9091/getUser";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url , String.class);
		*/
		
		//System.out.println("response is => "+response);
		
		execution.setVariable("response", true);
		
		System.out.println("check");
		
	}
}

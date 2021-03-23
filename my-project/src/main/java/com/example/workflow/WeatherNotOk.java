package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class WeatherNotOk implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println(execution.getVariables());
		
		System.out.println("weather is not ok");
		execution.setVariable("response", false);
		
	}

}

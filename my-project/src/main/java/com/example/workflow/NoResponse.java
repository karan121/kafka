package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NoResponse implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		System.out.println("no response............");
		System.out.println(execution.getVariable("user"));
		
	}

}

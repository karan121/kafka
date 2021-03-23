package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import camundajar.impl.scala.util.Random;

public class CheckWhetherDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		Random random = new Random();
		
		execution.setVariable("name", "karan");
		execution.setVariable("weatherOk", random.nextBoolean());
		execution.setVariable("response", true);
		
	}

}

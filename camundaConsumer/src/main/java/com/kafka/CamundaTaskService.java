package com.kafka;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.stereotype.Service;

@Service
public class CamundaTaskService {

	 public void callCamunida(String value) {
		 ExternalTaskClient client = ExternalTaskClient.create()
			      .baseUrl("http://localhost:9093/engine-rest")
			      .asyncResponseTimeout(10000) // long polling timeout
			      .build();

			  client.subscribe("weatherDecision")
			      .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
			      .handler((externalTask, externalTaskService) -> {
			    	  System.out.println("hiii");
			    	  Map<String,Object> map = new HashMap<>();
			    	  
			    	  map.put("name", "karan");
			    	  map.put("weatherOk", true);
			    	  map.put("response", false);
			    	  map.put("user", value);
			  		
			    	 /* map.put("north", true);
			    	  map.put("gaul", true);*/
			        externalTaskService.complete(externalTask,map);
			      })
			      .open();
	 }
}

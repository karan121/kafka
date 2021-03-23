package com.kafka;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import com.kafka.model.provisioningOrderMessage;

@SpringBootApplication
@EnableKafka
public class CamundaConsumerApplication {
	
	@Autowired
	private CamundaTaskService camundaTaskService;

	public static void main(String[] args) {
		SpringApplication.run(CamundaConsumerApplication.class, args);
	}
	
	
	
	  @KafkaListener(topics = "camunda", groupId = "camu") 
	  public void listenGroupFoo(String message) {
	  System.out.println("Received Message in group camu: " + message);
	 // camundaTaskService.callCamunida(message); 
	  
		
		  JAXBContext jaxbContext; try { jaxbContext =
		  JAXBContext.newInstance(provisioningOrderMessage.class);
		  
		  Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		  
		  provisioningOrderMessage provision = (provisioningOrderMessage)
		  jaxbUnmarshaller.unmarshal(new StringReader(message));
		  
		  System.out.println(provision);
		  } 
		  catch (JAXBException e) {
		  e.printStackTrace(); 
		  }
		  
	  
	  }
	 
	
	
	/*
	 * @KafkaListener(topics = "camunda", groupId = "camu", containerFactory =
	 * "userKafkaListnerContainerFactory") public void listenJson(CamundaPOC
	 * message) { System.out.println("Received Message in group camu: " + message);
	 * //camundaTaskService.callCamunida(message);
	 * System.out.println("camunda called"); }
	 */
	 

}

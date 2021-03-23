package com.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

@Configuration
public class KafkaConfig {

	
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		map.put(ConsumerConfig.GROUP_ID_CONFIG,"camu");
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(map);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListnerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, CamundaPOC> userConsumerFactory(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
		map.put(ConsumerConfig.GROUP_ID_CONFIG,"camu");
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, CamundaPOC>(map,new org.apache.kafka.common.serialization.StringDeserializer(),
				new JsonDeserializer<>(CamundaPOC.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CamundaPOC> userKafkaListnerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, CamundaPOC> factory = new ConcurrentKafkaListenerContainerFactory<String, CamundaPOC>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}
}

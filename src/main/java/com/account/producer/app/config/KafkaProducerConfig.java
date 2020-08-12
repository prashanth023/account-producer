package com.account.producer.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {
 
    @Bean
   public  ProducerFactory<String, String> producerFactory() {
    	
        Map<String, Object> config = new HashMap<String,Object>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.31.63.190:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        
        return new DefaultKafkaProducerFactory<String, String>(config);
        
    }
 
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
    	
        return new KafkaTemplate<String, String>(producerFactory());
    }
}

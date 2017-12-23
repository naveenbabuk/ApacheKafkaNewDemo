package com.javagain.kafkademo.producerexample;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SupplierConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String topicName = "SupplierTopic";
		String groupName = "SuplierGroup1";
		
		Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("group.id", groupName);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "com.javagain.kafkademo.producerexample.SupplierDeSerializer");
		
        
        KafkaConsumer<String, Supplier> consumer = new KafkaConsumer<String, Supplier>(props);
        consumer.subscribe(Arrays.asList(topicName));
        
        while (true) {
            ConsumerRecords<String, Supplier> records = consumer.poll(100);
            for (ConsumerRecord<String, Supplier> record : records){
            			System.out.println("************* Consumer *******************");
                    System.out.println("Supplier id= " + String.valueOf(record.value().getId()));
                    System.out.println(" Supplier  Name = " + record.value().getSupplierName());
                    System.out.println(" Supplier Start Date = " + record.value().getStartDate().toString());
                    System.out.println();
                    System.out.println();
            }
        }

	}

}

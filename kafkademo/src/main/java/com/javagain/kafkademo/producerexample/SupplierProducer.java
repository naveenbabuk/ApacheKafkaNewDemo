package com.javagain.kafkademo.producerexample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.kafka.clients.producer.*;

public class SupplierProducer {
	
	public static void main(String[] args) throws Exception {
		
		String topicName = "SupplierTopic";
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "com.javagain.kafkademo.producerexample.SupplierSerializer");
		
		Producer<String, Supplier> producer = new KafkaProducer<String, Supplier>(props);
		
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Supplier sup1 = new Supplier(121, "Deccan pvt ltd", df.parse("2012-05-12") );
		Supplier sup2 = new Supplier(122, "Deccan pvt ltd", df.parse("2012-07-07") );
		
		
		producer.send(new ProducerRecord<String, Supplier>(topicName, sup1)).get();
		producer.send(new ProducerRecord<String, Supplier>(topicName, sup2)).get();
		
		System.out.println("Completed.");
		producer.close();
		
		
	}

}

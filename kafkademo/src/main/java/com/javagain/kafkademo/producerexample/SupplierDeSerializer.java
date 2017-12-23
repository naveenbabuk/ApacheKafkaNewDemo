package com.javagain.kafkademo.producerexample;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class SupplierDeSerializer implements Deserializer<Supplier> {
	
	private String encoding = "UTF-8";

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	public Supplier deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		
		try {
            if (data == null){
                System.out.println("Null recieved at deserialize");
                                return null;
                                }
            ByteBuffer buf = ByteBuffer.wrap(data);
            int id = buf.getInt();

            int sizeOfName = buf.getInt();
            byte[] nameBytes = new byte[sizeOfName];
            buf.get(nameBytes);
            String deserializedName = new String(nameBytes, encoding);

            int sizeOfDate = buf.getInt();
            byte[] dateBytes = new byte[sizeOfDate];
            buf.get(dateBytes);
            String dateString = new String(dateBytes,encoding);

            DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");

            return new Supplier(id,deserializedName,df.parse(dateString));



        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Supplier");
        }
	}

}

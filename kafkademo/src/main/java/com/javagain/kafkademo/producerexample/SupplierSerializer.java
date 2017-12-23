package com.javagain.kafkademo.producerexample;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class SupplierSerializer implements Serializer<Supplier> {
	
	private String encoding = "UTF8";

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	public byte[] serialize(String arg0, Supplier data) {
		int sizeOfName;
        int sizeOfDate;
        byte[] serializedName;
        byte[] serializedDate;

try {
    if (data == null)
        return null;
                    serializedName = data.getSupplierName().getBytes(encoding);
                        sizeOfName = serializedName.length;
                        serializedDate = data.getStartDate().toString().getBytes(encoding);
                        sizeOfDate = serializedDate.length;

                        ByteBuffer buf = ByteBuffer.allocate(4+4+sizeOfName+4+sizeOfDate);
                        buf.putInt(data.getId());
                        buf.putInt(sizeOfName);
                        buf.put(serializedName);
                        buf.putInt(sizeOfDate);
                        buf.put(serializedDate);


        return buf.array();

} catch (Exception e) {
    throw new SerializationException("Error when serializing Supplier to byte[]");
}
	}

	

}

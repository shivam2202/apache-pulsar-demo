package com.softtech.demo;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;

public class SimpleProducer {
	
	protected void run(int messageCount) throws Exception
	{
		PulsarClient client = new PulsarInstance("pulsar://localhost:6650").getPularClient();
		try (Producer<String> producer = client.newProducer(Schema.STRING)
                .topic("test")
                .create()) {

            final int numMessages = Math.max(messageCount, 1);
            System.out.println(numMessages);

            // immediate delivery
            for (int i = 0; i < numMessages; i++) {
                producer.newMessage()
                        .value("Immediate delivery message " + i)
                        .send();
            }
            producer.closeAsync();
           client.closeAsync();
            
	}}

	public static void main(String[] args) {
		 SimpleProducer example = new SimpleProducer();
		 try {
			example.run(Integer.valueOf(args[0]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

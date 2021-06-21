package com.softtech.demo;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.ConsumerBuilder;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;

public class SimpleConsumer {

	protected void run() throws Exception {
		PulsarClient client = new PulsarInstance("pulsar://localhost:6650").getPularClient();

		ConsumerBuilder<String> consumerBuilder = client.newConsumer(Schema.STRING).topic("test")
				.subscriptionName("demo-subscription")
				.subscriptionInitialPosition(SubscriptionInitialPosition.Earliest);
		int counter = 0;
		Consumer<String> consumer = consumerBuilder.subscribe();
		while (true) {

			Message<String> msg = consumer.receive();
			System.out.println(new String(msg.getData()));
			consumer.acknowledge(msg);
			System.out.println(counter++);
		}
	}

	public static void main(String[] args) {
		SimpleConsumer example = new SimpleConsumer();
		try {
			System.out.println("Listening for messages ....");
			example.run();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

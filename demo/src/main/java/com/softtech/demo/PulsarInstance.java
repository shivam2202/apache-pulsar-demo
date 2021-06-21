package com.softtech.demo;

import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;


public class PulsarInstance {
	

	private PulsarClient client;
	public PulsarInstance(String pulsarEndpoint) {
		if (this.client == null) {
			try {
				this.client = PulsarClient.builder().serviceUrl(pulsarEndpoint).build();
				
			} catch (PulsarClientException e) {
				
			}
		} 
	}

	
	public  PulsarClient getPularClient() {
		
		return this.client;
	}

}

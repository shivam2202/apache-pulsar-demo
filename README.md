# Simple Consumer/Producer Example

This example demonstrates how to send and recieve message topic with default values. For java client details refer to [documentation](https://pulsar.apache.org/docs/en/client-libraries-java/)

## Prerequisites

- Java 1.8 or higher to run the demo application
- Maven to compile the demo application
- Pulsar 2.7.0 or higher

## Steps

1. Start Pulsar standalone on docker. You can follow the [detailed instructions](https://pulsar.apache.org/docs/en/standalone-docker/#produce-a-message)
in Pulsar documentation to start a Pulsar standalone locally.
   ```bash
   docker run --detach -p 6650:6650 -p 8080:8080 apachepulsar/pulsar:2.7.0 bin/pulsar standalone
   ```

2. Clone the repo and build the demo project.
   ```bash
   git clone https://github.com/shivam2202/apache-pulsar-demo.git
   ```
   ```bash
   mvn clean install -DskipTests 
   ```

3. Run [SimpleProducer](demo/src/main/java/com/softtech/demo/SimpleProducer.java) for producing messages. This class takes no of messages to produce as argument
 

4. Run [SimpleConsumer](demo/src/main/java/com/softtech/demo/SimpleConsumer.java) for listening messages.

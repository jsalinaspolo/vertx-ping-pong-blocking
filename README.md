# Vertx3 ping-pong blocking cluster example

## Environment configuration

To run in cluster, please check firewall is disabled and multicast enabled

## Build

```mvn clean install```

## Upload jars to different machines

1. Copy pong/target/pong-1.0-SNAPSHOT-fat.jar in one machine
2. Copy ping/target/ping-1.0-SNAPSHOT-fat.jar in a different machine
3. Copy ping-blocking/target/ping-blocking-1.0-SNAPSHOT-fat.jar in a different machine

## Run the jars

1. Pong:

```java -jar pong-1.0-SNAPSHOT-fat.jar -cluster -cluster-host 127.0.0.1```

2. Ping:

```java -jar ping-1.0-SNAPSHOT-fat.jar -cluster -cluster-host 127.0.0.1```

3. Ping blocking:

```java -jar ping-blocking-1.0-SNAPSHOT-fat.jar -cluster -cluster-host 127.0.0.1```

## Problem

When runs ```pong``` and ```ping-blocking```, the consumer of the event bus (pong) does not receive the
messages till the work is finished.
package com.example;

import com.example.GreetingServiceGrpc;
import com.example.HelloRequest;
import com.example.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
	public static void main(String[] args) {
		final String target = args.length > 0 ? args[0] : "localhost:8080";
		final String name = args.length > 1 ? args[1] : "Ray";

		ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
				.usePlaintext()
				.build();

		GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc
				.newBlockingStub(channel);

		HelloResponse response = stub.greet(HelloRequest.newBuilder()
				.setName(name)
				.build());

		System.out.println(response);

		channel.shutdownNow();
	}
}

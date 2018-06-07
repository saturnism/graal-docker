package com.example;

import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.net.InetSocketAddress;

public class App {
	public static void main(String[] args) throws Exception {
		Server server = NettyServerBuilder.forAddress(new InetSocketAddress(8080))
				.addService(new GreetingServiceImpl())
				.build();

		server.start();
		System.out.println("Server started");
		server.awaitTermination();
	}

	public static class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
		@Override public void greet(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
			System.out.println(request);
			responseObserver.onNext(HelloResponse.newBuilder()
					.setGreeting("Hello, " + request.getName())
					.build());
			responseObserver.onCompleted();
		}
	}
}

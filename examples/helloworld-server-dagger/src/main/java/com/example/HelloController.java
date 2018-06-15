package com.example;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import static spark.Spark.get;

@Singleton
public class HelloController {
	private final Gson gson;

	@Inject
	public HelloController(Gson gson) {
		this.gson = gson;
	}

	public void routes()  {
		get("/hello/:name", (req, res) -> {
			res.type("application/json");

			String name = req.params(":name");

			GreetingResponse response = new GreetingResponse();
			response.setGreeting("Hello, " + name);

			return response;
		}, gson::toJson);
	}

}

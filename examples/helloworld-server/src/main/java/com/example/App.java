package com.example;

import com.google.gson.Gson;

import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		Gson gson = new Gson();

		get("/hello/:name", (req, res) -> {
			res.type("application/json");

			String name = req.params(":name");

			GreetingResponse response = new GreetingResponse();
			response.setGreeting("Hello, " + name);

			return response;
		}, gson::toJson);
	}
}

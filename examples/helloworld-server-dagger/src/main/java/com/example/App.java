package com.example;

import com.example.DaggerControllersComponent;

public class App {
	public static void main(String[] args) {
		DaggerControllersComponent.create().helloController().routes();
	}
}

package com.example;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ControllersComponent {
	HelloController helloController();
}

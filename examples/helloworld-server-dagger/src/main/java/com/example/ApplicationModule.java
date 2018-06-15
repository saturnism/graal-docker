package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {
	@Provides
	public Gson gson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}
}

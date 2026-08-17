package com.skyscanner.microservice;

import com.skyscanner.microservice.resources.SearchResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class HoenApplication extends Application<HoenConfiguration> {

    public static void main(String[] args) throws Exception {
        new HoenApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-archipelago";
    }

    @Override
    public void initialize(Bootstrap<HoenConfiguration> bootstrap) {}

    @Override
    public void run(HoenConfiguration configuration, Environment environment) {
        environment.jersey().register(new SearchResource());
    }
}

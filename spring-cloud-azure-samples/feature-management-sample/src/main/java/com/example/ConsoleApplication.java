/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microsoft.azure.spring.cloud.feature.manager.FeatureManager;

@SpringBootApplication
@EnableAutoConfiguration
public class ConsoleApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(ConsoleApplication.class);

    @Autowired
    private FeatureManager featureManager;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");

        if (featureManager.isEnabled("Beta")) {
            System.out.println("Running Beta");
        } else {
            System.out.println("Running Application");
        }
    }
    
    

}

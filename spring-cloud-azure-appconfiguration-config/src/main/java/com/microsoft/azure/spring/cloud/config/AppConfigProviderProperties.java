/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.spring.cloud.config;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
@PropertySource("classpath:appConfiguration.yaml")
@ConfigurationProperties(prefix = AppConfigProviderProperties.CONFIG_PREFIX)
public class AppConfigProviderProperties {
    public static final String CONFIG_PREFIX = "spring.cloud.appconfiguration";

    @NotEmpty
    @Value("${version:1.0}")
    private String version;

    @NotNull
    @Value("${maxRetries:12}")
    private int maxRetries;

    @NotNull
    @Value("${maxRetryTime:60}")
    private int maxRetryTime;

    // The minimum amount of time the application is kept on if there is a server side
    // error on startup.
    @NotNull
    @Value("${prekillTime:5}")
    private int prekillTime;

    private static final Date startDate = new Date();

    /**
     * @return the apiVersion
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param apiVersion the apiVersion to set
     */
    public void setVersion(String apiVersion) {
        this.version = apiVersion;
    }

    /**
     * @return the maxRetries
     */
    public int getMaxRetries() {
        return maxRetries;
    }

    /**
     * @param maxRetries the maxRetries to set
     */
    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    /**
     * @return the maxRetryTime
     */
    public int getMaxRetryTime() {
        return maxRetryTime;
    }

    /**
     * @param maxRetryTime the maxRetryTime to set
     */
    public void setMaxRetryTime(int maxRetryTime) {
        this.maxRetryTime = maxRetryTime;
    }

    /**
     * @return the prekillTime
     */
    public int getPrekillTime() {
        return prekillTime;
    }

    /**
     * @param prekillTime the prekillTime to set
     */
    public void setPrekillTime(int prekillTime) {
        this.prekillTime = prekillTime;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

}

package com.guacha.prueba;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("postgres")
public record PostgresConfigurationProps(String dbUrl, String dbUser, String dbPassword) {
}

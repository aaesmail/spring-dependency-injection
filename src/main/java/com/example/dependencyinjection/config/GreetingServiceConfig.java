package com.example.dependencyinjection.config;

import com.example.dependencyinjection.datasource.FakeDataSource;
import com.example.dependencyinjection.repositories.EnglishGreetingRepository;
import com.example.dependencyinjection.repositories.EnglishGreetingRepositoryImpl;
import com.example.dependencyinjection.services.ConstructorGreetingService;
import com.example.dependencyinjection.services.I18nEnglishGreetingService;
import com.example.dependencyinjection.services.I18nJapaneseGreetingService;
import com.example.dependencyinjection.services.PrimaryGreetingService;
import com.example.dependencyinjection.services.PropertyInjectedGreetingService;
import com.example.dependencyinjection.services.SetterInjectedGreetingService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@EnableConfigurationProperties(DiConstructorConfig.class)
@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}") String username, @Value("${com.password}") String password,
            @Value("${com.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();

        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Profile({ "EN", "default" })
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("JP")
    @Bean("i18nService")
    I18nJapaneseGreetingService i18nJapaneseGreetingService() {
        return new I18nJapaneseGreetingService();
    }
}

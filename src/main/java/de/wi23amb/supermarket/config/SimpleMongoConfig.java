package de.wi23amb.supermarket.config;

import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "de.wi23amb.supermarket.repositories", repositoryBaseClass = CustomMongoRepositoryImpl.class)
public class SimpleMongoConfig {
 
    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:MongoDBAdmin@mathisneunzig.gxcl7jz.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .uuidRepresentation(UuidRepresentation.STANDARD)
          .applyConnectionString(connectionString)
          .build();
        
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "test");
    }
    
}
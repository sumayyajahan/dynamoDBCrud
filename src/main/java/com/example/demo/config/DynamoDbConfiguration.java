package com.example.demo.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfiguration {

    @Bean
    private DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDB());
    }

    private AmazonDynamoDB amazonDynamoDB(){

        return AmazonDynamoDBAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("",""))
                .withCredentials(amazonDynamoDBCredentials()).build());
    }
}

package com.joseallan.microservices.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.swing.text.html.parser.Entity;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.joseallan.microservices.repository")
public class ElasticSourceConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient(){
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200","localhost:9300")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    //@Override
    public Entity entityMapper(){
        Entity entityMapper = new Entity(elasticsearchMappingContext(),
                new DefaultConversionService());
      //  entityMapper.setConversions(elasticsearchCustomConversions());
        return entityMapper;
    }
}

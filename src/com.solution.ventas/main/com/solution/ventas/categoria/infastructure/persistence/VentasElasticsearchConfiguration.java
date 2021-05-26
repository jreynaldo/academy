package com.solution.ventas.categoria.infastructure.persistence;

import com.solution.shared.infrastructure.config.Parameter;
import com.solution.shared.infrastructure.config.ParameterNotExist;
import com.solution.shared.infrastructure.elasticsearch.ElasticsearchClient;
import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;


import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

@Configuration
public class VentasElasticsearchConfiguration {
    private final Parameter config;
    private final ResourcePatternResolver resourceResolver;

    public VentasElasticsearchConfiguration(Parameter config, ResourcePatternResolver resourceResolver) {
        this.config           = config;
        this.resourceResolver = resourceResolver;
    }

    @Bean
    public ElasticsearchClient elasticsearchClient() throws ParameterNotExist, IOException {
        ElasticsearchClient client = new ElasticsearchClient(
            new RestHighLevelClient(
                RestClient.builder(
                    new HttpHost(
                        config.get("VENTAS_ELASTICSEARCH_HOST"),
                        config.getInt("VENTAS_ELASTICSEARCH_PORT"),
                        "http"
                    )
                )
            ),
            RestClient.builder(
                new HttpHost(
                    config.get("VENTAS_ELASTICSEARCH_HOST"),
                    config.getInt("VENTAS_ELASTICSEARCH_PORT"),
                    "http"
                )).build(),
            config.get("VENTAS_ELASTICSEARCH_INDEX_PREFIX")
        );

        generateIndexIfNotExists(client, "ventas");

        return client;
    }

    private void generateIndexIfNotExists(ElasticsearchClient client, String contextName) throws IOException {
        Resource[] jsonsIndexes = resourceResolver.getResources(
            String.format("classpath:database/%s/*.json", contextName)
        );

        for (Resource jsonIndex : jsonsIndexes) {
            String indexName = Objects.requireNonNull(jsonIndex.getFilename()).replace(".json", "");

            if (!indexExists(indexName, client)) {
                String indexBody = new Scanner(
                    jsonIndex.getInputStream(),
                    "UTF-8"
                ).useDelimiter("\\A").next();

                Request request = new Request("PUT", indexName);
                request.setJsonEntity(indexBody);

                client.lowLevelClient().performRequest(request);
            }
        }
    }

    private boolean indexExists(String indexName, ElasticsearchClient client) throws IOException {
        return client.highLevelClient().indices().exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
    }
}
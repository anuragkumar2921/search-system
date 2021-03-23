package com.unravel.searchsystem.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by anurag on 22/3/21.
 */
@Configuration
public class ElasticConfig {

    @Bean
    public Client client() throws UnknownHostException {
        Settings esSettings =Settings.builder().put("cluster.name","elasticsearch").build();
        PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(esSettings);
        preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        return preBuiltTransportClient;
    }
}
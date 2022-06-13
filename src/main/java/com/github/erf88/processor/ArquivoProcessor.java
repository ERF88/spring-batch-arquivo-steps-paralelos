package com.github.erf88.processor;

import com.github.erf88.model.Cartao;
import com.github.erf88.model.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoProcessor {

    @Bean
    public ItemProcessor<Cliente, Cliente> clienteProcessor() {
        return new ClienteProcessor();
    }

    @Bean
    public ItemProcessor<Cartao, Cartao> cartaoProcessor() {
        return new CartaoProcessor();
    }

}

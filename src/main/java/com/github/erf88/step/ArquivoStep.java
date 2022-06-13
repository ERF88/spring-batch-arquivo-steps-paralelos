package com.github.erf88.step;

import com.github.erf88.model.Cartao;
import com.github.erf88.model.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoStep {

    @Bean
    public Step clienteStep(
            StepBuilderFactory stepBuilderFactory,
            FlatFileItemReader<Cliente> clienteReader,
            ItemProcessor<Cliente, Cliente> clienteProcessor,
            FlatFileItemWriter<Cliente> clienteWriter) {

        return stepBuilderFactory
                .get("clienteStep")
                .<Cliente, Cliente>chunk(50)
                .reader(clienteReader)
                .processor(clienteProcessor)
                .writer(clienteWriter)
                .build();
    }

    @Bean
    public Step cartaoStep(
            StepBuilderFactory stepBuilderFactory,
            FlatFileItemReader<Cartao> cartaoReader,
            ItemProcessor<Cartao, Cartao> cartaoProcessor,
            FlatFileItemWriter<Cartao> cartaoWriter) {

        return stepBuilderFactory
                .get("cartaoStep")
                .<Cartao, Cartao>chunk(50)
                .reader(cartaoReader)
                .processor(cartaoProcessor)
                .writer(cartaoWriter)
                .build();
    }

}

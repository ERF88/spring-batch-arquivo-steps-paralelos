package com.github.erf88.reader;

import com.github.erf88.model.Cartao;
import com.github.erf88.model.Cliente;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoReader {

    @Value("${spring.batch.file.clientes.in}")
    private Resource clientesResource;
    @Value("${spring.batch.file.cartoes.in}")
    private Resource cartoesResource;

    @Bean
    public FlatFileItemReader<Cliente> clienteReader() {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("clienteReader")
                .resource(clientesResource)
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "nome", "sobrenome", "email", "status" })
                .targetType(Cliente.class)
                .build();
    }

    @Bean
    public FlatFileItemReader<Cartao> cartaoReader() {
        return new FlatFileItemReaderBuilder<Cartao>()
                .name("cartaoReader")
                .resource(cartoesResource)
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "idCliente", "numeroCartao", "tipoCartao", "dataValidade" })
                .targetType(Cartao.class)
                .build();
    }

}

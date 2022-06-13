package com.github.erf88.writer;

import com.github.erf88.model.Cartao;
import com.github.erf88.model.Cliente;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoClienteWriter {

    @Value("${spring.batch.file.clientes.out}")
    private Resource clientesResource;
    @Value("${spring.batch.file.cartoes.out}")
    private Resource cartoesResource;

    @Bean
    public FlatFileItemWriter<Cliente> clienteWriter() {

        return new FlatFileItemWriterBuilder<Cliente>()
                .name("clienteWriter")
                .resource(clientesResource)
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "nome", "sobrenome", "email", "status", "dataProcessamento" })
                .build();
    }

    @Bean
    public FlatFileItemWriter<Cartao> cartaoWriter() {

        return new FlatFileItemWriterBuilder<Cartao>()
                .name("cartaoWriter")
                .resource(cartoesResource)
                .delimited()
                .delimiter(";")
                .names(new String[] {  "id", "idCliente", "numeroCartao", "tipoCartao", "dataValidade", "dataProcessamento" })
                .build();
    }

}

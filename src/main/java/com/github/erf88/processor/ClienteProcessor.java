package com.github.erf88.processor;

import com.github.erf88.model.Cliente;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final LocalDate dataProcessamento = LocalDate.now();

    @Override
    public Cliente process(Cliente cliente) {
        cliente.setDataProcessamento(dataProcessamento.format(formatter));
        return cliente;
    }

}


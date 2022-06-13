package com.github.erf88.flow;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class ArquivoFlow {

    @Bean
    public Flow stepsParalelos(
            Step clienteStep,
            Step cartaoStep) {

        return new FlowBuilder<Flow>("stepsParalelos")
                .start(clienteFlow(clienteStep))
                .split(new SimpleAsyncTaskExecutor())
                .add(cartaoFlow(cartaoStep))
                .build();
    }

    private Flow clienteFlow(Step clienteStep) {
        return new FlowBuilder<Flow>("clienteFlow")
                .start(clienteStep)
                .build();
    }

    private Flow cartaoFlow(Step cartaoStep) {
        return new FlowBuilder<Flow>("cartaoFlow")
                .start(cartaoStep)
                .build();
    }

}

package com.github.erf88.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoJob {

	@Bean
	public Job arquivosJob(
			JobBuilderFactory jobBuilderFactory,
			Flow stepsParalelos) {

		return jobBuilderFactory
				.get("arquivosJob")
				.incrementer(new RunIdIncrementer())
				.start(stepsParalelos)
				.end()
				.build();
	}

}

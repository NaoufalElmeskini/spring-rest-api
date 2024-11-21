package io.lacrobate.spring_rest_api.conf;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtlpConfiguration {
	@Bean
	public OtlpHttpSpanExporter exporter(@Value("${tracing.url}") String url) {
		return OtlpHttpSpanExporter.builder()
				.setEndpoint(url)
				.build();
	}
}

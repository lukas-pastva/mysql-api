package api.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.geo.GeoModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RestService {

	@Getter
	private final RestTemplate restTemplate;

	@Autowired
	public RestService(RestTemplateBuilder restTemplateBuilder) {
		CustomMapper objectMapper = new CustomMapper();
		objectMapper.registerModules(
				new JaxbAnnotationModule(),
				new Jdk8Module(),
				new JavaTimeModule(),
				new ParameterNamesModule(),
				new JsonComponentModule(),
				new GeoModule()
		);

		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

		CustomConverter messageConverter = new CustomConverter(objectMapper);
		messageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_XML));
		messageConverter.setDefaultCharset(StandardCharsets.UTF_8);

		restTemplate = restTemplateBuilder.additionalMessageConverters(messageConverter).build();

		restTemplate.setMessageConverters(Collections.singletonList(messageConverter));
	}

	private static class CustomMapper extends XmlMapper {

		@Override
		public <T> T readValue(InputStream src, JavaType valueType) throws IOException {
			String stringSrc = new BufferedReader(
					new InputStreamReader(src, StandardCharsets.UTF_8))
					.lines()
					.parallel()
					.collect(Collectors.joining("\n"))
					.replaceAll("\\n", "");

			return super.readValue(stringSrc, valueType);
		}

	}

	private static class CustomConverter extends MappingJackson2XmlHttpMessageConverter {

		protected CustomConverter(ObjectMapper objectMapper) {
			super(objectMapper);
		}

	}

}

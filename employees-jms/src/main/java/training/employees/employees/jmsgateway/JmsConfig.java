package training.employees.employees.jmsgateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

import java.util.Map;

@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        var converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_typeId");
        converter.setTypeIdMappings(
                Map.of("CreateEventCommand", MessageDto.class)
        );
        return converter;
    }
}

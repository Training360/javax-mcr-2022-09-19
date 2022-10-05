package training.employees.employees.jmsgateway;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
@AllArgsConstructor
public class EventStoreGateway {

    private JmsTemplate jmsTemplate;

    public void sendEvent(String message) {
        jmsTemplate.convertAndSend("eventsQueue", new MessageDto(message));
    }

}

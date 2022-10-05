package training.employees.employees.jmsgateway;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class EmployeeGateway {

    private JmsTemplate jmsTemplate;

    public void sendEvent(String message) {
        log.info("Üzenet küldése saját magam számára");
        jmsTemplate.convertAndSend("selfQueue", new MessageDto(message));
    }

    @JmsListener(destination = "selfQueue")
    public void processMessage(MessageDto messageDto) {
        log.info("Üzenet érkezett: {}", messageDto.getMessage());
    }
}

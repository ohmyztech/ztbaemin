package ztbaemin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ztbaemin.config.kafka.KafkaProcessor;
import ztbaemin.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PayCompleted'"
    )
    public void wheneverPayCompleted_LoadOrderInfo(
        @Payload PayCompleted payCompleted
    ) {
        PayCompleted event = payCompleted;
        System.out.println(
            "\n\n##### listener LoadOrderInfo : " + payCompleted + "\n\n"
        );

        // Sample Logic //
        Cooking.loadOrderInfo(event);
    }
}

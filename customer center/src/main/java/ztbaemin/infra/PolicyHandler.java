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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_NotifyToCustomer(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + orderAccepted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderDenied'"
    )
    public void wheneverOrderDenied_NotifyToCustomer(
        @Payload OrderDenied orderDenied
    ) {
        OrderDenied event = orderDenied;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + orderDenied + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_NotifyToCustomer(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + cookStarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookEnded'"
    )
    public void wheneverCookEnded_NotifyToCustomer(
        @Payload CookEnded cookEnded
    ) {
        CookEnded event = cookEnded;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + cookEnded + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_NotifyToCustomer(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " +
            deliveryCompleted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookPicked'"
    )
    public void wheneverCookPicked_NotifyToCustomer(
        @Payload CookPicked cookPicked
    ) {
        CookPicked event = cookPicked;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + cookPicked + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuPaid'"
    )
    public void wheneverMenuPaid_NotifyToCustomer(@Payload MenuPaid menuPaid) {
        MenuPaid event = menuPaid;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + menuPaid + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_NotifyToCustomer(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + orderCanceled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuOrdered'"
    )
    public void wheneverMenuOrdered_NotifyToCustomer(
        @Payload MenuOrdered menuOrdered
    ) {
        MenuOrdered event = menuOrdered;
        System.out.println(
            "\n\n##### listener NotifyToCustomer : " + menuOrdered + "\n\n"
        );
        // Sample Logic //

    }
}

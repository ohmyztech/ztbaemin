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
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_UpdateOrderStatus(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + orderCanceled + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuOrdered'"
    )
    public void wheneverMenuOrdered_UpdateOrderStatus(
        @Payload MenuOrdered menuOrdered
    ) {
        MenuOrdered event = menuOrdered;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + menuOrdered + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookEnded'"
    )
    public void wheneverCookEnded_UpdateOrderStatus(
        @Payload CookEnded cookEnded
    ) {
        CookEnded event = cookEnded;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookEnded + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_UpdateOrderStatus(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderDenied'"
    )
    public void wheneverOrderDenied_UpdateOrderStatus(
        @Payload OrderDenied orderDenied
    ) {
        OrderDenied event = orderDenied;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + orderDenied + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_UpdateOrderStatus(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + orderAccepted + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuPaid'"
    )
    public void wheneverMenuPaid_UpdateOrderStatus(@Payload MenuPaid menuPaid) {
        MenuPaid event = menuPaid;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + menuPaid + "\n\n"
        );

        // Sample Logic //
        Order.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuOrdered'"
    )
    public void wheneverMenuOrdered_PayMenu(@Payload MenuOrdered menuOrdered) {
        MenuOrdered event = menuOrdered;
        System.out.println(
            "\n\n##### listener PayMenu : " + menuOrdered + "\n\n"
        );

        // Sample Logic //
        Payment.payMenu(event);
    }
}

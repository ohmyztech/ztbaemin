package ztbaemin.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ztbaemin.config.kafka.KafkaProcessor;
import ztbaemin.domain.*;

@Service
public class DashboardViewHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMenuOrdered_then_CREATE_1(
        @Payload MenuOrdered menuOrdered
    ) {
        try {
            if (!menuOrdered.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setOrderStatus("주문완료");
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCompleted_then_UPDATE_1(
        @Payload PayCompleted payCompleted
    ) {
        try {
            if (!payCompleted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                payCompleted.getId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("결제완료");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_2(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                orderCanceled.getId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("주문취소");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_3(
        @Payload OrderAccepted orderAccepted
    ) {
        try {
            if (!orderAccepted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                Long.valueOf(orderAccepted.getOrderId())
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("주문수락");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderDenied_then_UPDATE_4(
        @Payload OrderDenied orderDenied
    ) {
        try {
            if (!orderDenied.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                Long.valueOf(orderDenied.getOrderId())
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("주문거부");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_5(
        @Payload CookStarted cookStarted
    ) {
        try {
            if (!cookStarted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                Long.valueOf(cookStarted.getOrderId())
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("조리시작");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookEnded_then_UPDATE_6(@Payload CookEnded cookEnded) {
        try {
            if (!cookEnded.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                Long.valueOf(cookEnded.getOrderId())
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("조리완료");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookPicked_then_UPDATE_7(@Payload CookPicked cookPicked) {
        try {
            if (!cookPicked.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                Long.valueOf(cookPicked.getOrderId())
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("배달시작");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_8(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                Long.valueOf(deliveryCompleted.getOrderId())
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderStatus("배달완료");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_DELETE_1(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            dashboardRepository.deleteByOrderId(orderCanceled.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

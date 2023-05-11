package ztbaemin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ztbaemin.RiderApplication;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String customerAddr;

    private String customerTel;

    private String deliveryStatus;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void pick(PickCommand pickCommand) {
        CookPicked cookPicked = new CookPicked(this);
        cookPicked.publishAfterCommit();
    }

    public void delivery(DeliveryCommand deliveryCommand) {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static void loadDeliveryInfo(CookEnded cookEnded) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookEnded.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}

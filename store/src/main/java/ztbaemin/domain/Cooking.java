package ztbaemin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ztbaemin.StoreApplication;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String customerAddr;

    private String customerTel;

    private String menuId;

    private String orderStat;

    private Integer menuQty;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {}

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void accept() {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void start() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void end() {
        CookEnded cookEnded = new CookEnded(this);
        cookEnded.publishAfterCommit();
    }

    public void deny() {
        OrderDenied orderDenied = new OrderDenied(this);
        orderDenied.publishAfterCommit();
    }

    public static void loadOrderInfo(PayCompleted payCompleted) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCompleted.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}

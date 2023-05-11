package ztbaemin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ztbaemin.FrontApplication;
import ztbaemin.domain.MenuOrdered;
import ztbaemin.domain.OrderCanceled;
import ztbaemin.domain.PayCompleted;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String userAddr;

    private String userTel;

    private String menuId;

    private Integer menuQty;

    private String orderStatus;

    @PostPersist
    public void onPostPersist() {
        MenuOrdered menuOrdered = new MenuOrdered(this);
        menuOrdered.publishAfterCommit();

        PayCompleted payCompleted = new PayCompleted(this);
        payCompleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateOrderStatus(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(MenuOrdered menuOrdered) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(menuOrdered.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(CookEnded cookEnded) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookEnded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(OrderDenied orderDenied) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderDenied.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(MenuPaid menuPaid) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PayCompleted payCompleted = new PayCompleted(order);
        payCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(menuPaid.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PayCompleted payCompleted = new PayCompleted(order);
            payCompleted.publishAfterCommit();

         });
        */

    }
}

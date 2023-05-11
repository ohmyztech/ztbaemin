package ztbaemin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ztbaemin.FrontApplication;
import ztbaemin.domain.MenuPaid;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderStatus;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {
        MenuPaid menuPaid = new MenuPaid(this);
        menuPaid.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = FrontApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void payMenu(MenuOrdered menuOrdered) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        MenuPaid menuPaid = new MenuPaid(payment);
        menuPaid.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(menuOrdered.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);

            MenuPaid menuPaid = new MenuPaid(payment);
            menuPaid.publishAfterCommit();

         });
        */

    }
}

package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String menuId;
    private String orderStat;
    private String customerId;
    private String customerAddr;
    private String customerTel;
    private Integer menuQty;
    private Long orderId;

    public OrderAccepted(Cooking aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}

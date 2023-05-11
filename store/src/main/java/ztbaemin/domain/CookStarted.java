package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerAddr;
    private String customerTel;
    private String menuId;
    private String orderStat;
    private Integer menuQty;
    private Long orderId;

    public CookStarted(Cooking aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}

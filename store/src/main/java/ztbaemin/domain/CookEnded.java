package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class CookEnded extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerAddr;
    private String customerTel;
    private String menuId;
    private String orderStat;
    private Integer menuQty;
    private Long orderId;

    public CookEnded(Cooking aggregate) {
        super(aggregate);
    }

    public CookEnded() {
        super();
    }
}

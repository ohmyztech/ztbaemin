package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class MenuPaid extends AbstractEvent {

    private Long id;
    private String orderStatus;
    private Long orderId;

    public MenuPaid(Payment aggregate) {
        super(aggregate);
    }

    public MenuPaid() {
        super();
    }
}

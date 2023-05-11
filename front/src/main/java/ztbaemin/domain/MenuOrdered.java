package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class MenuOrdered extends AbstractEvent {

    private Long id;
    private String userId;
    private String userAddr;
    private String userTel;
    private String menuId;
    private Integer menuQty;
    private String orderStatus;

    public MenuOrdered(Order aggregate) {
        super(aggregate);
    }

    public MenuOrdered() {
        super();
    }
}

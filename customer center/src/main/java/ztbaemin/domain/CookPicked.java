package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class CookPicked extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerAddr;
    private String customerTel;
    private String deliveryStatus;
    private Long orderId;
}

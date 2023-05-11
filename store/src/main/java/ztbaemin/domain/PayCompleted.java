package ztbaemin.domain;

import java.util.*;
import lombok.*;
import ztbaemin.domain.*;
import ztbaemin.infra.AbstractEvent;

@Data
@ToString
public class PayCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private String userAddr;
    private String userTel;
    private String menuId;
    private Integer menuQty;
    private String orderStatus;
}

package ztbaemin.domain;

import java.util.*;
import lombok.Data;
import ztbaemin.infra.AbstractEvent;

@Data
public class PayCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private String userAddr;
    private String userTel;
    private String menuId;
    private Integer menuQty;
    private String orderStatus;
}

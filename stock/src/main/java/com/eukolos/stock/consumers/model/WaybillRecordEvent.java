package com.eukolos.stock.consumers.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class WaybillRecordEvent {
    private String itemId;
    private Long quantity;
    private String waybillId;


}

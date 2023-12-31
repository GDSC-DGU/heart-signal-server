package com.heartsignal.dev.dto.bar.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarContentDTO {
    private BarInfoDTO first;
    private BarInfoDTO second;
}

package com.intellias.lesson4;

import lombok.*;

@Setter
@ToString(exclude = "count")
@Getter
@AllArgsConstructor(staticName = "of")
@Builder
public class Cheese {
    String type;
    int count;
}

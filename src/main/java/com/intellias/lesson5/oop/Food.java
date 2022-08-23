package com.intellias.lesson5.oop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Food {
    private String type;
    private String quantity;
}

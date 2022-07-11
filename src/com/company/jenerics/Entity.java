package com.company.jenerics;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Entity {
    private Long id;
}

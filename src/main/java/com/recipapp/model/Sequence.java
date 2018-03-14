package com.recipapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Sequence {

    @Id
    private Integer id;
    private Long seq;

    public Sequence increment() {
        seq++;
        return this;
    }

}

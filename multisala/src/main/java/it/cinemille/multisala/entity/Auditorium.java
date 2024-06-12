package it.cinemille.multisala.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Auditorium {

    @Id
    private Long id;
    private Integer seat;
    private Boolean imax;
}

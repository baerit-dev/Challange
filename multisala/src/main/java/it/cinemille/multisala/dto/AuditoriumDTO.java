package it.cinemille.multisala.dto;

import it.cinemille.multisala.entity.Auditorium;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuditoriumDTO {

    private Long auditoriumNumber;
    private Integer seat;
    private Boolean imax;

    public AuditoriumDTO(Auditorium auditorium) {
        this.auditoriumNumber = auditorium.getId();
        this.seat = auditorium.getSeat();
        this.imax = auditorium.getImax();
    }
}

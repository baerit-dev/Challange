package it.cinemille.multisala.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Movie {

    @Id
    private Long id;
    private String title;
    private String description;
    @Column("image_url")
    private String imageUrl;
}

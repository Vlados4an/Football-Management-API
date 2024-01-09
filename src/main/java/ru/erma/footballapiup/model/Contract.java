package ru.erma.footballapiup.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String start;
    private String until;

    @OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
    private Player player;

}

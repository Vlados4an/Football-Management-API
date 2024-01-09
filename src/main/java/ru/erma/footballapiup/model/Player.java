package ru.erma.footballapiup.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dateOfBirth;
    private String nationality;
    private String position;
    private Integer shirtNumber;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team currentTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;


    @ManyToOne
    @JoinColumn(name = "statistics_id")
    private Statistics statistics;

}


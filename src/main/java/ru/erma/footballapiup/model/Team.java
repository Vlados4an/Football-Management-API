package ru.erma.footballapiup.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer founded;
    private String clubColors;
    private String venue;

    @OneToMany(mappedBy = "currentTeam", cascade = CascadeType.ALL)
    private List<Player> footballPlayers;

    @ManyToOne
    private Area area;
}

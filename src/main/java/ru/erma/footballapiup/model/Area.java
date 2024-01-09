package ru.erma.footballapiup.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String flag;

    @OneToMany(mappedBy = "area",cascade = CascadeType.ALL)
    private List<Team> teams;
}

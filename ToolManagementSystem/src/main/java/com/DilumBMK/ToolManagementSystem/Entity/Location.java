package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String locationName;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Projects> projects = new HashSet<>();

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ToolBox toolBox;

}

package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@Data
@Entity
@Table(name = "Messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private LocalDateTime time;


}

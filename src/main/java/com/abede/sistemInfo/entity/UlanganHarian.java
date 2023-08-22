package com.abede.sistemInfo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UlanganHarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    @ManyToOne
    @JoinColumn(name = "siswa_mapel_id")
    private SiswaMapel siswaMapel;

    private Double nilai;

}

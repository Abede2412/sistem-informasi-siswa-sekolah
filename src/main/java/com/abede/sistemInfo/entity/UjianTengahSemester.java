package com.abede.sistemInfo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UjianTengahSemester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    @OneToOne
    @JoinColumn(name = "siswa_mapel_id")
    private SiswaMapel siswaMapel;

    private Double nilai;
}

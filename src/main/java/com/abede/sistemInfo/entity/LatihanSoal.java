package com.abede.sistemInfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LatihanSoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;

    @ManyToOne
    @JoinColumn(name = "siswa_mapel_id")
    private SiswaMapel siswaMapel;

    private Double nilai;

}

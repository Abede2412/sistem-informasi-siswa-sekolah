package com.abede.sistemInfo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiswaMapel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "siswa_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Siswa siswa;

    @ManyToOne
    @JoinColumn(
            name = "mapel_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Mapel mapel;

    @OneToMany(mappedBy = "siswaMapel", cascade = CascadeType.ALL)
    private List<LatihanSoal> latihanSoalList;

    @OneToMany(mappedBy = "siswaMapel", cascade = CascadeType.ALL)
    private List<UlanganHarian> ulanganHarianList;

    @OneToOne(mappedBy = "siswaMapel", cascade = CascadeType.ALL)
    private UjianAkhirSemester uas;

    @OneToOne(mappedBy = "siswaMapel", cascade = CascadeType.ALL)
    private UjianTengahSemester uts;

    private Double nilaiAkhir;

}

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
public class Mapel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    @OneToMany(
            mappedBy = "mapel",
            cascade = CascadeType.ALL
    )
    private List<SiswaMapel> siswaList;
    @Column(name = "nama_guru")
    private String namaGuru;

}

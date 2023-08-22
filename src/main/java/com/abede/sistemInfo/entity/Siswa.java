package com.abede.sistemInfo.entity;

import com.abede.sistemInfo.model.SiswaResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    @Column(name = "nilai_akhir")
    private Double nilaiAkhir;
    @ManyToOne
    @JoinColumn(name = "kelas_id", referencedColumnName = "id", nullable = false)
    private Kelas kelas;
    @OneToMany(
            mappedBy = "siswa",
            cascade = CascadeType.ALL
    )
    private List<SiswaMapel> mapelsTake;

    public SiswaResponse convertToResponse(){
        SiswaResponse siswaResponse = new SiswaResponse();
        siswaResponse.setId(id);
        siswaResponse.setNama(nama);
        siswaResponse.setKelas(kelas.getNama());
        return siswaResponse;
    }
}

package com.abede.sistemInfo.entity;

import com.abede.sistemInfo.model.KelasDetailResponse;
import com.abede.sistemInfo.model.KelasResponse;
import com.abede.sistemInfo.model.SiswaResponse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    @OneToMany(
            mappedBy = "kelas",
            cascade = CascadeType.ALL
    )
    private List<Siswa> siswaList;

    public KelasResponse convertToResponse(){
        KelasResponse response = new KelasResponse();
        response.setId(id);
        response.setName(nama);
        return response;
    }

    public KelasDetailResponse convertToDetailResponse(){
        List<SiswaResponse> collect = siswaList.stream().map(Siswa::convertToResponse).collect(Collectors.toList());
        KelasDetailResponse response = new KelasDetailResponse();
        response.setId(id);
        response.setName(nama);
        response.setStudents(collect);
        return response;
    }

}

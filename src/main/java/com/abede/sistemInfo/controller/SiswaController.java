package com.abede.sistemInfo.controller;

import com.abede.sistemInfo.entity.Kelas;
import com.abede.sistemInfo.entity.Siswa;
import com.abede.sistemInfo.model.SiswaRequest;
import com.abede.sistemInfo.model.SiswaResponse;
import com.abede.sistemInfo.repository.KelasRepository;
import com.abede.sistemInfo.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SiswaController {

    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private KelasRepository kelasRepository;

    @PostMapping(path = "/siswa")
    public SiswaResponse createOne(@RequestBody SiswaRequest siswa){
        Kelas kelas = kelasRepository.findById(siswa.getKelas()).orElse(null);
        Siswa newSiswa = new Siswa();
        newSiswa.setNama(siswa.getName());
        newSiswa.setKelas(kelas);
        Siswa savedSiswa = siswaRepository.save(newSiswa);
        return savedSiswa.convertToResponse();
    }

    @GetMapping(path = "/siswaDetail")
    public List<SiswaResponse> getAll(){
        List<Siswa> siswaList = siswaRepository.findAll();
        List<SiswaResponse> collect = siswaList.stream().map(Siswa::convertToResponse).collect(Collectors.toList());
        return collect;
    }
}

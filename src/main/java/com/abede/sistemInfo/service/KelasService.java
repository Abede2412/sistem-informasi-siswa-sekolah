package com.abede.sistemInfo.service;

import com.abede.sistemInfo.entity.Kelas;
import com.abede.sistemInfo.model.KelasResponse;
import com.abede.sistemInfo.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class KelasService {
    @Autowired
    private KelasRepository kelasRepository;
    public KelasResponse createOne(Kelas kelas) {
        Kelas saveKelas = kelasRepository.save(kelas);
        return saveKelas.convertToResponse();
    }

    public List<KelasResponse> getAll() {
        List<Kelas> kelasList = kelasRepository.findAll();
        List<KelasResponse> response = kelasList.stream().map(Kelas::convertToResponse).collect(Collectors.toList());
        return response;
    }
}

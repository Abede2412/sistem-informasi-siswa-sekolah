package com.abede.sistemInfo.controller;

import com.abede.sistemInfo.entity.Kelas;
import com.abede.sistemInfo.model.KelasDetailResponse;
import com.abede.sistemInfo.model.KelasResponse;
import com.abede.sistemInfo.repository.KelasRepository;
import com.abede.sistemInfo.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @Autowired
    KelasRepository kelasRepository;

    @PostMapping(path = "/kelas")
    public KelasResponse createOne(@RequestBody Kelas kelas){
        return kelasService.createOne(kelas);
    }

    @GetMapping(path = "/kelas")
    public List<KelasResponse> getAll(){
        return kelasService.getAll();
    }
    @GetMapping(path = "/kelasDetail")
    public List<KelasDetailResponse> getAllDetail(){
        return kelasRepository.findAll().stream().map(Kelas::convertToDetailResponse).collect(Collectors.toList());
    }
}

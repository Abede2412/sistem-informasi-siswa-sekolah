package com.abede.sistemInfo.repository;

import com.abede.sistemInfo.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiswaRepository extends JpaRepository<Siswa, Long> {
}
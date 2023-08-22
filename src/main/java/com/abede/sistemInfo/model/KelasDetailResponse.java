package com.abede.sistemInfo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KelasDetailResponse {

    private Long id;

    private String name;

    private List<SiswaResponse> students;
}

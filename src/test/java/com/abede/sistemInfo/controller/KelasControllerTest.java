package com.abede.sistemInfo.controller;

import com.abede.sistemInfo.entity.Kelas;
import com.abede.sistemInfo.model.KelasResponse;
import com.abede.sistemInfo.repository.KelasRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class KelasControllerTest {

    @Autowired
    KelasRepository kelasRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        kelasRepository.deleteAll();
    }

    Kelas createRandomKelas(){
         int number = (int) Math.random() * 10 + 1;
         Kelas kelas = new Kelas();
         kelas.setNama("X MIPA " + number);
         return kelas;
    }

    @Test
    void whenCreatedKelas_ThenOK() throws Exception {

        Kelas kelas = new Kelas();
        kelas.setNama("X MIPA 1");

        mockMvc.perform(
                post("/kelas")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(kelas))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            KelasResponse kelasResponse = objectMapper.readValue(result.getResponse().getContentAsString(), KelasResponse.class);

            Assertions.assertNotNull(kelasResponse.getId());
            Assertions.assertEquals(kelas.getNama(), kelasResponse.getName());
        });
    }

    @Test
    void whenGetListKelas_ThenOK() throws Exception {

        for (int i = 0; i < 10; i++){
            kelasRepository.save(createRandomKelas());
        }

        mockMvc.perform(
                get("/kelas")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            List<KelasResponse> responses = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);

            Assertions.assertEquals(10, responses.size());
        });
    }
}
package com.oocl.packagebooking.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.service.PackageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PackageController.class)
public class PackageOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackageService packageService;

    @Test
    void should_get_all_package() throws Exception {
        PackageOrder packageOrder1 = new PackageOrder("123","133333");
        PackageOrder packageOrder2 = new PackageOrder("123","133333");
        when(packageService.findAll()).thenReturn(Arrays.asList(packageOrder1, packageOrder2));
        ResultActions resultActions =mockMvc.perform(get("/package"))
                .andExpect(status().isOk());
        verify(packageService).findAll();
    }

    @Test
    void should_update_a_package() throws Exception {
        PackageOrder packageOrder = new PackageOrder("123","2222");
        when(packageService.update(any())).thenReturn(packageOrder);

        ResultActions resultActions =mockMvc.perform(put("/package").contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(packageOrder)));

        verify(packageService).update(any());

    }

}

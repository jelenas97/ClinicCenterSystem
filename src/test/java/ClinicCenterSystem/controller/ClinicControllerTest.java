package ClinicCenterSystem.controller;


import com.clinicCenter.App;

import com.clinicCenter.controller.ClinicController;
import com.clinicCenter.model.Clinic;
import com.clinicCenter.service.ClinicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClinicControllerTest {

    private static final String URL_SEARCH_CLINICS = "/auth/getAllClinics";
    private static final String URL_SEARCH_CLINICS2 = "/auth/getSearchedClinics/1/Vla/8";


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Mock
    private ClinicService clinicService;

    @InjectMocks
    private ClinicController clinicController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(clinicController)
                .build();
    }

    @Test
    public void testGetAllClinics() throws Exception {
        List<Clinic> clinics = new ArrayList<>();
        clinics.add(new Clinic());
        clinics.add(new Clinic());
        clinics.add(new Clinic());
        clinics.add(new Clinic());

        when(clinicService.getAllClinics()).thenReturn(clinics);


        mockMvc.perform(get(URL_SEARCH_CLINICS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(4)));

        verify(clinicService, times(1)).getAllClinics();

    }

    @Test
    public void testGetSearchedClinics() throws Exception {
        Set<Clinic> clinics = new HashSet<>();
        clinics.add(new Clinic());

        when(clinicService.getSearchedClinicsFour(1L, "Bel" , 0.0 )).thenReturn(clinics);


        mockMvc.perform(get(URL_SEARCH_CLINICS2))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(clinicService, times(1)).getSearchedClinicsFour(1L, "Bel" , 0.0 );

    }
}

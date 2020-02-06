package ClinicCenterSystem.controller;


import com.clinicCenter.App;
import com.clinicCenter.controller.MedicalExaminationTypeController;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalExaminationTypeControllerTest {

    private static final String GET_ALL_PREDEFINED_EXAMINATIONS = "/typesOfMedicalExam";


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Mock
    private MedicalExaminationTypeService medicalExaminationTypeService;

    @InjectMocks
    private MedicalExaminationTypeController medicalExaminationTypeController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(medicalExaminationTypeController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        List<MedicalExaminationType> types = new ArrayList<>();
        types.add(new MedicalExaminationType());
        types.add(new MedicalExaminationType());
        types.add(new MedicalExaminationType());

        when(medicalExaminationTypeService.getAll()).thenReturn(types);

        mockMvc.perform(get(GET_ALL_PREDEFINED_EXAMINATIONS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(3)));

        verify(medicalExaminationTypeService, times(1)).getAll();
    }
}

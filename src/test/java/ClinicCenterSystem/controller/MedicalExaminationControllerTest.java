/*package ClinicCenterSystem.controller;

import com.clinicCenter.App;
import com.clinicCenter.controller.MedicalExaminationController;
import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.service.MedicalExaminationService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalExaminationControllerTest {

    private static final String GET_ALL_PREDEFINED_EXAMINATIONS = "/getAllPredefinedExaminations";
    private static final String GET_CLINICS_PREDEFINED_EXAMINATIONS = "/getClinicsPredefinedExaminations/2";
    private static final String SCHEDULE_PREDEFINED_MEDICAL_EXAMINATION = "/schedulePredefinedMedicalExamination/41/1";

    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Mock
    private MedicalExaminationService medicalExaminationService;

    @InjectMocks
    private MedicalExaminationController medicalExaminationController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(medicalExaminationController).build();
    }

    /*@Test
    public void testGetAllPredefinedMedicalExaminations() throws Exception {
        List<MedicalExamination> predefinedMedicalExaminations = new ArrayList<>();
        predefinedMedicalExaminations.add(new MedicalExamination());

        when(medicalExaminationService.getAllPredefinedMedicalExaminations()).thenReturn(predefinedMedicalExaminations);

        mockMvc.perform(get(GET_ALL_PREDEFINED_EXAMINATIONS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(medicalExaminationService, times(1)).getAllPredefinedMedicalExaminations();
    }

    @Test
    public void testGetClinicsPredefinedMedicalExaminations() throws Exception {
        List<MedicalExamination> clinicPredefinedMedicalExaminations = new ArrayList<>();
        clinicPredefinedMedicalExaminations.add(new MedicalExamination());
        Long clinicId = 2L;
        when(medicalExaminationService.getClinicsPredefinedExaminations(clinicId)).thenReturn(clinicPredefinedMedicalExaminations);

        mockMvc.perform(get(GET_CLINICS_PREDEFINED_EXAMINATIONS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(medicalExaminationService, times(1)).getClinicsPredefinedExaminations(clinicId);
    }
}*/

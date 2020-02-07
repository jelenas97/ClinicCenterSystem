package ClinicCenterSystem.controller;

import com.clinicCenter.App;
import com.clinicCenter.controller.MedicalExaminationController;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.MedicalExaminationRepository;
import com.clinicCenter.service.MedicalExaminationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalExaminationControllerTest {

    private static final String GET_ALL_PREDEFINED_EXAMINATIONS = "/getAllPredefinedExaminations";
    private static final String GET_CLINICS_PREDEFINED_EXAMINATIONS = "/getClinicsPredefinedExaminations/1";
    private static final String SCHEDULE_PREDEFINED_MEDICAL_EXAMINATION = "/schedulePredefinedMedicalExamination/1/18";

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

    @Test
    public void testGetAllPredefinedMedicalExaminations() throws Exception {
        List<MedicalExamination> predefinedMedicalExaminations = new ArrayList<>();
        MedicalExamination medicalExamination = new MedicalExamination();
        medicalExamination.setId(1L);

        Doctor doctor = new Doctor();
        doctor.setId(5L);

        Clinic clinic = new Clinic();
        clinic.setId(1L);

        MedicalExaminationRoom mer = new MedicalExaminationRoom();
        mer.setId(1L);

        Patient patient = new Patient();
        patient.setId(18L);

        MedicalExaminationType medicalExaminationType = new MedicalExaminationType();
        medicalExaminationType.setId(1L);

        medicalExamination.setClinic(clinic);
        medicalExamination.setDoctor(doctor);
        medicalExamination.setMedicalExaminationRoom(mer);
        medicalExamination.setPatient(patient);
        medicalExamination.setType(medicalExaminationType);

        predefinedMedicalExaminations.add(medicalExamination);

        when(medicalExaminationService.getAllPredefinedMedicalExaminations()).thenReturn(predefinedMedicalExaminations);

        mockMvc.perform(get(GET_ALL_PREDEFINED_EXAMINATIONS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(medicalExaminationService, times(1)).getAllPredefinedMedicalExaminations();
    }

    @Test
    public void testGetClinicsPredefinedMedicalExaminations() throws Exception {
        List<MedicalExamination> clinicPredefinedMedicalExaminations = new ArrayList<>();
        clinicPredefinedMedicalExaminations.add(new MedicalExamination());

        when(medicalExaminationService.getClinicsPredefinedExaminations(1L)).thenReturn(clinicPredefinedMedicalExaminations);

        mockMvc.perform(get(GET_CLINICS_PREDEFINED_EXAMINATIONS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)));

        verify(medicalExaminationService, times(1)).getClinicsPredefinedExaminations(1L);
    }

}

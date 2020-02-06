package ClinicCenterSystem.service;

import com.clinicCenter.App;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.MedicalExaminationRepository;
import com.clinicCenter.service.MedicalExaminationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static ClinicCenterSystem.constants.MedicalExaminationRequestConstants.*;
import static ClinicCenterSystem.constants.MedicalExaminationRequestConstants.TEST_NEW_CLINIC_TIMES_RATED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalExaminationServiceTest {

    @MockBean
    private MedicalExaminationRepository medicalExaminationRepository;

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @Test
    public void testGetAllPredefinedMedicalExaminations() {
        List<MedicalExamination> predefinedMedicalExaminations = new ArrayList<>();
        predefinedMedicalExaminations.add(new MedicalExamination());

        Mockito.when(medicalExaminationRepository.getAllPredefinedMedicalExaminations()).thenReturn(predefinedMedicalExaminations);

        List<MedicalExamination> allPredefined = (List<MedicalExamination>) medicalExaminationService.getAllPredefinedMedicalExaminations();
        assertEquals(1, allPredefined.size());

        verify(medicalExaminationRepository, times(1)).getAllPredefinedMedicalExaminations();

    }

    @Test
    public void testGetClinicsPredefinedExaminations() {
        Long clinicId = 2L; // ovo ce biti konstanta

        List<MedicalExamination> clinicsPredefinedMedicalExaminations = new ArrayList<>();
        clinicsPredefinedMedicalExaminations.add(new MedicalExamination());

        Mockito.when(medicalExaminationRepository.getClinicsPredefinedExaminations(clinicId)).thenReturn(clinicsPredefinedMedicalExaminations);

        List<MedicalExamination> clinicsPredefined = (List<MedicalExamination>) medicalExaminationService.getClinicsPredefinedExaminations(clinicId);
        assertEquals(1, clinicsPredefined.size());

        verify(medicalExaminationRepository, times(1)).getClinicsPredefinedExaminations(clinicId);
    }
/*
    @Test
    @Transactional
    @Rollback(true)
    public void testSchedulePredefinedMedicalExamination() throws ParseException {

        List<MedicalExamination> predefined = new ArrayList<>();

        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(TEST_DATE);
        Clinic clinic = new Clinic(TEST_NEW_CLINIC_ID, TEST_NEW_CLINIC_NAME, TEST_NEW_CLINIC_ADDRESS, TEST_NEW_CLINIC_CITY, TEST_NEW_CLINIC_DESCRIPTION, TEST_NEW_CLINIC_AVERAGE_RATING, TEST_NEW_CLINIC_TIMES_RATED);

        MedicalExaminationRoom mer = new MedicalExaminationRoom();
        mer.setId(2L);
        mer.setName("Bla");
        mer.setNumber(1);
        mer.setClinic(clinic);

        Doctor doctor = new Doctor("Marko", "Markovic");
        doctor.setId(3L);


        MedicalExaminationType type = new MedicalExaminationType(TEST_NEW_TYPE_NAME, TEST_NEW_TYPE_PRICE);
        type.setId(2L);

        Patient patient2 = new Patient();
        patient2.setId(1L);
        patient2.setFirstName("Bole");
        patient2.setLastName("Bojanic");

        MedicalExamination newMe = new MedicalExamination(date, 1000.0, 30.0, 0.0, mer, doctor, patient2, clinic, type, true);
        newMe.setId(41L);

        predefined.add(new MedicalExamination());
        Mockito.when(medicalExaminationRepository.getAllPredefinedMedicalExaminations()).thenReturn(predefined);
        assertEquals(1, predefined.size());

        medicalExaminationService.schedulePredefinedMedicalExamination(newMe.getId(), patient2.getId());

        List<MedicalExamination> allPredefined = new ArrayList<>();
        Mockito.when(medicalExaminationRepository.getAllPredefinedMedicalExaminations()).thenReturn(allPredefined);

        assertEquals(0, allPredefined.size());

        verify(medicalExaminationRepository, times(1)).getAllPredefinedMedicalExaminations();
    }
    */

}

package ClinicCenterSystem.service;

import com.clinicCenter.App;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.MedicalExaminationRepository;
import com.clinicCenter.service.MedicalExaminationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ClinicCenterSystem.constants.MedicalExaminationRequestConstants.*;
import static org.junit.Assert.assertEquals;
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
        Long clinicId = 1L; // ovo ce biti konstanta

        List<MedicalExamination> clinicsPredefinedMedicalExaminations = new ArrayList<>();
        clinicsPredefinedMedicalExaminations.add(new MedicalExamination());

        Mockito.when(medicalExaminationRepository.getClinicsPredefinedExaminations(clinicId)).thenReturn(clinicsPredefinedMedicalExaminations);

        List<MedicalExamination> clinicsPredefined = (List<MedicalExamination>) medicalExaminationService.getClinicsPredefinedExaminations(clinicId);
        assertEquals(1, clinicsPredefined.size());

        verify(medicalExaminationRepository, times(1)).getClinicsPredefinedExaminations(clinicId);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testSchedulePredefinedMedicalExamination() throws ParseException {

        List<MedicalExamination> predefined = new ArrayList<>();

        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(TEST_DATE);
        Clinic clinic = new Clinic();
        clinic.setId(1L);

        MedicalExaminationRoom mer = new MedicalExaminationRoom();
        mer.setId(1L);

        Doctor doctor = new Doctor();
        doctor.setId(5L);

        MedicalExaminationType type = new MedicalExaminationType();
        type.setId(1L);

        Patient patient2 = new Patient();
        patient2.setId(18L);

        MedicalExamination newMe = new MedicalExamination(date, 1000.0, 30.0, 1.0, mer, doctor, patient2, clinic, type, true);
        newMe.setId(2L);

        predefined.add(newMe);

        medicalExaminationRepository.schedulePredefinedMedicalExamination(newMe.getId(), patient2.getId());

        Mockito.when(medicalExaminationRepository.getAllPredefinedMedicalExaminations()).thenReturn(predefined);

        List<MedicalExamination> medicalExaminations = (List<MedicalExamination>) medicalExaminationRepository.getAllPredefinedMedicalExaminations();
        assertEquals(1, medicalExaminations.size());

        verify(medicalExaminationRepository, times(1)).getAllPredefinedMedicalExaminations();
    }


}

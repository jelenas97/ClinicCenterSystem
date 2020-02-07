package ClinicCenterSystem.repository;

import com.clinicCenter.App;
import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.Patient;
import com.clinicCenter.repository.MedicalExaminationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static ClinicCenterSystem.constants.MedicalExaminationConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class MedicalExaminationRepositoryTest {

    @Autowired
    private MedicalExaminationRepository medicalExaminationRepository;

    @Test
    public void testGetAllPredefinedMedicalExaminations() {
        ArrayList<MedicalExamination> allPredefined = (ArrayList<MedicalExamination>) medicalExaminationRepository.getAllPredefinedMedicalExaminations();
        assertEquals(NUMBER_OF_EXPECTED_PREDEFINED, allPredefined.size());

        for (MedicalExamination m : allPredefined) {
            if (m.getId().equals(EXPECTED_PREDEFINED_EXAM_ID)) {
                assertEquals(EXPECTED_DOCTOR_ID, m.getDoctor().getId());
            }
        }
    }

    @Test
    public void testGetClinicsPredefinedExaminations() {
        Long clinicId = 1L; // ovo ce biti konstanta

        ArrayList<MedicalExamination> clinicsPredefined = (ArrayList<MedicalExamination>) medicalExaminationRepository.getClinicsPredefinedExaminations(clinicId);
        assertEquals(2, clinicsPredefined.size());

        for (MedicalExamination m : clinicsPredefined) {
            if (m.getId().equals(EXPECTED_PREDEFINED_EXAM_ID)) {
                assertEquals(clinicId, m.getClinic().getId());
            }
        }
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testSchedulePredefinedMedicalExamination() {
        Long examId = 1L;
        MedicalExamination medicalExaminationPredefined = medicalExaminationRepository.findById(examId).get();

        assertEquals(false, medicalExaminationPredefined.getConfirmed());

        assertNull(null, medicalExaminationPredefined.getPatient());

        medicalExaminationPredefined.setConfirmed(true);

        Patient patient = new Patient("Ivana", "Stojkovic");
        patient.setId(18L);

        medicalExaminationPredefined.setPatient(patient);

        medicalExaminationRepository.schedulePredefinedMedicalExamination(examId, patient.getId());

        assertEquals(patient.getId(), medicalExaminationPredefined.getPatient().getId());
    }


}

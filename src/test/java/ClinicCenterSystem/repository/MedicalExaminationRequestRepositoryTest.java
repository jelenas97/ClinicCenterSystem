package ClinicCenterSystem.repository;

import com.clinicCenter.App;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.MedicalExaminationRequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ClinicCenterSystem.constants.MedicalExaminationRequestConstants.*;
import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class MedicalExaminationRequestRepositoryTest {

    @Autowired
    private MedicalExaminationRequestRepository medicalExaminationRequestRepository;


    @Test
    @Transactional
    @Rollback(true)
    public void testSaveExaminationRequest() throws ParseException {
        MedicalExaminationType type = new MedicalExaminationType(TEST_NEW_TYPE_NAME, TEST_NEW_TYPE_PRICE);

        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(TEST_DATE);

        Clinic clinic = new Clinic(TEST_NEW_CLINIC_ID, TEST_NEW_CLINIC_NAME, TEST_NEW_CLINIC_ADDRESS, TEST_NEW_CLINIC_CITY, TEST_NEW_CLINIC_DESCRIPTION, TEST_NEW_CLINIC_AVERAGE_RATING, TEST_NEW_CLINIC_TIMES_RATED);
        Doctor doctor = new Doctor("Milos", "Ivanovic");
        doctor.setId(5L);

        Patient patient = new Patient("Ivana", "Stojkovic");
        patient.setId(18L);

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, doctor, patient);
        newReq.setId(1L);

        MedicalExaminationRequest requestSaved = this.medicalExaminationRequestRepository.save(newReq);

        MedicalExaminationRequest request = medicalExaminationRequestRepository.getOne(requestSaved.getId());

        assertNotNull(request);
        Long id = 5L;
        assertEquals(id, request.getDoctor().getId());
    }
}

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

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
public class MedicalExaminationRequestRepositoryTest {

    @Autowired
    private MedicalExaminationRequestRepository medicalExaminationRequestRepository;

    /*@Autowired
    private TestEntityManager testEntityManager;*/

    @Test
    @Transactional
    @Rollback(true)
    public void testSaveExaminationRequest() throws ParseException {
        MedicalExaminationType type = new MedicalExaminationType("Pregled ociju", 1000.0);

        String dates = "2020/02/20 15:30:00.000000";
        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dates);
        // Mora da id doktora, klinike, bilo kogaa, bude postojec iz baze
        Clinic clinic = new Clinic(1L, "Klinika Vid", "Bulevar Oslobodjenja", "Novi Sad", "Klinka za vid", 9.0, 1);
        Doctor doctor = new Doctor("Marko", "Markovic");
        doctor.setId(3L);

        Patient patient = new Patient("Doktoe", "Doktoric");
        patient.setId(1L);

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, doctor, patient);
        newReq.setId(1L);

        MedicalExaminationRequest requestSaved = this.medicalExaminationRequestRepository.save(newReq);
        // testEntityManager.flush();

        MedicalExaminationRequest request = medicalExaminationRequestRepository.getOne(requestSaved.getId());

        assertNotNull(request);
        Long id = 3L;
        assertEquals(id, request.getDoctor().getId());
    }
}

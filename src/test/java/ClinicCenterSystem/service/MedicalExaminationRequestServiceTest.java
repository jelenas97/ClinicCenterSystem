package ClinicCenterSystem.service;

import com.clinicCenter.App;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.MedicalExaminationRepository;
import com.clinicCenter.repository.MedicalExaminationRequestRepository;
import com.clinicCenter.service.MedicalExaminationRequestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ClinicCenterSystem.constants.MedicalExaminationRequestConstants.*;
import static ClinicCenterSystem.constants.MedicalExaminationRequestConstants.TEST_NEW_CLINIC_TIMES_RATED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalExaminationRequestServiceTest {

    @MockBean
    private MedicalExaminationRequestRepository medicalExaminationRequestRepository;

    @Autowired
    private MedicalExaminationRequestService medicalExaminationRequestService;

    @Test
    public void testSaveExaminationRequest() throws ParseException {
        List<MedicalExaminationRequest> requests = new ArrayList<>();
        requests.add(new MedicalExaminationRequest());
        requests.add(new MedicalExaminationRequest());

        Mockito.when(medicalExaminationRequestRepository.findAll()).thenReturn(requests);

        assertEquals(2, requests.size());

        MedicalExaminationType type = new MedicalExaminationType(TEST_NEW_TYPE_NAME, TEST_NEW_TYPE_PRICE);
        type.setId(1L);

        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(TEST_DATE);

        Clinic clinic = new Clinic(TEST_NEW_CLINIC_ID, TEST_NEW_CLINIC_NAME, TEST_NEW_CLINIC_ADDRESS, TEST_NEW_CLINIC_CITY, TEST_NEW_CLINIC_DESCRIPTION, TEST_NEW_CLINIC_AVERAGE_RATING, TEST_NEW_CLINIC_TIMES_RATED);
        Doctor doctor = new Doctor();
        doctor.setId(5L);

        Patient patient = new Patient();
        patient.setId(18L);

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, doctor, patient);
        newReq.setId(1L);

        this.medicalExaminationRequestService.sendRequest(type.getId(),  date, clinic.getId(), doctor.getId(), patient.getId());

        List<MedicalExaminationRequest> requests2 = new ArrayList<>();
        requests2.add(new MedicalExaminationRequest());
        requests2.add(new MedicalExaminationRequest());
        requests2.add(new MedicalExaminationRequest());

        Mockito.when(medicalExaminationRequestRepository.findAll()).thenReturn(requests2);
        List<MedicalExaminationRequest> mes = medicalExaminationRequestService.getAllExamsRequests();
        assertEquals(3, mes.size());

        verify(medicalExaminationRequestRepository, times(1)).findAll();

    }
}

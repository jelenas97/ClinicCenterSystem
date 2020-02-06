package ClinicCenterSystem.service;

import com.clinicCenter.App;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.repository.MedicalExaminationTypeRepository;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ClinicCenterSystem.constants.MedicalExaminationTypeConstants.NUMBER_OF_TYPES;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalExaminationTypeServiceTest {

    @MockBean
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Autowired
    private MedicalExaminationTypeService medicalExaminationTypeService;

    @Test
    public void testGetAll() {
        List<MedicalExaminationType> types = new ArrayList<>();
        types.add(new MedicalExaminationType());
        types.add(new MedicalExaminationType());
        types.add(new MedicalExaminationType());

        Mockito.when(medicalExaminationTypeRepository.findAll()).thenReturn(types);

        List<MedicalExaminationType> medicalExaminationTypes = medicalExaminationTypeService.getAll();
        assertEquals(NUMBER_OF_TYPES, medicalExaminationTypes.size());

        verify(medicalExaminationTypeRepository, times(1)).findAll();
    }
}

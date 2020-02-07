package ClinicCenterSystem.repository;

import com.clinicCenter.App;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.model.User;
import com.clinicCenter.repository.MedicalExaminationRepository;
import com.clinicCenter.repository.MedicalExaminationTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static ClinicCenterSystem.constants.MedicalExaminationTypeConstants.FIRST_TYPE_NAME;
import static ClinicCenterSystem.constants.MedicalExaminationTypeConstants.NUMBER_OF_TYPES;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class MedicalExaminationTypeRepositoryTest {

    @Autowired
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Test
    public void testGetAll(){
        Set<MedicalExaminationType> types = medicalExaminationTypeRepository.getAll();
        assertEquals(NUMBER_OF_TYPES, types.size());

        for (MedicalExaminationType medicalExaminationType : types) {
            if (medicalExaminationType.getId() == 1) {
                assertEquals(FIRST_TYPE_NAME, medicalExaminationType.getName());
            }
        }
    }

}



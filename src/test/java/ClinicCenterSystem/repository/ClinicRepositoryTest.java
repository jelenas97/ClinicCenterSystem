package ClinicCenterSystem.repository;

import com.clinicCenter.App;
import com.clinicCenter.model.Clinic;
import com.clinicCenter.model.ClinicMapper;
import com.clinicCenter.repository.ClinicRepository;
import com.clinicCenter.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class ClinicRepositoryTest {

    @Autowired
    private ClinicRepository clinicRepository;

    @Test
    public void testGetAllClinics() {
        List<Clinic> clinics = clinicRepository.findAll();
        assertEquals(4, clinics.size());
    }


    @Test
    public void testGetSearchedClinics() {
        Collection<Clinic> clinics = clinicRepository.getSearchedClinics(1L);
        assertEquals(4, clinics.size());
    }

    @Test
    public void testGetSearchedClinicsTwo() {
        Collection<Clinic> clinics = clinicRepository.getSearchedClinicsTwo(1L, 8.7);
        assertEquals(0, clinics.size());
    }

    @Test
    public void testGetSearchedClinicsThree() {
        Collection<Clinic> clinics = clinicRepository.getSearchedClinicsThree(1L, "Bel");
        assertEquals(1, clinics.size());
    }

    @Test
    public void testGetSearchedClinicsFour() {
        Collection<Clinic> clinics = clinicRepository.getSearchedClinicsFour(1L, "Bel", 8.0);
        assertEquals(0, clinics.size());
    }


}

package ClinicCenterSystem.service;

import com.clinicCenter.App;
import com.clinicCenter.model.Clinic;
import com.clinicCenter.model.ClinicMapper;
import com.clinicCenter.repository.ClinicRepository;
import com.clinicCenter.service.ClinicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClinicServiceTest {

    @MockBean
    private ClinicRepository clinicRepositoryMocked;

    @Autowired
    private ClinicService clinicService;

    @Test
    public void testGetAllClinics() {
        Clinic clinic1 = new Clinic(1L,"KCV", "Danila Kisa", "Novi Sad", "Ovo je lepa klinika", 0.0, 0);
        Clinic clinic2 = new Clinic(2L,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", 0.0, 0);
        Clinic clinic3 = new Clinic(3L,"Nata", "Gospodar Jovanova", "Beograd", "Klinika za sve i svasta", 0.0, 0);
        Clinic clinic4 = new Clinic(4L,"Poliklinika Panajotovic", "Dragise Cvetkovica", "Nis", "U nis", 0.0, 0);
        List<Clinic> clinics = new ArrayList<>();
        clinics.add(clinic1);
        clinics.add(clinic2);
        clinics.add(clinic3);
        clinics.add(clinic4);


        Mockito.when(clinicRepositoryMocked.findAll()).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getAllClinics();
        assertEquals(4, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).findAll();

    }

    @Test
    public void testGetSearchedClinics() {
        Clinic clinic1 = new Clinic(1L,"KCV", "Danila Kisa", "Novi Sad", "Ovo je lepa klinika", 0.0, 0);
        Clinic clinic2 = new Clinic(2L,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", 0.0, 0);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);
        clinics.add(clinic2);

        Mockito.when(clinicRepositoryMocked.getSearchedClinics(1L)).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinics(1l);
        assertEquals(2, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinics(1L);

    }

    @Test
    public void testGetSearchedClinicsTwo() {
        Clinic clinic1 = new Clinic(1L,"KCV", "Danila Kisa", "Novi Sad", "Ovo je lepa klinika", 0.0, 0);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);

        Mockito.when(clinicRepositoryMocked.getSearchedClinicsTwo(1L, 0.0)).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinicsTwo(1l, 0.0);
        assertEquals(1, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinicsTwo(1L, 0.0);

    }

    @Test
    public void testGetSearchedClinicsThree() {
        Clinic clinic1 = new Clinic(2L,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", 0.0, 0);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);

        Mockito.when(clinicRepositoryMocked.getSearchedClinicsThree(1L, "Bel")).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinicsThree(1l, "Bel");
        assertEquals(1, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinicsThree(1L, "Bel");

    }

    @Test
    public void testGetSearchedClinicsFour() {
        Clinic clinic1 = new Clinic(2L,"Bel Medic", "Viktora Igoa", "Beograd", "Ovo je klinika u Beogradu", 0.0, 0);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);

        Mockito.when(clinicRepositoryMocked.getSearchedClinicsFour(1L, "Bel", 0.0)).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinicsFour(1l, "Bel", 0.0);
        assertEquals(1, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinicsFour(1L, "Bel", 0.0);

    }
}

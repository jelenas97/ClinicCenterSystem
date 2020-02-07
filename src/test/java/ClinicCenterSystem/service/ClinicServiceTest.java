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
        Clinic clinic1 = new Clinic(1L,"Dom Bajic", "Hajduk Veljkova 1-9", "Novi Sad", "Ludara", 9.0, 2);
        Clinic clinic2 = new Clinic(2L,"Dom Vlahovic", "Milosa Simovica", "Beograd", "Neludara", 8.5, 4);
        Clinic clinic3 = new Clinic(1L,"Dom Culum", "Mile Simica", "Iscuruga", "Kkfdaf", 6.0, 1);
        Clinic clinic4 = new Clinic(2L,"Dom Sajam", "Sole Misevica", "Indjija", "Sdfsdf", 7.5, 2);
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
        Clinic clinic1 = new Clinic(1L,"Dom Bajic", "Hajduk Veljkova 1-9", "Novi Sad", "Ludara", 9.0, 2);
        Clinic clinic2 = new Clinic(2L,"Dom Vlahovic", "Milosa Simovica", "Beograd", "Neludara", 8.5, 4);
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
        Clinic clinic1 = new Clinic(1L,"Dom Bajic", "Hajduk Veljkova 1-9", "Novi Sad", "Ludara", 9.0, 2);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);

        Mockito.when(clinicRepositoryMocked.getSearchedClinicsTwo(1L, 8.7)).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinicsTwo(1l, 8.7);
        assertEquals(1, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinicsTwo(1L, 8.7);

    }

    @Test
    public void testGetSearchedClinicsThree() {
        Clinic clinic1 = new Clinic(2L,"Dom Vlahovic", "Milosa Simovica", "Beograd", "Neludara", 8.5, 4);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);

        Mockito.when(clinicRepositoryMocked.getSearchedClinicsThree(1L, "Vlah")).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinicsThree(1l, "Vlah");
        assertEquals(1, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinicsThree(1L, "Vlah");

    }

    @Test
    public void testGetSearchedClinicsFour() {
        Clinic clinic1 = new Clinic(2L,"Dom Vlahovic", "Milosa Simovica", "Beograd", "Neludara", 8.5, 4);
        Set<Clinic> clinics = new HashSet<Clinic>();
        clinics.add(clinic1);

        Mockito.when(clinicRepositoryMocked.getSearchedClinicsFour(1L, "Vlah", 8.0)).thenReturn(clinics);

        Collection<Clinic> clinicsResult = clinicService.getSearchedClinicsFour(1l, "Vlah", 8.0);
        assertEquals(1, clinicsResult.size());

        verify(clinicRepositoryMocked,times(1)).getSearchedClinicsFour(1L, "Vlah", 8.0);

    }
}

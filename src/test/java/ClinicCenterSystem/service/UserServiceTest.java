package ClinicCenterSystem.service;

import com.clinicCenter.App;
import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.User;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testDoctorsThatCanDoExam() {

        ArrayList<User> doctors = new ArrayList<>();
        doctors.add(new Doctor());

        Mockito.when(userRepository.getDoctorsThatCanDoExam(1L, 2L, "2020-02-15 00:00:00.000000")).thenReturn(doctors);

        Collection<User> users = userService.getDoctorsThatCanDoExam(1L, 2L, "2020-02-15 00:00:00.000000");
        assertEquals(1, users.size());

        verify(userRepository,times(1)).getDoctorsThatCanDoExam(1L, 2L, "2020-02-15 00:00:00.000000");

    }
}

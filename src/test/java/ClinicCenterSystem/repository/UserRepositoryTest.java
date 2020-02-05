package ClinicCenterSystem.repository;

import com.clinicCenter.App;
import com.clinicCenter.controller.UserController;
import com.clinicCenter.model.User;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testDoctorsThatCanDoExam(){
        Collection<User> doctors = userRepository.getDoctorsThatCanDoExam(1L, 2L, "2020-02-15 00:00:00.000000");
        assertEquals(1, doctors.size());
    }
}



package ClinicCenterSystem.controller;

import com.clinicCenter.App;
import com.clinicCenter.controller.UserController;
import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.User;
import com.clinicCenter.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    private static final String URL_DOCTORS = "/auth/getDoctorsThatCanDoExam/1/1/2020_02_14";
    private static final String URL_DOCTORS2 = "/auth/getDoctorsThatCanDoExam/1/4/2020_02_14";

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }

    @Test
    public void testGetDoctorsThatCanDoExam() throws Exception {

        ArrayList<User> users = new ArrayList<>();
        Doctor doctor = new Doctor();
        doctor.setId(5L);
        doctor.setFirstName("Milos");
        doctor.setLastName("Ivanovic");
        doctor.setCountry("Srbija");
        users.add(doctor);

        when(userService.getDoctorsThatCanDoExam(1L, 1L, "2020_02_14")).thenReturn(users);

        mockMvc.perform(get(URL_DOCTORS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[*].firstName").value(hasItem("Milos")))
                .andExpect(jsonPath("$.[*].lastName").value(hasItem("Ivanovic")))
                .andExpect(jsonPath("$.[*].country").value(hasItem("Srbija")));

        verify(userService, times(1)).getDoctorsThatCanDoExam(1L, 1L, "2020_02_14");

    }


    @Test
    public void testGetDoctorsThatCanDoExam2() throws Exception {

        ArrayList<User> users = new ArrayList<>();

        Doctor doctor = new Doctor();
        doctor.setId(8L);
        doctor.setFirstName("Nikola");
        doctor.setLastName("Zivanovic");
        doctor.setCountry("Srbija");

        Doctor doctor1 = new Doctor();
        doctor1.setId(9L);
        doctor1.setFirstName("Igor");
        doctor1.setLastName("Ivic");
        doctor1.setCountry("Srbija");

        Doctor doctor2 = new Doctor();
        doctor2.setId(10L);
        doctor2.setFirstName("Igor");
        doctor2.setLastName("Ivic");
        doctor2.setCountry("Srbija");

        users.add(doctor);
        users.add(doctor1);
        users.add(doctor2);

        when(userService.getDoctorsThatCanDoExam(1L, 4L, "2020_02_14")).thenReturn(users);

        mockMvc.perform(get(URL_DOCTORS2))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)));

        verify(userService, times(1)).getDoctorsThatCanDoExam(1L, 4L, "2020_02_14");

    }

}

package ClinicCenterSystem.controller;

import com.clinicCenter.App;
import com.clinicCenter.controller.UserController;
import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserTokenState;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.security.auth.JwtAuthenticationRequest;
import com.clinicCenter.service.UserService;
import com.clinicCenter.service.implementation.UserServiceImpl;
import com.sun.source.doctree.DocTree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private static final String URL_DOCTORS = "/auth/getDoctorsThatCanDoExam/1/1/2020_02_06";
    private static final String URL_DOCTORS2 = "/auth/getDoctorsThatCanDoExam/1/3/2020_02_06";

    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

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
        doctor.setId(3L);
        doctor.setFirstName("Doktor");
        doctor.setLastName("Doktoric");
        doctor.setCountry("Serbistan");
        users.add(doctor);

        when(userService.getDoctorsThatCanDoExam(1L, 1L, "2020_02_06")).thenReturn(users);

        mockMvc.perform(get(URL_DOCTORS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[*].firstName").value(hasItem("Doktor")))
                .andExpect(jsonPath("$.[*].lastName").value(hasItem("Doktoric")))
                .andExpect(jsonPath("$.[*].country").value(hasItem("Serbistan")));

        verify(userService, times(1)).getDoctorsThatCanDoExam(1L, 1L, "2020_02_06");

    }


    @Test
    public void testGetDoctorsThatCanDoExam2() throws Exception {
        mockMvc.perform(get(URL_DOCTORS2))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(0)));
    }

}

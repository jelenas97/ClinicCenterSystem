package ClinicCenterSystem.controller;

import com.clinicCenter.App;
import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserTokenState;
import com.clinicCenter.security.auth.JwtAuthenticationRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


import java.util.Objects;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    private String accessToken;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void login() {
        ResponseEntity<UserTokenState> responseEntity =
                restTemplate.postForEntity("/auth/login",
                        new JwtAuthenticationRequest("pa2@gmail.com", "123123"),
                        UserTokenState.class);
         accessToken = Objects.requireNonNull(responseEntity.getBody()).getAccessToken();
    }

    @Test
    public void testGetDoctorsThatCanDoExam() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", accessToken);

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

        ResponseEntity<Doctor[]> responseEntity =
                restTemplate.exchange("/auth/getDoctorsThatCanDoExam/1/4/2020_02_014", HttpMethod.GET, httpEntity, Doctor[].class);

        Doctor[] doctors = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(3, doctors.length);
        assertEquals("Nikola", doctors[0].getFirstName());

    }
}

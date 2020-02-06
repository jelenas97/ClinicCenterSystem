package ClinicCenterSystem.controller;

import com.clinicCenter.App;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.model.Doctor;
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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"/test.properties"})
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClinicControllerIntegrationTest {

    private String accessToken;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void login() {
        ResponseEntity<UserTokenState> responseEntity =
                restTemplate.postForEntity("/auth/login",
                        new JwtAuthenticationRequest("igor_malesevic@yahoo.com", "123123"),
                        UserTokenState.class);
        accessToken = Objects.requireNonNull(responseEntity.getBody()).getAccessToken();
    }

    @Test
    public void testGetAllClinics() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", accessToken);

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

        ResponseEntity<Clinic[]> responseEntity =
                restTemplate.exchange("/auth/getAllClinics", HttpMethod.GET, httpEntity, Clinic[].class);

        Clinic[] clinics = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(4, clinics.length);
        assertEquals("Dom Bajic", clinics[0].getName());

    }

    @Test
    public void testGetSearchedClinics() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", accessToken);

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

        ResponseEntity<Clinic[]> responseEntity =
                restTemplate.exchange("/auth/getSearchedClinics/1/Vlah/8", HttpMethod.GET, httpEntity, Clinic[].class);
        Clinic[] clinic = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1,clinic.length);

    }

    @Test
    public void testGetSearchedClinicsTwo() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", accessToken);

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

        ResponseEntity<Clinic[]> responseEntity =
                restTemplate.exchange("/auth/getSearchedClinics/1/ /9", HttpMethod.GET, httpEntity, Clinic[].class);
        Clinic[] clinic = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1,clinic.length);

    }
}

package ClinicCenterSystem;

import ClinicCenterSystem.controller.UserControllerTest;
import ClinicCenterSystem.repository.UserRepositoryTest;
import ClinicCenterSystem.service.UserServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserRepositoryTest.class, UserServiceTest.class, UserControllerTest.class})
public class TestSuite {
}

package com.clinicCenter.repository;

import com.clinicCenter.model.ClinicAdministrator;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapperTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.firstName = :first , u.lastName = :last, u.country = :country, u.city =:city, u.address =:adress, u.phone = :phone WHERE u.email = :email")
    int updateUser(String email, String first, String last, String country, String city, String adress, String phone);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.enabled = TRUE WHERE u.id = :id")
    int activateUser(Long id);


    //@Query("SELECT * FROM user where user.email = email ")
    User findByEmail(String email);

    @Query(value = "SELECT concat(first_name,\" \",last_name) from User u WHERE (u.type='CA')", nativeQuery = true)
    Set<String> getAllAdmins();

    @Query(value = "SELECT u FROM User u WHERE u.type = 'DO' ")
    ArrayList<User> getDoctors();

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.averageRating = :averageRating2, u.timesRated = :timesRated WHERE u.id = :id")
    void updateRating(Long id, double averageRating2, int timesRated);

    @Query(value = "SELECT u.id, u.first_name, u.last_name, u.country, u.average_rating FROM users u WHERE u.clinic_id = :id and u.id in (SELECT det.doctor_id FROM doctor_examination_types det WHERE det.type_id = :selectedOption)", nativeQuery = true)
    Collection<UserMapperTwo> getSearchedDoctors(Long selectedOption, Long id);
}

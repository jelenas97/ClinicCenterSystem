package com.clinicCenter.repository;

import com.clinicCenter.model.ClinicAdministrator;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapperTwo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.passwordChanged = TRUE WHERE u.id = :id")
    int changedPassword(Long id);

    User findByEmail(String email);

    @Query(value = "SELECT concat(first_name,\" \",last_name) from User u WHERE (u.type='CA')", nativeQuery = true)
    Set<String> getAllAdmins();

    @Query(value = "SELECT u FROM User u WHERE u.type = 'DO' ")
    ArrayList<User> getDoctors();

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.averageRating = :averageRating2, u.timesRated = :timesRated WHERE u.id = :id")
    void updateRating(Long id, double averageRating2, int timesRated);

    @Query(value = "SELECT * FROM users u WHERE u.clinic_id = :id and u.id in (SELECT det.doctor_id FROM doctor_examination_types det WHERE det.type_id = :selectedOption)", nativeQuery = true)
    Collection<User> getSearchedDoctors(Long selectedOption, Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM db.user_authority WHERE user_id = :id", nativeQuery = true)
    void deleteFromUserAuthority(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM db.doctor_examination_types WHERE doctor_id = :id", nativeQuery = true)
    void deleteFromDoctorExaminationType(Long id);

    @Query(value = "SELECT * FROM db.users u WHERE u.type = 'DO' and u.clinic_id in (SELECT clinic_id FROM db.users uu WHERE uu.id = :id)", nativeQuery = true)
    ArrayList<User> getDoctorsFromClinic(Long id);

    @Query(value = "SELECT COUNT(*) FROM db.medical_examination me WHERE me.confirmed = 1 and me.doctor_id = :id", nativeQuery = true)
    Integer hasExam(Long id);

    @Query(value = "SELECT * FROM db.users u WHERE u.type = 'DO' AND u.clinic_id = :clinicId AND u.id != :doctorId" +
            " AND u.id not in (SELECT me.doctor_id FROM db.medical_examination me WHERE me.date BETWEEN :date1 AND :date2)" +
            " AND u.id not in (SELECT o.doctor_id FROM db.operation o WHERE o.date BETWEEN :date1 AND :date2)" +
            " AND u.id not in (SELECT mer.doctor_id FROM db.medical_examination_request mer WHERE mer.date BETWEEN :date1 AND :date2)" +
            " AND u.id not in (SELECT opq.doctor_id FROM db.operation_request opq WHERE opq.date BETWEEN :date1 AND :date2)" +
            " AND u.id not in (SELECT uu.id FROM db.users uu INNER JOIN db.doctors_at_operation dao ON uu.id = dao.doctor_id WHERE dao.operation_id not in (SELECT oo.id FROM db.operation oo WHERE oo.date BETWEEN :date1 AND :date2))", nativeQuery = true)
    ArrayList<User> getAvailableDoctorsForOperation(Date date1, Date date2, Long clinicId, Long doctorId);

    @Query(value = "SELECT * FROM users u WHERE u.clinic_id = :id AND u.id in (SELECT det.doctor_id FROM doctor_examination_types det WHERE det.type_id = :selectedOption) AND u.id NOT IN (SELECT al.user_id FROM db.annual_leave_request al WHERE :datee BETWEEN al.leave_date AND al.return_date)", nativeQuery = true)
    Collection<User> getDoctorsThatCanDoExam(Long selectedOption, Long id, String datee);

    @Query(value = "SELECT * FROM users u WHERE u.clinic_id = :id AND u.id != :doctorId AND u.id in (SELECT det.doctor_id FROM doctor_examination_types det WHERE det.type_id = :selectedOption) AND u.id NOT IN (SELECT al.user_id FROM db.annual_leave_request al WHERE :datee BETWEEN al.leave_date AND al.return_date)", nativeQuery = true)
    Collection<User> getDoctorsThatCanDoExamWithoutSelected(Long selectedOption, Long id, String datee, Long doctorId);

    /*@Query(value = "SELECT * FROM db.users u WHERE u.type = 'DO' and u.clinic_id in (SELECT clinic_id FROM db.users uu WHERE uu.id = :adminId)", nativeQuery = true)
    Collection<UserMapperTwo> getAvailableDoctors(Long adminId);*/
}

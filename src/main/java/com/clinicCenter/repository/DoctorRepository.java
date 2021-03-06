package com.clinicCenter.repository;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapperTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Set;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT u.id, u.first_name, u.last_name, u.country, u.average_rating FROM users u WHERE u.clinic_id = :clinicId and lower(u.first_name) like %:firstName% and lower(u.last_name) like %:lastName% and u.average_rating >= :rating and u.id in (SELECT det.doctor_id FROM doctor_examination_types det WHERE det.type_id = :typeId)", nativeQuery = true)
    Set<UserMapperTwo> getSearchedExtended(String firstName, String lastName, double rating, Integer typeId, Integer clinicId);

    @Query(value = "SELECT * FROM db.users u WHERE lower(u.first_name) like %:firstName% and lower(u.last_name) like %:lastName% and u.average_rating >= :rating and u.type = 'DO' and u.clinic_id in (SELECT clinic_id FROM db.users uu WHERE uu.id = :caId)", nativeQuery = true)
    ArrayList<Doctor> getSearchedFromClinic(String firstName, String lastName, double rating, Integer caId);

    @Query(value = "SELECT COUNT(*) FROM db.medical_examination me WHERE me.confirmed = 1 and me.doctor_id = :id", nativeQuery = true)
    Integer hasExam(Long id);

    @Query(value = "SELECT COUNT(*) FROM db.medical_examination_request mer WHERE mer.doctor_id = :id", nativeQuery = true)
    int hasExamRequest(Long id);

    @Query(value = "SELECT COUNT(*) FROM db.operation o WHERE o.doctor_id = :id", nativeQuery = true)
    int hasOperation(Long id);

    @Query(value = "SELECT COUNT(*) FROM db.operation_request orq WHERE orq.doctor_id = :id", nativeQuery = true)
    int hasOperationRequest(Long id);
}

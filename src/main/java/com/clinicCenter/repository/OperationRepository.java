package com.clinicCenter.repository;

import com.clinicCenter.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

import java.util.Collection;
import java.util.Date;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query(value = "SELECT * FROM db.operation mo WHERE mo.doctor_id = :id", nativeQuery = true)
    List<Operation> getAllByDoctorId(Long id);

    @Query(value = "SELECT * FROM db.operation o WHERE o.doctor_id = :doctorId AND o.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<Operation> getDoctorsOperationsByIdAndDate(Long doctorId, Date date1, Date date2);

    @Query(value = "SELECT * FROM db.operation o INNER JOIN db.doctors_at_operation dao ON o.id = dao.operation_id WHERE dao.doctor_id = :doctorId AND o.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<Operation> getDoctorsOperationAttend(Long doctorId, Date date1, Date date2);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Override
    Operation save(Operation operation);

    @Query(value = "SELECT * FROM db.operation o WHERE o.patient_id = :patientId AND o.date < :datee", nativeQuery = true)
    Collection<Operation> getAllOperationsPatientCanRate(Long patientId, Date datee);

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.operation o SET doctor_rated = true WHERE o.id = :examId", nativeQuery = true)
    void rateDoctor(Long examId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.operation o SET clinic_rated = true WHERE o.id = :examId", nativeQuery = true)
    void rateClinic(Long examId);
}

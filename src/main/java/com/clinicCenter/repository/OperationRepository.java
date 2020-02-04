package com.clinicCenter.repository;

import com.clinicCenter.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query(value = "SELECT * FROM db.operation o WHERE o.doctor_id = :doctorId AND o.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<Operation> getDoctorsOperationsByIdAndDate(Long doctorId, Date date1, Date date2);

    @Query(value = "SELECT * FROM db.operation o INNER JOIN db.doctors_at_operation dao ON o.id = dao.operation_id WHERE dao.doctor_id = :doctorId AND o.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<Operation> getDoctorsOperationAttend(Long doctorId, Date date1, Date date2);
}

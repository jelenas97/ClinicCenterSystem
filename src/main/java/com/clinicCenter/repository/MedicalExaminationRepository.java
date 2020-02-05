package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;


public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination SET confirmed = true WHERE id = :id", nativeQuery = true)
    void confirm(Long id);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.mer_id = :roomId", nativeQuery = true)
    Collection<MedicalExamination> getAllFromRoom(Long roomId);


    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.predefined = true and me.confirmed = false", nativeQuery = true)
    Collection<MedicalExamination> getAllPredefinedMedicalExaminations();

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination SET confirmed = true, patient_id = :patientId WHERE id = :examinationId", nativeQuery = true)
    void schedulePredefinedMedicalExamination(Long examinationId, Long patientId);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.patient_id = :patientId and me.confirmed = true", nativeQuery = true)
    Collection<MedicalExamination> getAllExaminationsPatientCanRate(Long patientId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination me SET doctor_rated = true WHERE me.id = :examId", nativeQuery = true)
    void rateDoctor(Long examId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination me SET clinic_rated = true WHERE me.id = :examId", nativeQuery = true)
    void rateClinic(Long examId);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.doctor_id = :id", nativeQuery = true)
    Collection<MedicalExamination> getAllFromDoctor(Long id);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.doctor_id = :doctorId AND me.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<MedicalExamination> getDoctorsExaminationsByIdAndDate(Long doctorId, Date date1, Date date2);

    @Query(value = "SELECT count(me.id) FROM db.medical_examination me WHERE me.clinic_id = (SELECT u.clinic_id FROM db.users u where u.id = :id) and me.date between :start and :end", nativeQuery = true)
    int getExamsBetween(Long id, Date start, Date end);

    @Query(value = "SELECT ifnull(sum(me.price),0) FROM db.medical_examination me WHERE me.clinic_id = (SELECT u.clinic_id FROM db.users u where u.id = :id) and me.date between :start and :end", nativeQuery = true)
    Long getIncomeBetween(Long id, Date start, Date end);

    @Query(value = "SELECT count(me.id) FROM db.medical_examination me WHERE me.patient_id = :patientId and me.doctor_id = :doctorId and me.date between :start and :end", nativeQuery = true)
    int canStartExam(Date start, Date end, Long patientId, Long doctorId);

    @Query(value = "SELECT count(me.id) FROM db.medical_examination me WHERE me.patient_id = :patientId and me.doctor_id = :doctorId and me.date <= :end", nativeQuery = true)
    int examInPast(Date end, Long patientId, Long doctorId);

    @Query(value = "SELECT count(me.id) FROM db.medical_examination me WHERE me.patient_id = :patientId and me.clinic_id = (select u.clinic_id from users u where u.id = :nurseId) and me.date <= :end", nativeQuery = true)
    int nurseAndPatient(Date end, Long patientId, Long nurseId);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.patient_id = :patientId and me.doctor_id = :doctorId and me.date between :start and :end", nativeQuery = true)
    MedicalExamination getStartExam(Date start, Date end, Long patientId, Long doctorId);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Override
    MedicalExamination save(MedicalExamination medicalExamination);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.clinic_id = :clinicId AND me.predefined = TRUE", nativeQuery = true)
    Collection<MedicalExamination> getClinicsPredefinedExaminations(Long clinicId);
}

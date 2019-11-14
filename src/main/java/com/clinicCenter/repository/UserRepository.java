package com.clinicCenter.repository;

import com.clinicCenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.firstName = :first , u.lastName = :last, u.country = :country, u.city =:city, u.address =:adress, u.phone = :phone WHERE u.id = :id")
    int updateMedicalStaff(Long id, String first, String last, String country, String city, String adress, String phone);
}

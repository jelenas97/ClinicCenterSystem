package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class AnnualLeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date leaveDate;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date returnDate;

    @Column
    private String reason;

    @Column
    private String flag;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column
    private Boolean approved = false;


    @Transient
    private Long userId;

    @Transient
    private String userRole;

}

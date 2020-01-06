package com.clinicCenter.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Operation {
    public Operation() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Double duration;

    @ManyToOne
    private OperationRoom room;
    //private Set<Doctor> doctors;
   /* private Double price;
    private Double discount;
    */

}

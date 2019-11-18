package com.clinicCenter.model;

import lombok.*;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Builder
public class Operation {
    private Long id;
    private Date date;
    private Double duration;
    private OperationRoom room;
    private Set<Doctor> doctors;
   /* private Double price;
    private Double discount;
    */

}

package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
@Builder
public class Operation {
    private long id;
    private Date date;
    private double duration;
    private OperationRoom room;
    private Collection<User> doctors;
   /* private double price;
    private MedicalExaminationType type;
    private double discount;
    */

}

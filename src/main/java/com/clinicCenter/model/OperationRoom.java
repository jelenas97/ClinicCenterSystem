package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.Set;

@Data
@Builder
public class OperationRoom {
    private Long id;
    private String name;
    private Integer number;
    private Set<Operation> operations;

}

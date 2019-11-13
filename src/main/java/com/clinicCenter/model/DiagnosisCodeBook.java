package com.clinicCenter.model;

import java.util.Hashtable;

public class DiagnosisCodeBook {
    private Long id;
    private String name;
    private Hashtable<Integer,Diagnosis> codebook;
}

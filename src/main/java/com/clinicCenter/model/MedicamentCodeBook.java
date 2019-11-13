package com.clinicCenter.model;

import java.util.Hashtable;

public class MedicamentCodeBook {
    private Long id;
    private String name;
    private Hashtable<Integer,Medicament> codebook; //ne dozvoljava null vrednosti i tread-safe je, a hashmapa dozvoljava null i nije thread-safe
    private ClinicCenterAdministrator clinicCenterAdministrator;
}

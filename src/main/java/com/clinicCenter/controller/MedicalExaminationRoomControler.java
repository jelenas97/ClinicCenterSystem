package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationRoomControler {
    @Autowired
    private MedicalExaminationRoomService medicalExaminationRoomService;

    @GetMapping("/rooms")
    public List<MedicalExaminationRoom> getAll(){
        List<MedicalExaminationRoom> rooms = medicalExaminationRoomService.getAll();
        return rooms;
    }

}

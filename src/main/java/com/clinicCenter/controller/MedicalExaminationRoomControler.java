package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/rooms/removeRoom/{id}")
    public void removeById(@PathVariable Long id) {
        MedicalExaminationRoom room = this.medicalExaminationRoomService.getById(id);
        this.medicalExaminationRoomService.removeById(id);
    }

    @PutMapping("/rooms")
    public int updateMedicalExamRoom( @RequestBody MedicalExaminationRoom room) {
        return medicalExaminationRoomService.updateRoom(room);
    }

}

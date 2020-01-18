package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.model.OperationRoom;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationRoomController {
    @Autowired
    private MedicalExaminationRoomService medicalExaminationRoomService;

    @GetMapping("/medicalExamRooms")
    public List<MedicalExaminationRoom> getAll(){
        List<MedicalExaminationRoom> rooms = medicalExaminationRoomService.getAll();
        return rooms;
    }

    @DeleteMapping(value = "/medicalExamRooms/removeRoom/{id}")
    public void removeById(@PathVariable Long id) {
        MedicalExaminationRoom room = this.medicalExaminationRoomService.getById(id);
        this.medicalExaminationRoomService.removeById(id);
    }

    @PutMapping("/medicalExamRooms")
    public int updateMedicalExamRoom( @RequestBody MedicalExaminationRoom room) {
        return medicalExaminationRoomService.updateRoom(room);
    }

    @PostMapping("/medicalExamRooms")
    public void addMedicalExamRoom(@RequestBody MedicalExaminationRoom room){
        medicalExaminationRoomService.save(room);
    }

    @GetMapping("/medicalExamRooms/search")
    @ResponseBody
    public Set<MedicalExaminationRoom> getSearched(@RequestParam(name = "name") String name, @RequestParam(name = "number") String number) {

        Set<MedicalExaminationRoom> rooms = null;
        if(number.equals("undefined") || number.equals("null")) {
            rooms = medicalExaminationRoomService.getRoomsName(name);
        } else {
            rooms = medicalExaminationRoomService.getRooms(name, Integer.parseInt(number));
        }
        return rooms;
    }

}

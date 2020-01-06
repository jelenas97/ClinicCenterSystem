package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRoom;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.OperationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OperationRoomController {

    @Autowired
    private OperationRoomService operationRoomService;

    @GetMapping("/operationRooms")
    public List<OperationRoom> getAll(){
        List<OperationRoom> rooms = operationRoomService.getAll();
        return rooms;
    }

    @DeleteMapping(value = "/operationRooms/removeRoom/{id}")
    public void removeById(@PathVariable Long id) {
        OperationRoom room = this.operationRoomService.getById(id);
        this.operationRoomService.removeById(id);
    }

    @PutMapping("/operationRooms")
    public int updateOperationRoom( @RequestBody OperationRoom room) {
        return operationRoomService.updateRoom(room);
    }

    @PostMapping("/operationRooms")
    public void addOperationRoom(@RequestBody OperationRoom room){
        operationRoomService.save(room);
    }

}
